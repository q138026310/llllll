function init(){
	$('.hrms-page').pagination({
		totalData: 100,
		showData: 10,
		count:4,
		mode: 'fixed',
		coping: false,
		keepShowPN:false,
		callback:function(pagination){
			console.log(pagination);
			console.log(pagination.getCurrent());
		}
	});
	
	$('#add').click(function(){
		app.load('company/company_add');
	});
}
