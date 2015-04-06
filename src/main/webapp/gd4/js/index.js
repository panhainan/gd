var activ_Template = Handlebars.compile($("#activity-template").html());

var users_Template = Handlebars.compile($("#suggested-users-template").html());

$(document).ready(function(){
    Lectures();
    // suggested_users();

})
//判断用户是否登录
function getcurrentuser(){
    $.ajax({
        url: 'user/getcurrentuser.do',
        type:'GET',
        dataType:'json',
        success: function(data) {
              return (data);
            },
            error:function(data){
                console.log("error");  
                alert('出错啦，请联系系统管理员！');      
                }
    })
}

//推荐用户
function suggested_users(){

	  $.ajax({
            url: 'data/user.json',
            type: 'GET',
            dataType: 'json'

        })
        .done(function(data) {
             $('#suggested-users').html(users_Template(data));
        })
        .fail(function() {
        console.log("error");
    })
    .always(function() {
        console.log("complete");
    });
}

function Lectures() {
    $.ajax({
            url: '../activity/test/last/ten.do',
            type: 'GET',
            dataType: 'json'
        })
        .done(function(data) { 
             $('#activity').html(activ_Template(data));
        })
        .fail(function() {
        console.log("error");
    })
    .always(function() {
        console.log("complete");
    }); 
}
function Movies() {
    $.ajax({
            url: '../activity/test/last/ten.do',
            type: 'GET',
            dataType: 'json'
        })
        .done(function(data) { 
             $('#activity').html(activ_Template(data));
        })
        .fail(function() {
        console.log("error");
    })
    .always(function() {
        console.log("complete");
    }); 
}
function Music() {
    $.ajax({
            url: '../activity/test/last/ten.do',
            type: 'GET',
            dataType: 'json'
        })
        .done(function(data) { 
             $('#activity').html(activ_Template(data));
        })
        .fail(function() {
        console.log("error");
    })
    .always(function() {
        console.log("complete");
    }); 
}
function Sport() {
    $.ajax({
            url: '../activity/test/last/ten.do',
            type: 'GET',
            dataType: 'json'
        })
        .done(function(data) { 
             $('#activity').html(activ_Template(data));
        })
        .fail(function() {
        console.log("error");
    })
    .always(function() {
        console.log("complete");
    }); 
}
function Match() {
    $.ajax({
            url: '../activity/test/last/ten.do',
            type: 'GET',
            dataType: 'json'
        })
        .done(function(data) { 
             $('#activity').html(activ_Template(data));
        })
        .fail(function() {
        console.log("error");
    })
    .always(function() {
        console.log("complete");
    }); 
}
function Travis() {
    $.ajax({
            url: '../activity/test/last/ten.do',
            type: 'GET',
            dataType: 'json'
        })
        .done(function(data) { 
             $('#activity').html(activ_Template(data));
        })
        .fail(function() {
        console.log("error");
    })
    .always(function() {
        console.log("complete");
    }); 
}

// 搜索跳转
function search_content(){

    window.open("./tpls/search.html"); 

    /*var searchtxt = $("#searchtxt").val();
    var myurl="./tpls/search.html"+"?"+"parm1="+searchtxt; 
    window.location.assign(myurl);*/
    //window.location.href="./tpls/search.html?searchTxt="+searchtxt;
}

// 活动详情跳转
function activi(acti_id){
    var id = acti_id;
    window.location.href="./tpls/event.html?acti_id="+id; 
    }