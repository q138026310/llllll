$(function(){
	
	$('.hrms-submenu li').click(function(){
		$('.hrms-submenu-itemselected').removeClass("hrms-submenu-itemselected");
		$(this).addClass('hrms-submenu-itemselected');
	});
	
});
