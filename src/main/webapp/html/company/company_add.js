var params = app.getReqeustParams();

function init(){
	
	if( params.id && params.id.length>0 ){
		app.request('company/get',{id:$.trim(params.id)},function(resp){
			if(resp.result==0){
				$('input[name="name"]').val(resp.data.name);
				$('input[name="customCode"]').val(resp.data.customCode);
				$('input[name="contact"]').val(resp.data.contact);
				$('input[name="contactPhone"]').val(resp.data.contactPhone);
				
				app.request('company/get',{code:resp.data.parentCode},function(resp2){
					if(resp2.result==0){
						$('input[name="parentCustomCode"]').val(resp2.data.customCode);
						activeParentCustomCode();
					}
				});
				
			}
		});
	}
	
	$('#cancel').click(function(){
		app.load('company/company_list');
	});
	
	$('input[name="parentCustomCode"]').keypress(function(event){
		if(event.keyCode ==13){
			activeParentCustomCode();
		}
	});
	
	$('#save').click(function(){
		
		
		if( $('input[name="parentCustomCode"]').val().length>0 && $('input[name="parentCode"]').val().length==0){
			layer.tips('上级公司编号输入完成需要回车确认','input[name="parentCustomCode"]');
			$('input[name="parentCustomCode"]').focus();
			return;
		}
		
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
	var url = 'company/save'
	
	if( !app.isBlank(params.id) ){
		data.id = params.id;
		url = 'company/modify';
	}
	
	app.request(url,data,function(resp){
		if( resp.data == 1 ){
			app.alert('保存成功',function(){
				app.load('company/company_list');
			});
		}
	});
}

function activeParentCustomCode(){
	app.request('company/select',{customCode:$.trim($('input[name="parentCustomCode"]').val())},function(resp){
		if( resp.result==0 ){
			if( resp.data.length != 1 ){
				$('input[name="parentName"]').val('');
				$('input[name="parentCode"]').val('');
				$('input[name="parentCustomCode"]').val('');
				layer.tips('您输入的上级公司编号有误','input[name="parentCustomCode"]');
			}else{
				$('input[name="parentName"]').val(resp.data[0].name);
				$('input[name="parentCode"]').val(resp.data[0].code);
			}
		}
	});
}
