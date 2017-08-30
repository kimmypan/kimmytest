$(function () {
    var trackerId = $.getUrlParam("trackerId");
    var urlParams = "";
    if (trackerId!=null){
        vm.trackerIdFromItemDetails=trackerId;
        urlParams = "?trackerId="+trackerId;
    }
    getTrackerStatistics();
    function getTrackerStatistics(){
        var url = baseURL + 'manager/collection/trackerStatistics'+urlParams;
        $.get(url, function (data) {
            if (data.code==0) {
                vm.dto = data.trackerStatistics;
            }else {
                alert(data.msg);
            }
        });
    }
    $("#jqGrid").jqGrid({
        url: baseURL + 'manager/collection/traceDetailsForOne'+urlParams,
        datatype: "json",
        colModel: [
            {label: 'borrowId', name: 'borrowId', width: 30, key: true, hidden: true},
            {label: 'userId', name: 'userId', width: 30, hidden: true},
            {label: '客户姓名', name: 'realName', width: 65},
            {label: '手机号码', name: 'telNo', width: 75},

            {label: '还款状态', name: 'statusText', width: 70, formatter: formatterStatus},
            {
                label: '应还款日期',
                name: 'cycDate',
                width: 100,
                formatter: "date",
                formatoptions: {srcformat: 'Y-m-dTH:i:s', newformat: 'Y-m-d H:i:s'}
            },
            {label: '回款金额', name: 'repayAmount', width: 100},


            {label: '待回款金额', name: 'taskAmount', width: 120},
            {label: '回款类型', name: 'repayType', width: 90},
            {
                label: '分配时间',
                name: 'createTime',
                width: 100,
                formatter: "date",
                formatoptions: {srcformat: 'Y-m-dTH:i:s', newformat: 'Y-m-d H:i:s'}
            },
            {label: '操作', name: 'borrowId', width: 120, formatter: formatterOperation}
        ],
        viewrecords: true,
        height: 385,
        rowNum: 10,
        rowList: [10, 30, 50],
        rownumbers: true,
        rownumWidth: 25,
        autowidth: true,
        multiselect: false,
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
            $("#jqGrid").closest(".ui-jqgrid-bdiv").css({"overflow-x": "hidden"});
        },
        loadComplete:function(xhr) {
            if (xhr.code!=0){
                alert(xhr.msg);
            }
        }
    });


    function formatterStatus(cellvalue, options, rowObject) {
        if(rowObject.status==6){
            return "<span style='color: green'>" + cellvalue + "</span>";
        }else{
            return "<span style='color: red'>" + cellvalue + "</span>";
        }
    }
    function formatterOperation(cellvalue, options, rowObject) {
        var borrowId = "\""+rowObject.borrowId+"\"";
        var userId="\""+rowObject.userId+"\"";
        return "<a class='btn btn-success' href='javascript:;' onclick='toDetail("+borrowId+","+userId+")'>标的详情</a>";
    }

});

var vm = new Vue({
    el: '#rrapp',
    data: {
        q: {

        },
        dto: {},
        trackerIdFromItemDetails:null
    },
    methods: {
        exportData: function () {
            var params = $.param(vm.q);
            var urlParams = ""
            if (vm.trackerIdFromItemDetails!=null) {
                urlParams = "trackerId=" + vm.trackerIdFromItemDetails + "&";
            }
            var url= baseURL + 'manager/export/traceDetailsForOne.html?'+urlParams+params;
            $('<form method="POST" action="' + url + '"></form>').appendTo('body').submit().remove();
        },
        query: function () {
            vm.reload();
        },
        reset: function () {
            $('#searchForm')[0].reset();
            vm.q ={
                realName:null,
                repayStatus:null,
                telNo:null,
                overdueMinDay:null,
                overdueMaxDay:null,
                repayType:null
            };

        }
        ,
        reload: function (event) {
            var page = $("#jqGrid").jqGrid('getGridParam', 'page');
            console.log(vm.q);
            $("#jqGrid").jqGrid('setGridParam', {
                postData: {
                    realName: vm.q.realName,
                    repayStatus: vm.q.repayStatus,
                    repayBDate: $("#repayBDate").val(),
                    repayEDate: $("#repayEDate").val(),
                    telNo: vm.q.telNo,
                    overdueMinDay: vm.q.overdueMinDay,
                    overdueMaxDay: vm.q.overdueMaxDay,
                    allocateSDate: $("#allocateSDate").val(),
                    allocateEDate: $("#allocateEDate").val(),
                    repayType: vm.q.repayType
                },
                page: page
            }).trigger("reloadGrid");
        }
    }
});

function toDetail(borrowId,userId) {
    parent.location.href = baseURL + 'index.html#particulars/particular-mark.html?borrowId=' + borrowId + "&userId=" + userId;
}


