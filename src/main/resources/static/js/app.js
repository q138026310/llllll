var app={
	baseUrl:'/hrms/',
	request:function(url,requestData,callback,errorfn,async){
		if( url==null || url.length==0 )return;
		
		if(!async){
			async = true;
		}
		
		if(!requestData)requestData = {};
		
		$.ajax({
			url:app.baseUrl+url+".spring?_t="+new Date().getTime(),
			data:requestData,
			async:async,
			type:'POST',
			success:function(resp){
				var dd = resp.replace(/\+/g,'%20');
				resp = app.json(decodeURIComponent(dd));
				
				console.log("----------"+url+"---------");
				console.log(resp);
				console.log("----------"+url+"---------");
				
				if( resp.result==1 ){
					app.warn('登陆失效，请重新登陆',function(){
						location.href = "/hrms";
					});
				}else if( resp.result==2 ){
					if(app.cont['p'+resp.message]){
						app.warn(app.cont['p'+resp.message]);
					}else{
						app.warn(resp.message);
					}
				}else{
					callback(resp);
				}
				
			},
			error:function(e){
				if(errorfn){
					errorfn.apply(e);
				}else{
					app.alert('请求失败：未知错误');
				}
			}
		});
	},
	alert:function(message){
		alert(message);
	},
	str:function(o){
		return JSON.stringify(o);
	},
	json:function(value){
		return $.parseJSON(value);
	},
	getReqeustParams:function(){
		var value = location.href;
		var o = {};
		if(value.indexOf('?')!=-1){
			value = value.substr(value.indexOf('?')+1)
			values = value.split('&');
			for( var i=0 ; i < values.length ; i++ ){
				var arr = values[i].split('=');
				o[arr[0]] = arr[1];
			}
		}
		return o;
	},
	load:function(url,params){
		var param = app.getReqeustParams();
		
		if(!params){
			params = '';
		}
		
		location.href = '/hrms/html/index/index.html?redirect='+url+'&rectmid='+param.rectmid+'&rectsmid='+param.rectsmid+params;
	},
	table:function(options){
		
		var id = options.id;
		
		if( options.type == 'query' ){
			var queryParams = options.queryParams;
			options = $(id).data();
			options.queryParams = $.extend(options.queryParams,queryParams);
			options.queryParams.start = 1;
		}
		
		$(id).data(options);
		
		if(!options.queryParams){
			options.queryParams = {};
		}
		
		if(!options.queryParams.start){
			options.queryParams.start = 1;
		}
		
		if(!options.queryParams.limit){
			options.queryParams.limit = 10;
		}
		
		app.request(options.url,options.queryParams,function(resp){
			
			$(id).empty();
			
			var firstTr = $('<div class="grid-tr-head"></div>');
			
			$.each(options.columns,function(i,column){
				firstTr.append('<div class="grid-th">'+column.text+'</div>');
			});
			
			$(id).append(firstTr);
			
			$.each(resp.data.list,function(i,row){
				var bodyTr = null;
				
				if(i%2==1){
					bodyTr = $('<div class="grid-tr grid-tr-ligh"></div>');
				}else{
					bodyTr = $('<div class="grid-tr"></div>');
				}

				$.each(options.columns,function(i,column){
					var value = null;
					if( column.name==null || column.name.length==0 ){
						value = column.formatter(i,row);
					}else{
						value = row[column.name];
						if(!value){
							value = '';
						}
					}
					
					bodyTr.append('<div class="grid-td">'+value+'</div>');
				});

				$(id).append(bodyTr);
			});
			
			$('.hrms-page').pagination({
				pageCount:1,
				totalData: resp.data.count,
				showData: options.queryParams.limit,
				count:4,
				current:options.queryParams.start,
				mode: 'fixed',
				coping: false,
				keepShowPN:false,
				callback:function(pagination){
					console.log(pagination);
					console.log(pagination.getCurrent());
					options.queryParams.start=pagination.getCurrent();
					app.table(options);
				}
			});
			
		});
		
	},
	serializeElement:function(){
		var topEle = $('.right .in .center');
		
		var data = {};
		
		topEle.find('input').each(function(){
			data[this.name] = $.trim($(this).val());
		});
		
		return data;
	},
	checkType:{BLANK:1,LENGTH:2},
	check:function(options){
		
		var elements = options.elements;
		
		for( var i=0 ; i<elements.length ; i++ ){
			var element = elements[i];
			var queryStr = 'input[name="'+element.name+'"]';
			var value = $.trim($(queryStr).val());
			
			for( var j=0 ; j<element.checks.length ; j++ ){
				var check = element.checks[j];
				
				if( check.type == app.checkType.BLANK ){
					//blank
					if( value == null || value.length==0 ){
						layer.tips(check.text,queryStr);
						return false;
					}
				}else if(check.type == app.checkType.LENGTH){
					//length
					if( check.max && value.length > check.max){
						layer.tips('最多输入'+check.max+'个字符',queryStr);
						return false;
					}
				}
				
				
			}
		}
		
		return true;
	},
	alert:function(message,callback){
		layer.alert(message, {icon: 1},callback);
	},
	warn:function(message,callback){
		layer.alert(message, {icon: 2},callback);
	},
	confirm:function(message,callback){
		layer.confirm(message, {icon: 3, title:'提示'},callback);
	},
	isBlank:function(value){
		return (value==null || $.trim(value).length==0);
	},
	cont:{}
}

$(function(){
	app.request('index/cont',{},function(resp){
		app.cont = resp.data;
	});
});

//加法函数
function accAdd(arg1, arg2) {
  var r1, r2, m;
  try {
      r1 = arg1.toString().split(".")[1].length;
  }
  catch (e) {
      r1 = 0;
  }
  try {
      r2 = arg2.toString().split(".")[1].length;
  }
  catch (e) {
      r2 = 0;
  }
  m = Math.pow(10, Math.max(r1, r2));
  return (arg1 * m + arg2 * m) / m;
} 


//减法函数
function Subtr(arg1, arg2) {
  var r1, r2, m, n;
  try {
      r1 = arg1.toString().split(".")[1].length;
  }
  catch (e) {
      r1 = 0;
  }
  try {
      r2 = arg2.toString().split(".")[1].length;
  }
  catch (e) {
      r2 = 0;
  }
  m = Math.pow(10, Math.max(r1, r2));
   //last modify by deeka
   //动态控制精度长度
  n = (r1 >= r2) ? r1 : r2;
  return ((arg1 * m - arg2 * m) / m).toFixed(n);
}


//乘法函数
function accMul(arg1, arg2) {
  var m = 0, s1 = arg1.toString(), s2 = arg2.toString();
  try {
      m += s1.split(".")[1].length;
  }
  catch (e) {
  }
  try {
      m += s2.split(".")[1].length;
  }
  catch (e) {
  }
  return Number(s1.replace(".", "")) * Number(s2.replace(".", "")) / Math.pow(10, m);
} 


//除法函数
function accDiv(arg1, arg2) {
  var t1 = 0, t2 = 0, r1, r2;
  try {
      t1 = arg1.toString().split(".")[1].length;
  }
  catch (e) {
  }
  try {
      t2 = arg2.toString().split(".")[1].length;
  }
  catch (e) {
  }
  with (Math) {
      r1 = Number(arg1.toString().replace(".", ""));
      r2 = Number(arg2.toString().replace(".", ""));
      return (r1 / r2) * pow(10, t2 - t1);
  }
} 