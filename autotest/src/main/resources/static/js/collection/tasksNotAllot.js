$(function () {
    $("#jqGrid").jqGrid({
        url: baseURL + 'manager/collection/tasksNotAllot',
        datatype: "json",
        colModel: [
            { label: '标的ID', name: 'borrowId', key: true, hidden:true},
            { label: '客户id', name: 'userId', hidden:true},
            { label: '客户姓名', name: 'userName', sortable: false},
            { label: '手机号码', name: 'telNo', sortable: false},
            { label: '还款状态', name: 'statusText', sortable: false, formatter : genStatusTextColor},
            { label: '还款金额', name: 'repayAmount',sortable: false},
            { label: '应还款日期', name: 'cycDate', sortable: false, formatter:"date",formatoptions: {srcformat:'Y-m-d',newformat:'Y-m-d'}}
        ],
        viewrecords: true,
        height: 385,
        rowNum: 15,
        rowList : [15,30,50],
        rownumbers: true,
        rownumWidth: 25,
        autowidth:true,
        multiselect: true,
        pager: "#jqGridPager",
        jsonReader : {
            root: "page.dataList",
            page: "page.pageNum",
            total: "page.totalPage",
            records: "page.totalCount"
        },
        prmNames : {
            page:"page",
            rows:"limit",
            order: "order"
        },
        gridComplete:function(){
            //隐藏grid底部滚动条
            $("#jqGrid").closest(".ui-jqgrid-bdiv").css({ "overflow-x" : "hidden" });
        },
        loadComplete:function(xhr) {
            vm.htmlShow.notAllotCount = xhr.notAllotCount;
            vm.htmlShow.allotedCount = xhr.allotedCount;
            //加载勾选历史
            if (vm.borrowSelected.length > 0 && xhr.page.dataList.length > 0) {
                var _list = xhr.page.dataList;
                for (var i = 0; i < _list.length; i++) {
                    for (var j = 0; j < vm.borrowSelected.length; j++) {
                        if (_list[i].borrowId == vm.borrowSelected[j].borrowId) {
                            $("#jqGrid").jqGrid('setSelection', _list[i].borrowId, false);
                            break;
                        }
                    }
                }
            }
        },
        onSelectAll: function(rowIds, status) {
            changeSelectData(rowIds, status, true);
        },
        onSelectRow: function(rowId, status) {
            changeSelectData(rowId, status, false);
        }
    });
    $("#jqGrid").jqGrid('navGrid', '#jqGridPager', {
        edit : false,
        add : false,
        del : false,
        search:false,
        refresh:false
    });
    $("#jqGrid").jqGrid('navButtonAdd', '#jqGridPager', {
        caption : "分配",
        buttonicon: 'glyphicon glyphicon-plus',
        onClickButton : vm.allotLayer
    });
});

var vm = new Vue({
    el:'#rrapp',
    data:{
        htmlShow:{//html页面动态展示的变量
            notAllotCount : 0,
            allotedCount : 0,
            selectedNames : '',
            selectedNamesAll : '',
            selectedNum : 0,
            showMore : false
        },
        isAllotFirstNavGrid : true,
        q:{

        },
        allotQ:{
            userName:null
        },
        borrowSelected:[]
    },
    methods: {
        query: function () {
            vm.reload();
        },
        reload: function (event) {
            var page = $("#jqGrid").jqGrid('getGridParam','page');
            var cycDateBegin = $("#cycDateBegin").val();
            var cycDateEnd = $("#cycDateEnd").val();
            if (!validateOverDueDaysInput(vm.q.overDueDaysBegin, vm.q.overDueDaysEnd)) {
                return false;
            }
            $("#jqGrid").jqGrid('setGridParam',{
                postData:{
                    userName: vm.q.userName,
                    repayStatue: vm.q.status,
                    repayBDate: cycDateBegin,
                    repayEDate: cycDateEnd,
                    mobile: vm.q.telNo,
                    overdueMinDay: vm.q.overDueDaysBegin,
                    overdueMaxDay: vm.q.overDueDaysEnd},
                page:page
            }).trigger("reloadGrid");
        },
        showSelectedNames: function(){
            layer.open({
                type: 1,
                skin: 'layui-layer-my',
                title: "已选择客户",
                area: ['550px', '270px'],
                shadeClose: false,
                content: jQuery("#selectedNames"),
                btn: ['确定']
            });
        },
        allot : function(type) {
            //分配
            $("#allot").jqGrid({
                url: baseURL + 'manager/collection/trackerList',
                datatype: "json",
                colModel: [
                    { label: '用户ID', name: 'userId', key: true, hidden:true},
                    { label: '跟踪人用户名', name: 'userName', sortable: false},
                    { label: '跟踪人姓名', name: 'nickName', sortable: false},
                    { label: '工号', name: 'jobNum', sortable: false},
                    { label: '今日已分配', name: 'allocateToday', sortable: false},
                    { label: '待处理', name: 'noReslove', sortable: false}
                ],
                viewrecords: true,
                height: 385,
                rowNum: 15,
                rowList : [15,30,50],
                rownumbers: true,
                rownumWidth: 25,
                autowidth:true,
                multiselect: true,
                multiboxonly:true,  //单选
                pager: "#allotPager",
                jsonReader : {
                    root: "page.dataList",
                    page: "page.pageNum",
                    total: "page.totalPage",
                    records: "page.totalCount"
                },
                prmNames : {
                    page:"page",
                    rows:"limit",
                    order: "order"
                },
                gridComplete:function() {
                    //隐藏grid底部滚动条
                    $("#allot").closest(".ui-jqgrid-bdiv").css({ "overflow-x" : "hidden" });
                }
            });
        },
        allotQuery : function() {
            var page = $("#allot").jqGrid('getGridParam','page');
            $("#allot").jqGrid('setGridParam',{
                postData:{'nickName': vm.allotQ.nickName},
                page:page
            }).trigger("reloadGrid");
        },
        allotLayer : function() {
            if (vm.borrowSelected.length <= 0) {
                alert("请选择需要分配的记录");
                return;
            }
            vm.allot();
            layer.open({
                type: 1,
                skin: 'layui-layer-my',
                title: "已选择客户",
                area: ['800px', '600px'],
                shadeClose: false,
                content: $("#allotDiv"),
                btn: ['确定', '取消'],
                btn1:function() {
                    var rowid = getSelectedRow("allot");
                    if (rowid) {
                        doAllot(rowid);
                    }
                },
                btnAlign: 'l'
            });
            if (vm.isAllotFirstNavGrid) {
                $("#allot").jqGrid('navGrid', '#allotPager', {
                    edit : false,
                    add : false,
                    del : false,
                    search : false
                });
                vm.isAllotFirstNavGrid = false;
            }
        },
        toTasks : function () {
            parent.location.href = baseURL + 'index.html#collection/tasks.html';
        }
    }
});

