var app = {
	BASE_API_URL:'/hrms/',
	alert:function(layer,message,type){
        if(!type){
            type = 1;
		}
        layer.alert(message, {
            icon: type,
            skin: 'layer-ext-moon'
        });
	},
    checkForm:function(options){
        for (var i = 0; i < options.length; i++) {
        	var option = options[i];
        	var value = null;

			if( option.type=='input' ){
				value = $('input[name="'+option.name+'"]').val();
			}

			value = $.trim(value);

			if( option.verify=='required' ){
				if( !value ){
                    layer.tips('必填项', 'input[name="'+option.name+'"]', {
                        tips: [1, '#3595CC'],
                        time: 3000
                    });
                    return false;
				}
			}

        }
        return true;
	},
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
	closeLastWindow:function(){
        var index = parent.layer.getFrameIndex(window.name); //先得到当前iframe层的索引
        parent.layer.close(index); //再执行关闭
	},
	request:function(options){
		var setting = {
			type:'POST',
			dataType:'json',
			data:app.serializeForm(),
			error:function(){
                console.log('------------ajax error----------------');
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
	},
	locationTo:function(url){
		location.href = url;
	},
	//加
    add:function (arg1,arg2,decimal){
		var r1,r2,m;
		try{r1=arg1.toString().split(".")[1].length}catch(e){r1=0}
		try{r2=arg2.toString().split(".")[1].length}catch(e){r2=0}
		m=Math.pow(10,Math.max(r1,r2));
		return ((arg1*m+arg2*m)/m).toFixed(decimal);
	},
	//减
    sub:function (arg1,arg2,decimal){
		var r1,r2,m;
		try{r1=arg1.toString().split(".")[1].length}catch(e){r1=0}
		try{r2=arg2.toString().split(".")[1].length}catch(e){r2=0}
		m=Math.pow(10,Math.max(r1,r2));
		return ((arg1*m-arg2*m)/m).toFixed(decimal);
	},
	//乘
	mul:function (arg1,arg2,decimal)   {
		var m=0,s1=arg1.toString(),s2=arg2.toString();
		try{m+=s1.split(".")[1].length}catch(e){}
		try{m+=s2.split(".")[1].length}catch(e){}
		return (Number(s1.replace(".",""))*Number(s2.replace(".",""))/Math.pow(10,m)).toFixed(decimal);
	},
	//除
	div:function (arg1,arg2,decimal){
		var t1=0,t2=0,r1,r2;
		try{t1=arg1.toString().split(".")[1].length}catch(e){}
		try{t2=arg2.toString().split(".")[1].length}catch(e){}

		r1=Number(arg1.toString().replace(".",""));

		r2=Number(arg2.toString().replace(".",""));
		return ((r1/r2)*Math.pow(10,t2-t1)).toFixed(decimal);
	}
}


