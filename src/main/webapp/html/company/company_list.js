function init(){
	
	app.table({
		id:'.grid',
		url:'company/page',
		queryParams:{},
		columns:[{text:'公司名称',name:'name'},
		         {text:'公司编号',name:'code'},
		         {text:'上级公司',name:'parentName'}]
	});
	
	$('#add').click(function(){
		app.load('company/company_add');
	});
}
