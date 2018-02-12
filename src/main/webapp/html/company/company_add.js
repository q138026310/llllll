function init(){
	$('#cancel').click(function(){
		app.load('company/company_list');
	});
	
	$('#save').click(function(){
		
		var flag = app.check({
			elements:[
			        {	name:'name',
			        	checks:[
			        	        {type:app.checkType.BLANK,text:'请输入公司名称'},
			        	        {type:app.checkType.LENGTH,max:50}
			        	]
			        },
			        {   name:'customCode',
			        	checks:[
			        	        {type:app.checkType.BLANK,text:'请输入公司编号'},
			        	        {type:app.checkType.LENGTH,max:50}
			        	]
			        },
			        {   name:'parentCode',
			        	checks:[
			        	        {type:app.checkType.LENGTH,max:50}
			        	]
			        },
			        {   name:'contact',
			        	checks:[
			        	        {type:app.checkType.LENGTH,max:10}
			        	]
			        },
			        {   name:'contactPhone',
			        	checks:[
			        	        {type:app.checkType.LENGTH,max:50}
			        	]
			        }
			       ]
		});
		
		if(flag){
			save();
		}
		
	});
}

function save(){
	var data = app.serializeElement();
	app.request('company/save',data,function(resp){
		if( resp.data == 1 ){
			app.alert('保存成功',function(){
				app.load('company/company_list');
			});
		}
	});
}
