function login(){
	var	user = $(".account-w")[0].value;
	var	password = $(".password-w")[0].value;
	//alert(user+"+"+password);
	$.ajax({
			url: '../../user/login.do',
			type: 'GET',
			data:{	
					cardId:user,
					password:password
			},
			/*根据返回值的不同，判断跳转*/
			success: function(data) {
				if (data=="用户名/密码错误") {
					console.log("error");
					$(".account-w")[0].value="用户名/密码错误";
					$(".account-w").css('color','red');
				}
				else if (data=="success") {
					console.log("success");			
					document.location="activityList.html";
				}
				else if (data=="用户被锁定") {
					alert(data);
					console.log("data");
				}
				else if (data=="重复次数过多") {
					alert(data);
					console.log("data");
				}
				else if (data=="其他错误：用户未经过验证") {
					alert(data);
					console.log("data");
				}
				else if(data=="用户未经过验证") {
					alert(data);
					console.log("data");
				};				
			},
			error:function(data){   
				alert('出错啦，请联系系统管理员！');      
				}
		})
	}