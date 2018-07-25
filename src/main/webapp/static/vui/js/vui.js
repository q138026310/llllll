var vui = {};

/* datagrid start */
vui.datagrid = function(options,id,params){
	
	if( typeof(options) != 'object' ){
		if( options =='reload' ){
            loadUrl(getTableId(id),1);
		}else if( options =='loadData' ){
            loadData(getTableId(id),params,1);
        }
		return;
	}
	
	options = $.extend({page:1,limit:10,pagination:true},options);
	
	var tableId = setOptions(options);
	$(tableId).addClass('vui-table');
	loadHead(options);
	if(options.url){
        loadUrl(tableId);
	}

	function loadHead(options){
		var columns = options.columns;
		var headTr = $('<div class="vui-table-row vui-table-head"></div>');
        if( options.rownum ){
            headTr.append('<div class="vui-table-cell" style="width:20px;"></div>');
		}
		for (var i = 0; i < columns.length; i++) {
			var column = columns[i];
			if(column.edit){
                headTr.append('<div class="vui-table-cell" style="width:'+column.width+'px;"><span style="color:blue;">'+column.title+'</span></div>');
			}else{
                headTr.append('<div class="vui-table-cell" style="width:'+column.width+'px;">'+column.title+'</div>');
			}

		}
		$(tableId).append(headTr);
	}

	function getTableWidth(options){
		var width = $(document.body).width();
		if( options.width ){
			width = options.width;
		}
		return width;
	}

	function setColumnWidth(tableWidth,options){

		var optionsWidth = 0;
		var fixedWidth = options.columns.length+1;
        $.each(options.columns,function(j,column){
        	if(column.fixed){
                fixedWidth = app.add(fixedWidth,column.width,0);
			}else{
                optionsWidth = app.add(optionsWidth,column.width,0);
			}
        });
        var rate = app.div(optionsWidth,app.sub(tableWidth,fixedWidth,0),10);

        $.each(options.columns,function(j,column){
            if(!column.fixed){
                column.width = app.div(column.width,rate,0);
            }
        });

	}
	
	function loadData(tableId,data,currpage){
		$(tableId+' div[type="body"]').remove();
		var options = $(tableId).data();
		var columns = options.columns;
		var rows = data.rows;

		$.each(rows,function(i,row){
            var rowTr = $('<div class="vui-table-row" type="body"></div>');
            if( options.rownum ){
                rowTr.append('<div class="vui-table-cell vui-table-rownum">'+(i+1)+'</div>');
			}
            $.each(columns,function(j,column){
                var value=null;
                if(column.formatter){
                    value = column.formatter(row);
                }else{
                    value = row[column.field];
                }
                if(!value){value="";}

                var colTd = null;
                if(column.edit){
                    colTd =  $('<div class="vui-table-cell"  edit="'+column.edit+'">'+value+'</div>');
				}else{
                    colTd =  $('<div class="vui-table-cell">'+value+'</div>');
				}

                rowTr.append(colTd);
			});
            $(tableId).append(rowTr);
		});

		
		//1
		$(tableId).find('div[edit]').click(function(){
			var edit = $(this).attr('edit');
			if( edit=='input' ){
				if($(this).find('input').length>0){
					return;
				}
                var width = $(this).width()-2;
                var height = $(this).height()-4;
                var _input = $('<input type="text" style="width:'+width+'px;height:'+height+'px;" class="editext" value="'+$(this).html()+'"/>');
                _input.blur(function(){
                    $(this).parent().html($(this).val());
                });
                $(this).empty();
                $(this).append(_input);
                moveEnd($(this).find('input').get(0));
			}
		});
		//1

		if( options.pagination ){
            loadPage(tableId,options,data.total,currpage);
		}

		try{
            if(loadDataSuccess){
                loadDataSuccess();
            }
		}catch (e){}

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
        pageDiv.append(getPageNumEle(1));
		if(totalPage<6){
			for (var i = 2; i < 6; i++) {
				pageDiv.append(getPageNumEle(i));
			}
		}else{
			if( currpage>2 ){

			}else{
                pageDiv.append(getPageNumEle(2));
                pageDiv.append(getPageNumEle(3));
                pageDiv.append('<span>...</span>');
			}
		}
        pageDiv.append(getPageNumEle(totalPage));
		pageDiv.append('<a class="last" href="javascript:;"><i class="fa fa-angle-right fa-lg"></i></a>');
		pageDiv.append('<span style="font-size:12px;margin-left: 15px;">到第</span><input type="text" class="input"/><span style="font-size:12px;">页</span>');
		pageDiv.append('<input class="ok" style="cursor:pointer;" type="button" value="确定"/>' );
		pageDiv.append('<span style="font-size:12px;margin-left: 15px;">共'+total+'条</span>');
		
		appendPageDiv(tableId,options,pageDiv);
		
		appendEvent(tableId);
	}

	function getPageNumEle(num){
		return '<a class="btn" href="javascript:;" data-page="'+num+'">'+num+'</a>';
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

        var tableWidth = getTableWidth(options);
        $(tableId).width(tableWidth);
        setColumnWidth(tableWidth,options);

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

