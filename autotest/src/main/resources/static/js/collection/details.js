$(function () {

    $("#jqGrid").jqGrid({
        url: baseURL + 'manager/collection/allocationDetails',
        datatype: "json",
        colModel: [
            { label: 'trackerId', name: 'trackerId', width: 30, key: true, hidden: true},
            { label: '跟踪员姓名', name: 'userName', width: 85,formatter: formatterUserDetail},
            { label: '工号', name: 'jobNum', width: 55 },
            { label: '手机号码', name: 'mobile', width: 75 },

            { label: '今日已分配', name: 'dayTaskCount', width: 70 ,formatter: formatterProjectDetail},
            { label: '今日全额/部分回款数量', name: 'amount', width: 120 ,formatter: formatterDayCount},
            { label: '今日回款金额', name: 'dayRepayAmount', width: 100 },


            { label: '本月全额/部分回款数量', name: 'monthRepayCount', width: 120 ,formatter: formatterMonthCount},
            { label: '本月回收率(数量)', name: 'monthRepayCountPercent', width: 90 },
            { label: '本月回款金额', name: 'monthRepayAmount', width: 100 },
            { label: '本月回收率(金额)', name: 'monthRepayAmountPercent', width: 100 },

            { label: '待回款数量/金额', name: 'taskCount', width: 110 ,formatter: formatterReceivablel}
        ],
        viewrecords: true,
        height: 385,
        rowNum: 10,
        rowList : [10,30,50],
        rownumbers: true,
        rownumWidth: 25,
        autowidth:true,
        multiselect: false,
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
        }
    });

    function formatterProjectDetail(cellvalue, options, rowObject) {
        return "<a href='javascript:;' onclick='toTracker("+rowObject.trackerId+")'>"+cellvalue+"</a>";
    }


    function formatterUserDetail(cellvalue, options, rowObject) {
        return "<a href='javascript:;' onclick='toTracker("+rowObject.trackerId+")'>"+cellvalue+"</a>";
    }


    function formatterDayCount(cellvalue, options, rowObject) {
        return "<a href='javascript:;' onclick='toTracker("+rowObject.trackerId+")'>"+rowObject.dayRepayCount+"/"+rowObject.dayPortionRepayCount+"</a>";
    }

    function formatterMonthCount(cellvalue, options, rowObject) {
        return "<a href='javascript:;' onclick='toTracker("+rowObject.trackerId+")'>"+rowObject.monthRepayCount+"/"+rowObject.monthPortionRepayCount+"</a>";
    }

    function formatterReceivablel(cellvalue, options, rowObject) {
        return "<a href='javascript:;' onclick='toTracker("+rowObject.trackerId+")'>"+rowObject.taskCount+"/"+rowObject.taskAmount+"</a>";
    }


});


var vm = new Vue({
    el:'#rrapp',
    data:{
        q:{
            key: null
        },
        dto:{}
    },
    beforeCreate:function () {
        var url= baseURL + 'manager/collection/allocationDetailTotal';
        $.get(url,function(data){
            vm.dto=data.dto;
        });
    },
    methods: {
        exportData:function () {
          //  var params = $.param(vm.q);
              var url= baseURL + 'manager/export/allocationDetails.html';
            $('<form method="POST" action="' + url + '"></form>').appendTo('body').submit().remove();
        },
        query: function () {
            vm.reload();
        },
        reload: function (event) {
            var page = $("#jqGrid").jqGrid('getGridParam','page');
            $("#jqGrid").jqGrid('setGridParam',{
                postData:{'key': vm.q.key},
                page:page
            }).trigger("reloadGrid");
        }
    }
});
function toTracker(trackerId){
    parent.location.href = baseURL + 'index.html#collection/trackerinfos.html?trackerId='+trackerId;
}
function toItemDetails(trackerId){
    parent.location.href = baseURL + 'index.html#collection/itemDetails.html';
}


