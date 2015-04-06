
function register(){
	var	nickName = $(".account-w")[0].value;
	var userEmail = $(".email-w")[0].value;
	var	userPass = $(".password-w")[0].value;
	var	userrePass = $(".repassword-w")[0].value;
	 alert(nickName+userEmail+userPass);
	$.ajax({
			url: '../../user/register.do',
			type: 'POST',
			data:{	
					nickName: nickName,
					userEmail: userEmail,
					userPass: userPass
			},
			/*根据返回值的不同，判断跳转*/
		success: function(data) {
			//alert(data.registerResult);
			if (data.registerResult) {
				console.log("error");
				$(".account-w")[0].value="输入有误，请检查！";
				$(".account-w").css('color','red');
				}
			//alert(data);			
			//document.location="activityList.html";
		},
		error:function(data){   
			//alert('出错啦，请联系系统管理员！');      
		}
		})		
}

