var vui = {};

vui.datagrid = function(options,method,params){
	
	if( typeof(options) != 'object' ){
		return;
	}
	
	options = $.extend({page:1,limit:10},options);
	
	var tableId = setOptions(options);
	$(tableId).addClass('vui-table');
	loadHead(options);
	loadUrl(tableId);
	
	
	function loadHead(options){
		var columns = options.columns;
		var headTr = $('<tr></tr>');
		for (var i = 0; i < columns.length; i++) {
			var column = columns[i];
			headTr.append('<th>'+column.title+'</th>');
		}
		$(tableId).append(headTr);
	}
	
	function loadData(tableId,data,currpage){
		$(tableId+' tr[type="body"]').remove();
		var options = $(tableId).data();
		var columns = options.columns;
		var rows = data.rows;
		for (var i = 0; i < rows.length; i++) {
			var row = rows[i];
			var rowTr = $('<tr type="body"></tr>');	
			for (var j = 0; j < columns.length; j++) {
				var column = columns[j];
				var edit = column.edit?1:0;
				if(column.field){
					rowTr.append('<td edit="'+edit+'">'+row[column.field]+'</td>');	
				}else{
					rowTr.append('<td edit="'+edit+'">'+column.formatter(row)+'</td>');
				}
				
			}
			$(tableId).append(rowTr);
		}
		
		//1
		$(tableId).find('td[edit="1"]').click(function(){
			var width = $(this).width();
			var height = $(this).height();
			var _input = $('<input type="text" style="width:'+width+'px;height:'+height+'px;" class="editext" value="'+$(this).html()+'"/>');
			_input.blur(function(){
				$(this).parent().html($(this).val());
			});
			$(this).empty();
			$(this).append(_input);
			moveEnd($(this).find('input').get(0));
		});
		
		
		//1
		
		loadPage(tableId,options,data.total,currpage);
	}
	
	
	function moveEnd(obj){
        obj.focus(); 
        var len = obj.value.length;
        if (document.selection) { 
            var sel = obj.createTextRange(); 
            sel.moveStart('character',len); //设置开头的位置
            sel.collapse(); 
            sel.select(); 
        } else if (typeof obj.selectionStart == 'number' && typeof obj.selectionEnd == 'number') { 
            obj.selectionStart = obj.selectionEnd = len; 
        } 
    } 
	
	function loadPage(tableId,options,total,currpage){
		$(tableId+' .page').parent().parent().remove();
		
		var totalPage = getTotalPage(total,options.limit);
		var pageDiv = $('<div class="page"></div>');
		
		pageDiv.append('<a class="first" href="javascript:;"><i class="fa fa-angle-left fa-lg"></i></a>');
		pageDiv.append('<span class="text">1</span>');
		if(totalPage<6){
			for (var i = 2; i < 6; i++) {
				pageDiv.append('<a class="btn" href="javascript:;" data-page="'+i+'">'+i+'</a>');		
			}
		}else{
			pageDiv.append('<a class="btn" href="javascript:;" data-page="2">2</a>');
			pageDiv.append('<a class="btn" href="javascript:;" data-page="3">3</a>');
			pageDiv.append('<span>...</span>');
			pageDiv.append('<a class="btn" href="javascript:;" data-page="'+totalPage+'">'+totalPage+'</a>');
		}
		
		pageDiv.append('<a class="last" href="javascript:;"><i class="fa fa-angle-right fa-lg"></i></a>');
		pageDiv.append('<span style="font-size:12px;margin-left: 15px;">到第</span><input type="text" class="input"/><span style="font-size:12px;">页</span>');
		pageDiv.append('<input class="ok" style="cursor:pointer;" type="button" value="确定"/>' );
		pageDiv.append('<span style="font-size:12px;margin-left: 15px;">共'+total+'条</span>');
		
		appendPageDiv(tableId,options,pageDiv);
		
		appendEvent(tableId);
		
	}
	
	function appendEvent(tableId){
		$(tableId+' .page .btn').click(function(){
			loadUrl(tableId,$(this).data('page'));
		});
	}
	
	function appendPageDiv(tableId,options,pageDiv){
		var td = $('<td colspan="'+options.columns.length+'" style="padding:0px;"></td>');
		td.append(pageDiv);
		var tr = $('<tr></tr>');
		tr.append(td);
		$(tableId).append(tr);
	}
	
	function getTotalPage(total,limit){
		var totalPage = null;
		if(total%limit==0){
			totalPage = total/limit;
		}else{
			totalPage = parseInt(total/limit)+1;
		}
		return totalPage;
	}
	
	function setOptions(options){
		var tableId = '#'+options.id;
		$(tableId).data(options);
		return tableId;
	}
	
	function loadUrl(tableId,page){
		var options = $(tableId).data();
		var currpage = page?page:1;
		$.ajax({
			type:"get",
			url:options.url,
			data:{page:currpage,limit:10},
			dataType:'json',
			success:function(data){
				loadData(tableId,data,currpage);
			},
			error:function(e){
				alert('error');
			}
		});
	}
}
