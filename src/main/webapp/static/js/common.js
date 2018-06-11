var app = {
	BASE_API_URL:'/hrms/',
	window:function(layer,options){
		var setting = {
			type: 2,
			area: ['500px', '300px'],
			fixed: false, //不固定
			maxmin: true,
			btn:['确认','取消'],
			yes:function(){
				return false;
			}
		}
		
		$.extend(setting,options);
		
		layer.open(setting);
	},
	request:function(options){
		var setting = {
			type:'POST',
			dataType:'json',
			xhrFields: {
				withCredentials: true
			},
			data:app.serializeForm(),
			error:function(){
				alert('error');
			}
		};
		$.extend(setting,options);
		setting.url = app.BASE_API_URL+setting.url;
		
		console.log('------------ajax options----------------');
		console.log(setting);
		console.log('------------ajax options----------------');
		
		$.ajax(setting);
	},
	serializeForm:function(){
		var data = {};
		$('#formArea input').each(function(){
			data[this.name] = this.value;
		});
		return data;
	},
	getOkBtn:function(){
		//layui-layer-btn0
		return $('.layui-layer-btn0',parent.document);
	}
}