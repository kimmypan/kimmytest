/**
 * Created by huangzhenwei on 2017/8/21.
 */
//显示新增公告
function showDiv() {
    $("#u2545_div").show();
    document.getElementById('u2545_textarea').focus();
    var bulletin_span = $("#u2226_span").html();
    $("#u2545_textarea").text(bulletin_span);

}

function colseDiv() {
    $("#u2545_div").hide();
}

function bulletinSave() {
    var borrowId = $.getUrlParam('borrowId');
    var text1 = document.getElementById("u2545_textarea").value;
    $.ajax({
        url: baseURL + 'manager/signDetails/bulletinSave?announcement=' + text1 + "&borrowId=" + borrowId,
        dataType: 'json',
        method: 'post',
        async: false,
        success: function (data) {
            console.log(data);
            if (data.msg.equals("Y")) {
                alert("保存成功");
            } else {
                alert("保存失败");
            }
        },
        error: function (data) {
            alert(JSON.stringify(data));
        }
    })
    if (text1 == "") {
        document.getElementById("u2226_span").innerHTML = "最新公告！";
    } else {
        document.getElementById("u2226_span").innerHTML = text1;
    }
    $("#u2545_div").hide();
}


function append_recode() {
    $("#recode_qk").show();
    document.getElementById('collect_textarea').focus();
}
function recode_colse() {
    $("#recode_qk").hide();
}
function recode_save() {
    var text1 = document.getElementById("collect_textarea").value;
    var borrowId = $.getUrlParam('borrowId');
    var userId = $.getUrlParam('userId');
    if (text1 != "") {
        $.ajax({
            url: baseURL + 'manager/signDetails/insertrecord?collectionInfo=' + text1 + "&borrowId=" + borrowId + "&userId=" + userId,
            dataType: 'json',
            method: 'post',
            async: false,
            success: function (data) {
                console.log(data);
                if (data.msg.equals("Y")) {
                    alert("保存成功");
                } else {
                    alert("保存失败");
                }
            },
            error: function (data) {
                alert(JSON.stringify(data));
            }
        });
    }
    document.getElementById("collect_textarea").value = "";
    $("#recode_qk").hide();
    window.location.reload();
}

/*查看身份证*/
function onDentity() {
    $("#identity_tup").show();
    $("#toggle_pri").attr('src', vmidentity.identity_card.frontCardUrl);
}
function colseident() {
    $("#identity_tup").hide();
}
var vmidentity = new Vue({
    el: "#u2547_div",
    data: {
        identity_card: {
            frontCardUrl: null,
            backCardUrl: null,
            liveVideoUrl: null,
        },

    }

})
//身份证上一张
function previous_idc() {
    $("#toggle_pri").attr('src', vmidentity.identity_card.frontCardUrl);
    $("#identity_text").html("1、身份证正面照");
}
//身份证下一张
function next_idc() {
    $("#toggle_pri").attr('src', vmidentity.identity_card.backCardUrl);
    $("#identity_text").html("2、身份证反面照");
}
//关闭身份证窗口
function closewindow() {

    $("#u2547_div").hide();
}

/*查看详情（天秤）*/
function check_libra() {
    $("#tian_chen").show();
    var userId = $.getUrlParam('userId');
    var borrowId = $.getUrlParam('borrowId');
    $.ajax({
        url: baseURL + 'manager/signDetails/ApiDate?userId=' + userId,
        dataType: 'json',
        method: 'post',
        success: function (data) {
            console.log(data);
            vm4.apiDate = data.apiDate;


        },
        error: function (data) {
            alert(JSON.stringify(data));
        }
    })
}
var vm4 = new Vue({
    el: "#skyChen",
    data: {
        apiDate: {},
    }
});

function colse_libra() {
    $("#tian_chen").hide();
}
//通话录详情
function phone_contact() {
    $("#phoneContact").show();
    var userId = "085C388C374A4C70B58C5BAE8426729F";
    //$.getUrlParam('userId');
    //ajax请求
    $.ajax({
        url: baseURL + 'manager/signDetails/phoneDetail?userId=' + userId,
        dataType: 'json',
        method: 'post',
        success: function (data) {
            console.log(data.SimpleList);
            vmphdetail.items = data.SimpleList;
        },
        error: function (data) {
            alert(JSON.stringify(data));
        }
    })
}
var vmphdetail = new Vue({
    el: '#phone_dx',
    data: {
        items:[]
    }
})

function closepbone() {
    $("#phoneContact").hide();
}

//通话记录详情
function phone_detail() {
    $("#phone_detail").show();
    var userId = "085C388C374A4C70B58C5BAE8426729F";

    //$.getUrlParam('userId');
    $.ajax({
        url: baseURL + 'manager/signDetails/callDetail?userId=' + userId,
        dataType: 'json',
        method: 'post',
        success: function (data) {
            console.log(data);
            vmCall.items = data.callSimples;

        },
        error: function (data) {
            alert(JSON.stringify(data));
        }
    })
}
var vmCall = new Vue({
    el: '#call_tx',
    data: {
        items:[]
    }
});
function closephonewin() {
    $("#phone_detail").hide();

}
//分页
function  paging(page) {
    var userId = "085C388C374A4C70B58C5BAE8426729F";
    var page=this.val();
    //$.getUrlParam('userId');
    $.ajax({
        url: baseURL + 'manager/signDetails/callDetail?userId=' + userId,
        dataType: 'json',
        method: 'post',
        success: function (data) {
            console.log(data);
            vmCall.items = data.callSimples;

        },
        error: function (data) {
            alert(JSON.stringify(data));
        }
    })

    
}


