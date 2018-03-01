<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  	<%@ include file="/public/head.jspf"%>
  	<style type="text/css">
  		.searchbox {
		  margin:-3;
		}
  	</style>
  	<script type="text/javascript">
  		$(function(){
  			$('#dg').datagrid({ 
  			//
  			loadMsg:'请等待..........',
  			//请求url的地址   
		    url:'room_queryJoinRoomcategoryAndRoomsateAndClientAndUser.action',
		 	//在请求远程数据的时候发送额外的参数
		 	queryParams:{rname:''},
		 	//显示斑马线
		 	striped:true,
		 	//如果为true，则只允许选择一行，全选会功能失效
		 	//singleSelect:true,
		 	//如果为true，则在同一行中显示数据。设置为true可以提高加载性能。默认true
		 	nowrap:true,
		 	toolbar: [{
					iconCls: 'icon-add',
					text:'添加客房',
					handler: function(){
						parent.$("#win").window({
						title:'添加客房',
						width:400,
						height:420,
						content:'<iframe src="send_room_save.action" frameborder="0" width="100%" height="100%"/>'
					});
					}
			},'-',{
					iconCls: 'icon-edit',
					text:'更新客房',
					handler: function(){
						//判断是否有选中行记录
						var rows=$("#dg").datagrid("getSelections");
						if(rows.length!=1){
							//弹出提示信息
							$.messager.show({
								title:'错误提示',
								msg:'只能更新一条记录！',
								timeout:2000,
								showType:'slide'
							});
						}else{
							//弹出更新页面
							parent.$("#win").window({
								title:'更新客房',
								width:400,
								height:420,
								content:'<iframe src="send_room_update.action" frameborder="0" width="100%" height="100%"/>'
							});
						}
					}
			},'-',{
					iconCls: 'icon-remove',
					text:'删除客房',
					handler: function(){
						//判断是否有选中行记录
						var rows=$("#dg").datagrid("getSelections");
						//rows 返回选中的行，没有任何行被选中，则返回空数组
						if(rows.length==0){
							//弹出提示信息
							$.messager.show({
								title:'错误提示',
								msg:'至少选中一条记录！',
								timeout:2000,
								showType:'slide'
							});
						}else{
							//提示是否确认删除，如果确认则执行删除的逻辑
							$.messager.confirm('删除确认对话框', '是否要删除选中的记录？', function(r){
							if (r){
							   //1：获取被选中的记录，然后从记录中获取相应的id
							   var rids="";
							   //2：拼接id的值，然后发送给后台
							   for(var i=0;i<rows.length;i++){
							   		rids += rows[i].rid + ",";
							   }
							   //去掉最后一个逗号
							   rids=rids.substring(0, rids.lastIndexOf(","));
							   //3：发送ajax请求
							   $.post("room_deleteByRids.action",{rids:rids},function(result){
							   		if(result=="true"){
							   			//清除所有选中的行
							   			$("#dg").datagrid("clearSelections");
							   			//重新刷新当前页面
							   			$("#dg").datagrid("reload");
							   		}else{
							   			$.messager.show({
											title:'删除异常',
											msg:'删除失败，请检查操作！',
											timeout:2000,
											showType:'slide'
										});
							   		}
							   },"text");
							}
						});	
					}
				}
			},'-',{
					text:"<input id='ss' name='search'/>",
			}],
			pageSize:15,
			pageList:[5,10,15,20],
			//在底部显示分页工具箱
			pagination:true,
			//自动适应列,如果设置，则不会显示水平滚动条，在显示冻结列时此参数不要设置
			fitColumns:true,
		    //同列属性，但是这些列将会被冻结在左侧。
		    frozenColumns:[[
		    	//xyz任意取的  但不能为空
		    	{field:'xyz',checkbox:true},
		    	{field:'rid',title:'编号',width:100},
		    ]],
		    //配置dg得到列字段field:列字段的名称，与json的key捆绑title:列标题   
		    columns:[[  
		        {field:'rname',title:'客房号码',width:100,
		        //用来格式化当前列的值，返回的是最终的数据
			        formatter: function(value,row,index){
						return "<span title="+value+">"+value+"</span>";
					}
		        },
		        {field:'roomcategory.rcname',title:'客房类型',width:100,
		        	formatter: function(value,row,index){
		        		if(row.roomcategory!=null && row.roomcategory.rcname!=null){
		        			return row.roomcategory.rcname;
		        		}
					}
		        },    
		        {field:'roomcategory.rcprice',title:'客房单价',width:100,
		        	formatter: function(value,row,index){
		        		if(row.roomcategory!=null && row.roomcategory.rcprice!=null){
		        			return row.roomcategory.rcprice;
		        		}
					}
		        },    
		        {field:'roomstate.rsname',title:'客房状态',width:100,
		        	formatter: function(value,row,index){
		        		if(row.roomstate!=null && row.roomstate.rsname!=null){
		        			return row.roomstate.rsname;
		        		}
					}
		        },
		        {field:'rremark',title:'备注',width:100,
		        //用来格式化当前列的值，返回的是最终的数据
			        formatter: function(value,row,index){
						return "<span title="+value+">"+value+"</span>";
					}
		        }   
		    ]]    
		});
		
		//把普通的文本框转换为搜索文本框
			$('#ss').searchbox({
				//触发查询时间
				searcher:function(value,name){
				//获取当前查询的关键字，通过dg加载相应的信息 
				//alert(value + "," + name); 
				$('#dg').datagrid('load',{
					rname: value,
				});
				}, 
				prompt:'客房号码' 
			});  
  			
  		});
  	</script>
  </head>
  
  <body>
  	<table id="dg"></table>  
  </body>
</html>
