var disc_user_rece_id; //接受评论人的id
var disc_user_area_id; //评论方的area_id

var acti;//活动类型

/*活动模板与评论模板*/


function get_acti_id() 
{ 
var url=location.href; 
var tmp1=url.split("?")[1]; 
var tmp2=tmp1.split("&")[0]; 
var tmp3=tmp2.split("=")[1]; 
	acti=tmp3;
}

$(document).ready(function(){
	get_acti_id();
	myTemplate (acti);
	discuss ();	
	$(".forum").click(function(){
		comment();
	})
	
});

function getId(id,area_id) {
	disc_user_rece_id = id;
	disc_user_area_id = area_id

}
function myTemplate (act) {
	$.ajax({
			url: 'http://10.28.20.109:8080/gd/activity/id/details.do',
			type: 'GET',
			data: { activity_id:act },
			dataType: 'json'
	        })	

			.done(function(data) { 
				var data1 = ([data]);
				var Template = Handlebars.compile($("#event-template").html());
			    $('#eventList').html(Template(data1));
			})
			.fail(function() {
				console.log("error");
			})
			.always(function() {
				console.log("complete");
			});


}

function discuss () {
	$.ajax({
		url: 'http://10.28.20.109:8080/gd/discuss/activityid/list.do?disc_acti_id=2&page=1&pageSize=10',
		type: 'GET',
		dataType: 'json'
	})
	.done(function(data) { 
		var discuss_Template = Handlebars.compile($("#item-template").html());
         //将json对象用刚刚注册的Handlebars模版封装，得到最终的html，插入到基础table中。
        $('#itemList').html(discuss_Template(data));
	})
	.fail(function() {
		console.log("error");
	})
	.always(function() {
		console.log("complete");
	});
}

function comment(){		
		$.ajax({
			url: 'http://10.28.20.109:8080/gd/discuss/publish.do',
			type: 'POST',
			data: 	{
						disc_acti_id:$(".acti-name").attr("id"), //活动id
						disc_user_send_id:1, //发送者id
						disc_user_rece_id:disc_user_rece_id,//接受者id
						disc_user_area_id:disc_user_area_id, //area-id
						disc_rped_disc_id:$(".disc_rped_disc").attr("id"), //被评论内容的id
						disc_content:$("#disc_content").val()//评论内容
                 	},
			dataType: 'json'
		})
		.done(function(data) {		      
	       	alert(data);
		})
		.fail(function() {
			console.log("error");
		})
		.always(function() {
			console.log("complete");
		});		
}


