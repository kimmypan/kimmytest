$(function () {
    $("#jqGrid").jqGrid({
        url: baseURL + 'manager/postLoan/infos',
        datatype: "json",
        colModel: [
            { label: '标的ID', name: 'borrowId', key: true, sortable: false},
            { label: '还款状态', name: 'statusText', width:70, sortable: false, formatter:genCellColor},
            { label: '姓名', name: 'realName', width:100, sortable: false},
            { label: '手机号码', name: 'telNo', sortable: false},
            { label: '渠道来源', name: 'channelName', sortable: false},
            { label: '合同 / 到手金额', name: 'amount', formatter:getTwoAmount, sortable: false},
            { label: '应还款金额', name: 'repayment', formatter:getRepayment},
            { label: '应还款时间', name: 'cycDate', datefmt:'Y-m-d', formatter:genCellColor},
            { label: '逾期天数', name: 'overDueDays' ,sortable: false, formatter: genCellColor},
            { label: '跟踪人', name: 'trackerName', sortable: false},
            { label: '操作', width: 100, formatter : genDetailBotton, sortable: false},
            {label: '用户ID', name: 'userId', hidden: true}
        ],
        viewrecords: true,
        height: 500,
        rowNum: 20,
        rowList : [20,30,50],
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
        footerrow:true,
        gridComplete:function() {
            $("#jqGrid").closest(".ui-jqgrid-bdiv").css({ "overflow-x" : "hidden" });
        },
        loadComplete:function(xhr) {
            var totalObj = {
                twoAmountStr : '',
                repaymentSum : 0,
                overDueDays : 0
            };
            if (xhr) {
                setChannelSelectOption(xhr.channelBusinessList, xhr.searchDTO);
                if (xhr.page && xhr.page.dataList) {
                    totalObj = getDataTotal(xhr.page.dataList);
                }
            }
            $("#jqGrid").footerData('set', {amount : totalObj.twoAmountStr, repayment: totalObj.repaymentSum, overDueDays : totalObj.overDueDays}, false);
            if ($("#statusSel option[selected]").length <= 0) {
                $("#statusSel option:eq(0)").attr("selected", "selected");
            }
        }
    });
});

var vm = new Vue({
    el:'#rrapp',
    data:{
        q:{

        },
    },
    methods: {
        query: function () {
            vm.reload();
        },
        reload: function (event) {
            var page = $("#jqGrid").jqGrid('getGridParam','page');
            vm.q.cycDateBegin = $("#cycDateBegin").val();
            vm.q.cycDateEnd = $("#cycDateEnd").val();
            if (!validateOverDueDaysInput(vm.q.overDueDaysBegin, vm.q.overDueDaysEnd)) {
                return false;
            }
            $("#jqGrid").jqGrid('setGridParam',{
                postData:{'realName': vm.q.realName,'telNo':vm.q.telNo,
                    'cycDateBegin': vm.q.cycDateBegin, 'cycDateEnd': vm.q.cycDateEnd,
                    'status': vm.q.status, 'borrowId': vm.q.borrowId,
                    'overDueDaysBegin': vm.q.overDueDaysBegin, 'overDueDaysEnd': vm.q.overDueDaysEnd,
                    'trackerName': vm.q.trackerName, 'channelId' : vm.q.channelId},
                page:page
            }).trigger("reloadGrid");
        }
    }
});

//返回合同/到手金额展示内容
function getTwoAmount(cellvalue, options, rowObject) {

    return rowObject.amount + " / " + rowObject.realAmount;

}

//返回合同/到手金额合计 展示内容
function getDataTotal(rows) {
    var totalObj = {
        amount : 0,
        realAmount : 0,
        twoAmountStr : '',
        repaymentSum : 0,
        overDueDays : 0
    }
    for (var i = 0; i < rows.length; i++) {
        if (rows[i].amount) {
            totalObj.amount += rows[i].amount * 1;
        }
        if (rows[i].realAmount) {
            totalObj.realAmount += rows[i].realAmount * 1;
        }
        if (4 == rows[i].status || 5 == rows[i].status) {
            totalObj.repaymentSum += rows[i].cost * 1 + rows[i].penaltyAmount * 1;
        } else {
            totalObj.repaymentSum += rows[i].amount * 1;
        }
        if (rows[i].overDueDays) {
            totalObj.overDueDays += rows[i].overDueDays * 1;
        }
    }
    totalObj.twoAmountStr = getTwoAmount(null, null, totalObj);
    return totalObj;

}

//根据是否逾期返回应还金额
function getRepayment(cellvalue, options, rowObject) {
    var repayment = rowObject.amount;
    if (4 == rowObject.status || 5 == rowObject.status) {
        repayment = rowObject.cost * 1 + rowObject.penaltyAmount * 1;
    }
    return genCellColor(repayment, options, rowObject);
}

//设置平台来源
function setChannelSelectOption(channelBusinessList, searchDTO) {
    try {
        var channelId = searchDTO ? searchDTO.channelId || '' : '';
        var channelOps = '<option value="">==全部==</option>';
        if (channelBusinessList) {
            for (var i = 0; i < channelBusinessList.length; i++) {
                channelOps += '<option value="'+ channelBusinessList[i].channelId +' "'
                    + (channelId == channelBusinessList[i].channelId ? 'selected=seleced' : '') +'>'
                    + channelBusinessList[i].channelName +'</option>';
            }
        }
        $("#channelSel").html(channelOps);
    } catch (e) {
        console.log(e)
    }
}

function genDetailBotton(cellvalue, options, rowObject) {
    var borrowId = "\""+rowObject.borrowId+"\"";
    var userId="\""+rowObject.userId+"\"";
    var trackerName="\""+rowObject.trackerName+"\"";
    return "<a class='btn btn-success' href='javascript:;' onclick='toDetail("+borrowId+","+userId+","+trackerName+")'>标的详情</a>";
}

function genCellColor(cellvalue, options, rowObject) {
    if (cellvalue || cellvalue == 0) {
        switch (rowObject.status) {
            case 6: return "<span style='color: green'>" + cellvalue + "</span>";
            case 7:
            case 8: return "<span style='color: red'>" + cellvalue + "</span>";
            default: return cellvalue;
        }
    } else {
        return '';
    }
}
function toDetail(borrowId,userId,trackerName) {
    parent.location.href = baseURL + 'index.html#particulars/particular-mark.html?borrowId=' + borrowId + "&userId=" + userId+"&trackerName="+trackerName;
}