$(function(){
	$('#centerFrame').width($('#centerDiv').width()-195);
	$('#centerFrame').height($('#centerDiv').height()-65);
	
	
	$('.head .logo').click(function(){
		loadCenter("index/demo");
	});
	
	var user = app.json($.cookie('user'));
	
	app.request('menu/find',{id:user.id,userType:user.userType},function(menus){
		$(menus).each(function(i,menu){
			if( menu.parentCode == -1 ){
				$('#index_menus').append('<a href="javascript:;" class="fit"></a><a href="#" class="label2" tcode="'+menu.code+'">'+menu.name+'</a>');
			}
		});
		
		$('.head .menu .label2').click(function(){
			$('.head .menu a').css({"border-bottom":"none"});
			$(this).css({"border-bottom":"3px solid #ffffff"});
			
			if( $(this).html()=='首页' ){
				$('#centerFrame').attr('src',app.baseUrl+"html/index/company_index.html");
				return;
			}
			
			var thiscode = $(this).attr('tcode');
			
			$('#index_left ul').empty();
			
			$(menus).each(function(i,menu){
				if( menu.parentCode == thiscode ){
					$('#index_left ul').append('<li onclick="loadCenter(\''+menu.url+'\',this)"> <img alt="" src="/plant-admin/static/images/phone.png"> <label>'+menu.name+'</label></li>');
				}
			});
			
		});
		
		$('.head .menu .label2').each(function(){
			if($(this).html()=='企业资料'){
				$(this).click();
				return false;
			}
		});
	});
	
	$('#user_name').html(user.username);
	
	$(".bonu_pub").hover(function (){  
	    $(this).children(".bounces").fadeIn();
	},function (){  
		$(this).children(".bounces").fadeOut("fast");  
	});
	
	
	
	
});

function exit(){
	app.request('index/logout',{},function(resp){
		if(resp.result==0){
			$.cookie('user',null,{path:"/plant-admin"});
			$.cookie('plantsessionId',null,{path:"/plant-admin"});
			$.cookie('targetId',null,{path:"/plant-admin"});
			location.href = "/plant-admin";
		}
	});
	
}

function loadCenter(url,_this){
	$('#index_left ul li').css({"background":"none"});
	$(_this).css({"background":"#2a3445"});
	if( url.indexOf('?') == -1 ){
		$('#centerFrame').attr('src',app.baseUrl+"html/"+url+".html");
	}else{
		var xurl = url.split('?');
		$('#centerFrame').attr('src',app.baseUrl+"html/"+xurl[0]+".html?"+xurl[1]);
	}
}