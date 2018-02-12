function init(){
	$('#cancel').click(function(){
		app.load('company/company_list');
	});
	
	$('#save').click(function(){
		
		var data = app.serializeElement();
		
		app.request('company/save',data,function(resp){
			if( resp.data == 1 ){
				layer.alert('内容', {
					  icon: 1
					},function(){
						app.load('company/company_list');
					});
			}
		});
	});
}
