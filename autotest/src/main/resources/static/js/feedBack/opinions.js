$(function () {

    $('#startDate').datepicker({
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
        $('#endDate').datepicker('setStartDate',startTime);
    });

    $('#endDate').datepicker({
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
        $('#startDate').datepicker('setEndDate',endTime);
    });


    $("#jqGrid").jqGrid({
        url: baseURL + 'manager/feedBack/opinions',
        datatype: "json",
        colModel: [
            { label: 'feedBackId', name: 'feedBackId', width: 30, key: true, hidden: true},
            { label: '反馈时间', name: 'createDate', width: 70 ,formatter:"date",formatoptions: {srcformat:'Y-m-dTH:i:s',newformat:'Y-m-d H:i:s'}},
            { label: '手机号', name: 'telNo', width: 70 },
            { label: '手机品牌', name: 'telBrand', width: 70 },
            { label: '手机型号', name: 'telModel', width: 50 },
            { label: '操作系统版本', name: 'osVersion', width: 70 },
            { label: 'APP版本', name: 'appVersion', width: 100 },
            { label: '反馈内容', name: 'content', width: 100 }
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
});

var vm = new Vue({
    el:'#rrapp',
    data:{
        q:{
            key: null
        },
    },
    methods: {
        query: function () {
            vm.reload();
        },
        reload: function (event) {

            vm.q.startDate=$("#startDate").val();
            vm.q.endDate=$("#endDate").val();

            var page = $("#jqGrid").jqGrid('getGridParam','page');
            $("#jqGrid").jqGrid('setGridParam',{
                postData:{'startDate': vm.q.startDate,'endDate':vm.q.endDate},
                page:page
            }).trigger("reloadGrid");
        }
    }
});