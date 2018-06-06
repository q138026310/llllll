var app = {
	BASE_API_URL:'http://127.0.0.1:8888/hrms/',
	window:function(layer,options){
		var setting = {
			type: 2,
			area: ['500px', '300px'],
			fixed: false, //不固定
			maxmin: true,
			btn:['确认','取消']
		}
		
		$.extend(setting,options);
		
		layer.open(setting);
	},
	request:function(options){
		var setting = {
			type:'POST',
			dataType:'JSON',
			data:app.serializeForm(),
			error:function(){
				
			}
		};
		$.extend(setting,options);
		setting.url = app.BASE_API_URL+setting.url;
		$.ajax(setting);
	},
	serializeForm:function(){
		var data = {};
		$('#formArea input').each(function(){
			data[this.name] = this.value;
		});
		return data;
	}
}