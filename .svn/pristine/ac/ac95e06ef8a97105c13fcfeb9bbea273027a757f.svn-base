



$(document).ready(function() {

	$.ajax({
		url: '../data/toJoinActivity.json',
		type: 'GET',
		dataType: 'json'
	})
	.done(function(data) {
            var personalActivityTemplate = Handlebars.compile($("#personalActivity-template").html());
            $('#personalActivity').html(personalActivityTemplate(data));
	})






	
	
});
function personal (type) {
	$.ajax({
		url: '../data/toJoinActivity.json',
		type: 'GET',
		dataType: 'json'
	})
	.done(function(data) {
        //将json对象用刚刚注册的Handlebars模版封装，得到最终的html，插入到基础table中。
        if(type=='join'){
        	 var personalActivityTemplate = Handlebars.compile($("#personalActivity-template").html());
            $('#personalActivity').html(personalActivityTemplate(data));
        }else if(type=='notAttend'){
        	  var  personalActivityTemplate = Handlebars.compile($("#personalActivity-template").html());
        	$('#personalActivity').html(personalActivityTemplate(data));
        }else if(type=='publish'){
        	  var personalActivityTemplate = Handlebars.compile($("#personalActivity-template").html());
            $('#personalActivity').html(personalActivityTemplate(data));
        }
    
	})
	.fail(function() {
		console.log("error");
	})
	.always(function() {
		console.log("complete");
	});
}
function personalComment (activityId) {
var element = '#'+'activityId'+activityId;
$(element).css({
	display: 'block'
});
}