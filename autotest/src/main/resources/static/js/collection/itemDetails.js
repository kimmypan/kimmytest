$(function () {


    $('#repayBDate').datepicker({
        language:  'zh-CN',
        todayBtn:  'linked',
        autoclose: true,
        todayHighlight: 1,
        startView: 0,
        format:'yyyy-mm-dd',
        clearBtn:true,
        forceParse:true
    }).on('changeDate',function(e){
        var startTime = e.date;
        $('#repayEDate').datepicker('setStartDate',startTime);
    });

    $('#repayEDate').datepicker({
        language:  'zh-CN',
        todayBtn:  'linked',
        autoclose: true,
        todayHighlight: 1,
        startView: 0,
        format:'yyyy-mm-dd',
        clearBtn:true,
        forceParse:true
    }).on('changeDate',function(e){
        var endTime = e.date;
        $('#repayBDate').datepicker('setEndDate',endTime);
    });


    $('#allocateSDate').datepicker({
        language:  'zh-CN',
        todayBtn:  'linked',
        autoclose: true,
        todayHighlight: 1,
        startView: 0,
        format:'yyyy-mm-dd',
        clearBtn:true,
        forceParse:true
    }).on('changeDate',function(e){
        var startTime = e.date;
        $('#allocateEDate').datepicker('setStartDate',startTime);
    });

    $('#allocateEDate').datepicker({
        language:  'zh-CN',
        todayBtn:  'linked',
        autoclose: true,
        todayHighlight: 1,
        startView: 0,
        format:'yyyy-mm-dd',
        clearBtn:true,
        forceParse:true
    }).on('changeDate',function(e){
        var endTime = e.date;
        $('#allocateSDate').datepicker('setEndDate',endTime);
    });













    $("#jqGrid").jqGrid({
        url: baseURL + 'manager/collection/traceDetails',
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
            {label: '跟踪人', name: 'trackerName', width: 100, formatter: formatterTracker},

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

    function formatterTracker(cellvalue, options, rowObject) {
        return "<a href='javascript:;' onclick='toTracker("+rowObject.trackerId+")'>"+cellvalue+"</a>";
    }

});

var vm = new Vue({
    el: '#rrapp',
    data: {
        q: {

        },
        dto: {},
        linkTrackerId:null
    },
    beforeCreate: function () {
        var url = baseURL + 'manager/collection/traceDetailTotal';
        $.get(url, function (data) {
            vm.dto = data.dto;
        });
    },
    methods: {
        exportData: function () {
            var params = $.param(vm.q);
            var url= baseURL + 'manager/export/traceDetails.html?'+params;
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
                repayBDate:null,
                repayEDate:null,
                telNo:null,
                overdueMinDay:null,
                overdueMaxDay:null,
                allocateSDate:null,
                allocateEDate:null,
                trackerName:null,
                repayType:null
            };

        }
        ,
        reload: function (event) {
            var page = $("#jqGrid").jqGrid('getGridParam', 'page');
            $("#jqGrid").jqGrid('setGridParam', {
                postData: {
                    'realName': vm.q.realName,
                    'repayStatus': vm.q.repayStatus,
                    'repayBDate': $("#repayBDate").val(),
                    'repayEDate': $("#repayEDate").val(),
                    'telNo': vm.q.telNo,
                    'overdueMinDay': vm.q.overdueMinDay,
                    'overdueMaxDay': vm.q.overdueMaxDay,
                    'allocateSDate': $("#allocateSDate").val(),
                    'allocateEDate': $("#allocateEDate").val(),
                    'trackerName': vm.q.trackerName,
                    'repayType': vm.q.repayType

                },
                page: page
            }).trigger("reloadGrid");
        }
    }
});


function toTracker(trackerId){
    parent.location.href = baseURL + 'index.html#collection/trackerinfos.html?trackerId='+trackerId;
}
function toDetail(borrowId,userId) {
    parent.location.href = baseURL + 'index.html#particulars/particular-mark.html?borrowId=' + borrowId + "&userId=" + userId;
}
