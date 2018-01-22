$(function(){
	$('#username').focus();
	
	$('.btn').click(function(){
		var username = $('#username').val();
		var password = $('#password').val();
		
		if( username.length == 0 ){
			$('#username').tip('请输入用户名');
			return;
		}
		
		if( password.length == 0 ){
			$('#password').tip('请输入密码');
			return;
		}
		
		app.request('index/login',{username:username,password:password},function(resp){
			
			if( resp.result==0 ){
				location.href = "/hrms/html/index/index.html";
			}else if(resp.result==100000){
				$('#username').tip('用户名为空');
			}else if(resp.result==100001){
				$('#password').tip('密码为空');
			}else if(resp.result==100002){
				$('#password').tip('密码错误');
			}else if(resp.result==100003){
				$('#username').tip('用户名不存在');
			}
		});
		
	});
});