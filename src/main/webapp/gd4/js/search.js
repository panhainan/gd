var searchTxt = null;
var currentPage=0;

$(document).ready(function(){
	  searchTxt = GetQueryString("searchtxt"); 
    console.log(searchTxt); 
    search();
})

function GetQueryString(name) {
    var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)","i"); 
    var r = window.location.search.substr(1).match(reg); 
    if (r!=null) return (r[2]); return null; 
    } 

// 加载更多
function searchMore(){
	currentPage++;
	search();
}

function search(){	
	$.ajax({
                url: 'http://10.28.20.109:8080/gd/activity/searchtxt/list.do',
                type: 'POST',
                data: 	{	
								"searchTxt":searchTxt,
								"currentPage":currentPage
							},
                dataType: 'json',
                success: function(data){

                	var search_content = data.listActivity;
					var myTemplate = Handlebars.compile($("#search-template").html());
	                $('#content-left-w').html(myTemplate(search_content));

				},
				error:function(data){   
					alert('出错啦，请联系系统管理员！');      
					}
	        })
}
