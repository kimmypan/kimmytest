$(function () {
   // var userId=sessionStorage.getItem("userId");
   // var borrowId=sessionStorage.getItem("borrowId");
   //  sessionStorage.removeItem("userId");
   //  sessionStorage.removeItem("borrowIdId");
    var userId=$.getUrlParam('userId');
    var borrowId=$.getUrlParam('borrowId');
    $.ajax({
        url: baseURL + 'manager/signDetails/borrowInfo?userId=' + userId + "&borrowId=" + borrowId,
        dataType: 'json',
        method: 'post',
        async: false,
        success: function (data) {
            console.log(data)
            vm1borrowInfo.borrowInfo = data.borrowDetail;
            if( data.borrowDetail.announcement!=null) {
                vmbulletin.bulletin_text = data.borrowDetail.announcement;

            }
        },
        error: function (data) {
            alert(JSON.stringify(data));
        }
    });

    /*用户基本信息*/
    $.ajax({
        url: baseURL + 'manager/signDetails/userDetails?userId=' + userId,
        dataType: 'json',
        method: 'post',
        /*  async: false,*/
        success: function (data) {
            console.log(data.userBasicInfo)
            vmuserInfo.userInfo = data.userBasicInfo;
           if(data.userBasicInfo.backCard_url!=null){
               vmidentity.identity_card.backCardUrl=data.userBasicInfo.backCard_url;
           }
           if(data.userBasicInfo.frontCard_url!=null){
                vmidentity.identity_card.frontCardUrl=data.userBasicInfo.frontCard_url;
           }
          if(data.userBasicInfo.liveVideo_url!=null){
              vmidentity.identity_card.liveVideoUrl=data.userBasicInfo.liveVideo_url;
          }
        },
        error: function (data) {
            alert(JSON.stringify(data));
        }
    });
    /* 紧急联系人返回数据*/
    $.ajax({
        url: baseURL + 'manager/signDetails/contact?userId=' + userId,
        dataType: 'json',
        method: 'post',
        async: false,
        success: function (data) {
            console.log(data.emergencyContact);
            vm3contact.items = data.emergencyContact;
        },
        error: function (data) {
            alert(JSON.stringify(data));
        }
    });
    /*催收記錄*/
    $.ajax({
        url: baseURL + 'manager/signDetails/record?userId=' + userId,
        dataType: 'json',
        method: 'post',
        async: false,
        success: function (data) {
            console.log(data);
            vm2recode.items = data.collectRecord;
        },
        error: function (data) {
            alert(JSON.stringify(data));
        }
    });

})






//然后再交给 vue 进行渲染(borrowInfo)
var vm1borrowInfo = new Vue({
    el: '#borrowMesag',
    data: {
        borrowInfo: {},
    }
});
// 然后再交给 vue 进行渲染(userInfo)
var vmuserInfo = new Vue({
    el: '#tableuser',
    data: {
        userInfo:{},
    }
});

// 然后再交给 vue 进行渲染(collection-recode)
var  vm3contact= new Vue({
    el: '#contact_ji',
    data: {
        items:[]
    }
});
// 然后再交给 vue 进行渲染( contact)
var vm2recode = new Vue({
    el: '#recode_dt',
    data: {
      items:[]
    }
});
var vmbulletin=new Vue({
    el:"#vmGongGao",
    data:{
        bulletin_text:null,
    }
})

