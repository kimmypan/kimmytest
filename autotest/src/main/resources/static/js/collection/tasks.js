$(function () {
    showSelectUserName();
    $("#jqGrid").jqGrid({
        url: baseURL + "manager/collection/allocateWithoutResloveList",
        datatype: "json",
        colModel: [
            {label: 'borrowId', name: 'borrowId', key: true, hidden: true},
            {label: 'userId', name: 'userId', hidden: true},
            {label: 'trackerId', name: 'trackerId', hidden: true},
            {label: '用户名', name: 'userName'},
            {label: '客户姓名', name: 'realName'},
            {label: '手机号码', name: 'telNo'},
            {label: '还款状态', name: 'statusText', formatter : genStatusTextColor},
            {label: '应还款金额', name: 'repayAmount'},
            {label: '应还款日期', name: 'cycDate'},
            {label: '分配时间', name: 'createTime'},
            {label: '当前跟踪人', name: 'trackerName'}
        ],
        viewrecords: true,
        height: 385,
        rowNum: 10,
        rowList: [10, 30, 50],
        rownumbers: true,
        rownumWidth: 25,
        autowidth: true,
        multiselect: true,
        pager: "#jqGridPager",
        jsonReader: {
            root: "page.dataList",
            page: "page.pageNum",
            total: "page.totalPage",
            records: "page.totalCount"
        },
        prmNames: {
            page: "page",
            rows: "limit",
            order: "order"
        },
        gridComplete: function () {
            //隐藏grid底部滚动条
            $("#jqGrid0").closest(".ui-jqgrid-bdiv").css({"overflow-x": "hidden"});
        },
        loadComplete:function(xhr) {
            //加载勾选历史
            if (vm.borrowIds.length > 0 && xhr.page.dataList.length > 0) {
                var _list = xhr.page.dataList;
                for (var i = 0; i < _list.length; i++) {
                    for (var j = 0; j < vm.borrowIds.length; j++) {
                        if (_list[i].borrowId == vm.borrowIds[j]) {
                            $("#jqGrid").jqGrid('setSelection', _list[i].borrowId, true);
                            break;
                        }
                    }
                }
            }
        },
        onSelectAll: function(rowIds, status) {
            changeSelectData(rowIds, status, true);
        },
        onSelectRow:function(rowIds, status) {
            changeSelectData(rowIds, status, false);
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
        caption : "移交",
        buttonicon: 'glyphicon glyphicon-plus',
        onClickButton : vm.traferLayer
    });
});
var vm = new Vue({
    el:'#rrapp',
    data:{
        showList:true,
        q:{
            userName: null,
            repayStatue:null,
            mobile:null,
            overdueMinDay:null,
            overdueMaxDay:null,
            trackerName:null
        },
        traferQ:{
            nickName:null
        },
        borrowIds:[],
        trackerIds:[],
        userNames:[],
        namesStr:"",
        selectedNumber: 0,
        newTrackerId: null
    },
    beforeCreate: function () {
        var url = baseURL + 'manager/collection/countTask';
        $.get(url, function (data) {
            $("#notAllotCount").html(data.notAllotCount);
            $("#allotedCount").html(data.allotedCount);
        });
    },
    methods: {
        query: function () {
            vm.reload();
        },
        reload: function () {
            var page = $("#jqGrid").jqGrid('getGridParam','page');
            if (!validateOverDueDaysInput(vm.q.overdueMinDay, vm.q.overdueMaxDay)) {
                return false;
            }
            $("#jqGrid").jqGrid('setGridParam',{
                postData:{
                    userName: vm.q.userName,
                    repayStatue: vm.q.repayStatue,
                    repayBDate: $("#repayBDate").val(),
                    repayEDate: $("#repayEDate").val(),
                    mobile: vm.q.mobile,
                    overdueMinDay: vm.q.overdueMinDay,
                    overdueMaxDay: vm.q.overdueMaxDay,
                    allocateSDate: $("#allocateSDate").val(),
                    allocateEDate: $("#allocateEDate").val(),
                    trackerName: vm.q.trackerName
                },
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
        trafer : function(type) {
            //移交
            $("#trafer").jqGrid({
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
                pager: "#traferPager",
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
                    $("#trafer").closest(".ui-jqgrid-bdiv").css({ "overflow-x" : "hidden" });
                }
            });
        },
        traferQuery : function() {
            var page = $("#trafer").jqGrid('getGridParam','page');
            $("#trafer").jqGrid('setGridParam',{
                postData:{'nickName': vm.traferQ.nickName},
                page:page
            }).trigger("reloadGrid");
        },
        traferLayer : function() {
            if (vm.borrowIds.length <= 0 || vm.trackerIds.length<=0) {
                alert("请选择需要移交的用户借款记录");
                return;
            }
            vm.trafer();
            layer.open({
                type: 1,
                skin: 'layui-layer-my',
                title: "已选择客户",
                area: ['800px', '600px'],
                shadeClose: false,
                content: $("#traferDiv"),
                btn: ['确定', '取消'],
                yes: function(index, layero){
                    var rowid = changeTraferSelectData();
                    if (rowid){
                        doTrafer(rowid);
                    }
                }
            });
        },
        resetBTIds : function() {
            parent.location.reload();
        },
        toTasksNoAllot:function(){
            parent.location.href = baseURL + 'index.html#collection/tasksNotAllot.html';
        }
    }
});
/**
 * 处理选中客户展示内容
 */
function changeSelectData(ids,status,isArray) {
    //选中行的id（borrowId）数组
    var keys = [];
    if (isArray){
        keys = ids;
    }else {
        keys.push(ids);
    }

    if (keys.length > 0) {
        for (var i = 0; i < keys.length; i++) {
            if (status){//选中状态
                var rowData = $("#jqGrid").jqGrid('getRowData',keys[i]);
                if (rowData) {
                    if ($.inArray(rowData.borrowId, vm.borrowIds) == -1) {//不包含在原数组
                        //添加选中值
                        vm.borrowIds.push(rowData.borrowId);
                        vm.trackerIds.push(rowData.trackerId);
                        vm.userNames.push(rowData.realName);
                    }
                }
            } else{//未选中状态
                if ($.inArray(keys[i], vm.borrowIds) != -1){//包含在原数组
                    //新建数组
                    var newBorrowIds = [];
                    var newTrackerIds = [];
                    var newUserNames = [];
                    for(var j = 0; j<vm.borrowIds.length;j++){
                        if (vm.borrowIds[j]!=keys[i]){//未选中的值不加入新数组
                            newBorrowIds.push(vm.borrowIds[j]);
                            newTrackerIds.push(vm.trackerIds[j]);
                            newUserNames.push(vm.userNames[j]);
                        }
                    }
                    vm.borrowIds = newBorrowIds;
                    vm.trackerIds = newTrackerIds;
                    vm.userNames = newUserNames;
                }
            }
        }

    }
    vm.namesStr = vm.userNames.join(",");
    showSelectUserName();
    vm.selectedNumber= vm.borrowIds.length;
}
function changeTraferSelectData(){
    //选择一条记录
    var grid = $("#trafer");
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
function doTrafer(rowid){
    confirm('确定移交？', function(){
        $.ajax({
            type: "POST",
            url: baseURL + "manager/collection/transferTasks",
            data: {
                borrowIds: vm.borrowIds,
                trackerIds: vm.trackerIds,
                trackerId: rowid
            },
            success: function(r){
                if(r.code == 0){
                    alert(r.msg, function(){
                        vm.borrowIds = [];
                        vm.trackerIds = [];
                        vm.userNames = [];
                        layer.closeAll();
                        vm.reload();
                    });
                }else{
                    alert(r.msg);
                }
            }
        });
    });
}

function showSelectUserName() {
    if (vm.namesStr.length > 100) {
        $("#showMoreA").css({"display" : ""});
        $("#selectSpan").html(vm.namesStr.substr(0, 100) + '...');
    } else {
        $("#showMoreA").css({"display" : "none"});
        $("#selectSpan").html(vm.namesStr);
    }
    $("#selectSpan").html(vm.namesStr.length > 100 ? vm.namesStr.substr(0, 100) + '...' : vm.namesStr);

    $("#selectedNamesCnt").html(vm.namesStr);
}