var menus = null;
var param = app.getReqeustParams();

$(function(){
	
	app.request('menu/findUserMenu',{},function(resp){
		menus = resp.data;
		
		$.each(resp.data,function(i,menu){
			//hrms-menu-item-selected
			if( menu.parentId == -1 ){
				if( menu.id == param.rectmid ){
					$('.hrms-menu').append('<li id="menu'+menu.id+'" class="hrms-menu-item hrms-menu-item-selected" role="menuitem" aria-selected="false"><div>'+menu.name+'</div></li>');
				}else{
					$('.hrms-menu').append('<li id="menu'+menu.id+'" class="hrms-menu-item" role="menuitem" aria-selected="false"><div>'+menu.name+'</div></li>');
				}
			}
			
			$('.hrms-menu > li').click(function(){
				changeMenu($(this));
			});
			
			changeMenu($('#menu'+param.rectmid));

		});
		
	});
	
	if(param.redirect){
		$('.right .in').load('/hrms/html/'+param.redirect+'.html');
	}
	
});

function changeMenu(_this){
	if( _this==null || _this.length==0){
		return;
	}

	
	$('.hrms-menu-item-selected').removeClass('hrms-menu-item-selected');
	$(_this).addClass('hrms-menu-item-selected');
	
	$('.hrms-submenu').empty();
	
	var menuId = $(_this).attr('id').replace('menu','');
	
	$.each(menus,function(i,m){
		//hrms-submenu-itemselected
		if( m.parentId == menuId ){
			if(param.rectsmid == 'menu'+m.id){
				$('.hrms-submenu').append('<li mid="'+menuId+'" id="menu'+m.id+'" url="'+m.href+'" class="hrms-submenu-item hrms-submenu-itemselected"><div class="icon"><img src="/hrms/static/images/order.png"></div><div class="text">'+m.name+'</div></li>');
			}else{
				$('.hrms-submenu').append('<li mid="'+menuId+'" id="menu'+m.id+'" url="'+m.href+'" class="hrms-submenu-item "><div class="icon"><img src="/hrms/static/images/order.png"></div><div class="text">'+m.name+'</div></li>');
			}
			
		}
		
		$('.hrms-submenu li').click(function(){
			/*$('.hrms-submenu-itemselected').removeClass("hrms-submenu-itemselected");
			$(this).addClass('hrms-submenu-itemselected');*/
			var url = $(this).attr('url');
			var sid = $(this).attr('id');
			var mid = $(this).attr('mid');
			location.href = '/hrms/html/index/index.html?redirect='+url+'&rectmid='+mid+'&rectsmid='+sid;
		});
	});

}
