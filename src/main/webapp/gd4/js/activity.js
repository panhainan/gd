

$(document).ready(function() {
    var activityId = GetQueryString("activityId"); 
    console.log(activityId);
    
});


function GetQueryString(name) {
    var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)","i"); 
    var r = window.location.search.substr(1).match(reg); 
    if (r!=null) return (r[2]); return null; 
    } 