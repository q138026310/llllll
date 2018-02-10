function init(){
	alert($('#page').length);
	$('#page').pagination({
		totalData: 100,
		showData: 5,
		coping: true
	});
}
