juicer.register('dateFormat', function(date, format) {
	if (!date) {
		return "";
	}
	if(!format){
		format="yyyy-MM-dd hh:mm:ss";
	}
	date = new Date(date);
	var map = {
		"M" : date.getMonth() + 1, //月份   
		"d" : date.getDate(), //日   
		"h" : date.getHours(), //小时   
		"m" : date.getMinutes(), //分   
		"s" : date.getSeconds(), //秒   
		"q" : Math.floor((date.getMonth() + 3) / 3), //季度   
		"S" : date.getMilliseconds()
	//毫秒   
	};
	format = format.replace(/([yMdhmsqS])+/g, function(all, t) {
		var v = map[t];
		if (v !== undefined) {
			if (all.length > 1) {
				v = '0' + v;
				v = v.substr(v.length - 2);
			}
			return v;
		} else if (t === 'y') {
			return (date.getFullYear() + '').substr(4 - all.length);
		}
		return all;
	});
	return format;
});

juicer.register('gridIndex', function(index, d){
	return (d.page-1)*d.rows+index*1+1;
});

juicer.register('spendSeconds', function(d){
	if(d.successTime){
		return d.successTime-d.startTime;
	}
	if(d.failTime){
		return d.failTime-d.startTime;
	}
	return "";
});

juicer.register('nd', function(d, defaultValue){
	return d==null?defaultValue:d;
});

juicer.register('amountFormat',   function (value){
	return (value || 0).toString().replace(/(\d{1,3})(?=(\d{3})+(?:$|\.))/g, "$1,");
})