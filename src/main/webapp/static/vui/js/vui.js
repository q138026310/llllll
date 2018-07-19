var vui = {};

/* datagrid start */
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
		var headTr = $('<div class="vui-table-row vui-table-head"></div>');
		for (var i = 0; i < columns.length; i++) {
			var column = columns[i];
			headTr.append('<div class="vui-table-cell">'+column.title+'</div>');
		}
		$(tableId).append(headTr);
	}
	
	function loadData(tableId,data,currpage){
		$(tableId+' div[type="body"]').remove();
		var options = $(tableId).data();
		var columns = options.columns;
		var rows = data.rows;
		for (var i = 0; i < rows.length; i++) {
			var row = rows[i];
			var rowTr = $('<div class="vui-table-row" type="body"></div>');
			for (var j = 0; j < columns.length; j++) {
				var column = columns[j];
				var edit = column.edit?1:0;
				var value = null;
				if(column.field){
					value = row[column.field];
				}else{
					value = column.formatter(row);
				}
				var td =  $('<div class="vui-table-cell" style="width:'+column.width+'px;" edit="'+edit+'">'+value+'</div>');
				if( j==0 ){
					td.css({"border-left":"0px"});
				}else if( j==columns.length-1 ){
					td.css({"border-right":"0px"});
				}
				rowTr.append(td);
				
			}
			$(tableId).append(rowTr);
		}
		
		//1
		$(tableId).find('div[edit="1"]').click(function(){
			var width = $(this).width()-2;
			var height = $(this).height()-3;
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
		$(getOutId(tableId)+' > .page').remove();
		
		var totalPage = getTotalPage(total,options.limit);
		var pageDiv = $('<div class="page"></div>');
		
		pageDiv.append('<a class="first" href="javascript:;"><i class="fa fa-angle-left fa-lg"></i></a>');
		//pageDiv.append('<span class="text">1</span>');
        pageDiv.append('<a class="btn" href="javascript:;" data-page="1">1</a>');
		if(totalPage<6){
			for (var i = 2; i < 6; i++) {
				pageDiv.append('<a class="btn" href="javascript:;" data-page="'+i+'">'+i+'</a>');		
			}
		}else{
			if( currpage>2 ){

			}else{
                pageDiv.append('<a class="btn" href="javascript:;" data-page="2">2</a>');
                pageDiv.append('<a class="btn" href="javascript:;" data-page="3">3</a>');
                pageDiv.append('<span>...</span>');
			}
		}
        pageDiv.append('<a class="btn" href="javascript:;" data-page="'+totalPage+'">'+totalPage+'</a>');
		pageDiv.append('<a class="last" href="javascript:;"><i class="fa fa-angle-right fa-lg"></i></a>');
		pageDiv.append('<span style="font-size:12px;margin-left: 15px;">到第</span><input type="text" class="input"/><span style="font-size:12px;">页</span>');
		pageDiv.append('<input class="ok" style="cursor:pointer;" type="button" value="确定"/>' );
		pageDiv.append('<span style="font-size:12px;margin-left: 15px;">共'+total+'条</span>');
		
		appendPageDiv(tableId,options,pageDiv);
		
		appendEvent(tableId);
	}
	
	function appendEvent(tableId){
		$(getOutId(tableId)+' .page .btn').click(function(){
			loadUrl(tableId,$(this).data('page'));
		});
	}
	
	function appendPageDiv(tableId,options,pageDiv){
		$(getOutId(tableId)).append(pageDiv);
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
		var id = '#'+options.id;
		var tableId = getTableId(options.id);

		$(id).css({"overflow":"hidden"});
		$(id).append('<div id="'+tableId+'"></div>');

		tableId = '#'+tableId;
		$(tableId).data(options);
		return tableId;
	}

	function getTableId(outId){
		return outId+'_table';
	}

	function getOutId(tableId){
		return tableId.replace('_table','');
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
			error:function(){
				alert('error');
			}
		});
	}
}

/* datagrid end */

/* window start */


vui.alert = function(options){
	var windowId = new Date().getTime();
	var width = 260,height = 150;
	var left = $(document.body).width();
	var top = $(document.body).height();

    vui.lastWindowId = windowId;
}
/* window end */
