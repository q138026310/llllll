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
					app.alert('登陆失效，请重新登陆');
					location.href = "/hrms";
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
	}
		
}

$.fn.tip = function(message,time){
	if(!time)time = 3;
	
	$(this).tips({
		side:2,
        msg:message,
        bg:'#AE81FF',
        time:time
    });
}

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