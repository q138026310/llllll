function init(){
	
	app.table({
		id:'.grid',
		url:'company/page',
		queryParams:{},
		columns:[{text:'公司名称',name:'name'},
		         {text:'公司编号',name:'customCode'},
		         {text:'上级公司',name:'parentName'},
		         {text:'联系人',name:'contact'},
		         {text:'联系电话',name:'contactPhone'},
		         {text:'操作',name:'',formatter:function(){
		        	 return '<a class="grid-opt-a grid-a-normal">编辑</a><a class="grid-opt-a grid-a-denger">删除</a>';
		         }}]
	});
	
	$('#add').click(function(){
		app.load('company/company_add');
	});
	
	$('#query').click(function(){
		var name = $('#name').val();
		var code = $('#code').val();
		var queryParams = {name:name,code:code};
		app.table({id:'.grid',type:'query',queryParams:queryParams});
	});
}