/**
 * 处理选中客户展示内容
 */
function changeSelectData(ids, status, isSelectAll) {
    var rowIds = null;
    if (isSelectAll) {
        rowIds = ids;
    } else {
        rowIds = [];
        rowIds.push(ids);
    }

    if (rowIds.length > 0) {
        if (status) {
            //选中状态
            for (var index = 0; index < rowIds.length; index++) {
                var hasValue = false;
                for (var i = 0; i < vm.borrowSelected.length; i++) {
                    if (vm.borrowSelected[i].borrowId == rowIds[index]) {
                        hasValue = true;
                        break;
                    }
                }
                if (!hasValue) {
                    var rowData = $("#jqGrid").jqGrid('getRowData', rowIds[index]);

                    if (rowData) {
                        var tmpObj = {};
                        if (rowData.userName) {
                            tmpObj.name = rowData.userName;
                        }
                        if (rowData.borrowId) {
                            tmpObj.borrowId = rowData.borrowId;
                        }
                        vm.borrowSelected.push(tmpObj);
                    }
                }
            }
        } else {
            //反选状态
            var tmpBorrowSelected = [];
            for (var i = 0; i < vm.borrowSelected.length; i++) {
                var isFound = false;
                for (var index = 0; index < rowIds.length; index++) {
                    if (vm.borrowSelected[i].borrowId == rowIds[index]) {
                        isFound = true;
                        break;
                    }
                }
                if (!isFound) {
                    tmpBorrowSelected.push(vm.borrowSelected[i]);
                }
            }
            vm.borrowSelected = tmpBorrowSelected;
        }
    }
    var names = [];
    for (var i = 0; i < vm.borrowSelected.length; i++) {
        names.push(vm.borrowSelected[i].name);
    }
    vm.htmlShow.selectedNum = vm.borrowSelected.length;
    vm.htmlShow.selectedNamesAll = names.join(",");
    if (vm.htmlShow.selectedNamesAll.length > 100) {
        vm.htmlShow.selectedNames = vm.htmlShow.selectedNamesAll.substr(0, 100) + '...';
        vm.htmlShow.showMore = true;
    } else {
        vm.htmlShow.selectedNames = vm.htmlShow.selectedNamesAll;
        vm.htmlShow.showMore = false;
    }
}

/**
 * 在选择某行记录进行分配
 * @param idSelector
 * @returns {*}
 */
function getSelectedRow(idSelector) {
    var grid = $("#" + idSelector);
    var rowKey = grid.getGridParam("selrow");
    if(!rowKey){
        alert("请选择一条记录");
        return ;
    }

    var selectedIDs = grid.getGridParam("selarrrow");
    if(selectedIDs.length > 1){
        alert("只能选择一条记录");
        return ;
    }

    return selectedIDs[0];
}

/**
 * 执行分配
 * @param trackerId
 */
function doAllot(trackerId) {
    var borrowIds = [];
    for (var i = 0; i < vm.borrowSelected.length; i++) {
        borrowIds.push(vm.borrowSelected[i].borrowId);
    }
    confirm('确定要分配给选中的用户？', function(){
        $.ajax({
            type: "POST",
            url: baseURL + "manager/collection/task/allot",
            data: { trackerId: trackerId, borrowIds: borrowIds},
            success: function(data){
                if(data.code === 0){
                    var msg = '';
                    if (data.result) {
                        var _result = data.result;
                        if (_result.successIds) {
                            msg += '分配成功' + _result.successIds.length + '条记录. <br/>';
                        }
                        if (_result.existIds && _result.existIds.length > 0) {
                            msg += '已经分配('+ _result.existIds.length +'):<br/>';
                            for (var i = 0; i < _result.existIds.length; i++) {
                                var rowData = $("#jqGrid").jqGrid('getRowData', _result.existIds[i]);
                                if (rowData) {
                                    msg += _result.existIds[i] + '(' + rowData.userName + '), ';
                                }
                            }
                        }
                        if (_result.failIds && _result.failIds.length > 0) {
                            msg += '分配异常(' + _result.failIds.length + '):<br/>';
                            for (var i in _result.failIds) {
                                var rowData = $("#jqGrid").jqGrid('getRowData', _result.failIds[i]);
                                if (rowData) {
                                    msg += _result.failIds[i] + '(' + rowData.userName + '), ';
                                }
                            }
                        }
                    }
                    if (msg.length <= 0) {
                        msg = '操作成功';
                    }
                    alert(msg, function() {parent.location.reload();})
                } else {
                    alert(data.msg);
                }
            }
        });
    });
}