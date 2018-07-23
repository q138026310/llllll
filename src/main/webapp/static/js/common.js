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
	table:function(table,options){
        table.render({
            elem: options.elem,
            url:app.BASE_API_URL+options.url,
            where:$.extend({},options.where),
            page:true,
			cols: options.cols,
            //,skin: 'line' //表格风格
            even: true
            //,page: true //是否显示分页
            //,limits: [5, 7, 10]
            //,limit: 5 //每页默认显示的数量
        });

        //监听单元格编辑
		/*
        table.on('edit(demo)', function(obj){
            var value = obj.value //得到修改后的值
                ,data = obj.data //得到所在行所有键值
                ,field = obj.field; //得到字段
            layer.msg('[ID: '+ data.id +'] ' + field + ' 字段更改为：'+ value);
            //console.log('[ID: '+ data.id +'] ' + field + ' 字段更改为：'+ value);
        });
        */
	},
	stateTemplet:function(d){
        if(d.status==1){
            return '<span class="layui-badge layui-bg-blue">正常</span>';
        }else if(d.status==0){
            return '<span class="layui-badge">已删除</span>';
        }else if(d.status==2){
            return '<span class="layui-badge layui-bg-orange">禁用</span>';
        }

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


