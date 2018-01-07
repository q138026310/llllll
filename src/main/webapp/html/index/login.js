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
		
		app.request('index/login',{username:username,password:password},function(){
			
		});
		
	});
});