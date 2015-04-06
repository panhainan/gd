    Handlebars.registerHelper("formatDate", function(value) {
    	var dd = new Date(value);
    	 var time = dd.getFullYear() + '/' + (dd.getMonth()+1) + '/' + dd.getDay() +'   '+
    	            dd.getHours()+':'+dd.getMinutes()+':'+dd.getSeconds();
    	return time;
    });