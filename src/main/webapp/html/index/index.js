$(function(){
	
	$('.hrms-submenu li').click(function(){
		$('.hrms-submenu-itemselected').removeClass("hrms-submenu-itemselected");
		$(this).addClass('hrms-submenu-itemselected');
	});
	
	app.request('menu/findUserMenu',{},function(resp){
		
		$.each(resp.data,function(i,menu){
			//hrms-menu-item-selected
			if( menu.parentId == -1 ){
				$('.hrms-menu').append('<li id="menu'+menu.id+'" class="hrms-menu-item" role="menuitem" aria-selected="false"><div>'+menu.name+'</div></li>');
			}
			
			$('.hrms-menu > li').click(function(){
				$('.hrms-submenu').empty();
				
				var menuId = $(this).attr('id').replace('menu','');
				
				$.each(resp.data,function(i,m){
					//hrms-submenu-itemselected
					if( m.parentId == menuId ){
						$('.hrms-submenu').append('<li class="hrms-submenu-item "><div class="icon"><img src="/hrms/static/images/order.png"></div><div class="text">'+m.name+'</div></li>');
					}
				});
			});
		});
		
	});
	
});
