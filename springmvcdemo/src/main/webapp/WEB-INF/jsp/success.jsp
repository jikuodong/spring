<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContext.request.contextPath }" />
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>成功页面</title>
    <link rel="stylesheet" type="text/css" href="${ctx}/plugins/bootstrap/css/bootstrap.css">
    <link rel="stylesheet" type="text/css" href="${ctx}/plugins/bootStrapTable/bootstrap-table.min.css">
    <link rel="stylesheet" href="${ctx}/plugins/bootstrap/css/font-awesome.min.css">
    <script type="text/javascript" src="${ctx}/plugins/jquery/jquery-3.4.1.min.js"></script>t>
    <script type="text/javascript" src="${ctx}/plugins/bootstrap/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="${ctx}/plugins/bootStrapTable/bootstrap-table.min.js" ></script>
    <script type="text/javascript" src="${ctx}/plugins/bootStrapTable/bootstrap-table-zh-CN.min.js" ></script>
</head>
<body>
    <table id="ArbetTable"></table>
</body>

<script type="text/javascript">
     $(function () {
         //1.初始化Table
         var oTable = new TableInit();
         oTable.Init();
        });
     var TableInit = function () {
         var oTableInit = new Object();
         //初始化Table
         oTableInit.Init = function () {
             $('#ArbetTable').bootstrapTable({
                 url : '${ctx}/user/getUser.do',//定义获取数据的url *
                 method : 'post',//访问的方式 *
                 contentType : "application/x-www-form-urlencoded", // 不指定contentType 的话就会默认以application/json的方式发送数据，java就不能用getParameter拿到内容
                 toolbar : '#toolbar',//指定工具栏用哪个容器显示
                 striped : true,//是否显示行间隔颜色
                 cache : false,//是否使用缓存 *
                 pagination : true,//是否显示分页 *
                 sortable : false,//是否启用排序
                 sortOrder : 'dec',//排序方式
                 queryParams : oTableInit.queryParams,//传递参数 *
                 queryParamsType: "",
                 sidePagination : 'server',//分页方式，客户端or服务端 *
                 pageNumber : 1,//初始化加载第一页 第几页
                 pageSize : 10,//每页显示行数 *
                 pageList : [10,20,50,100],//可选每页显示个数 *
                 search : false,//是否显示搜索PS.只搜索此表格，不是数据库
                 strictSearch : false,//设置为 true启用 全匹配搜索，否则为模糊搜索
                 showRefresh : true,//是否显示刷新按钮
                 showToggle : true,//是否显示详细视图和列表视图的切换按钮
                 showColumns : false,//是否显示所有的列
                 minimumCountColumns : 1,//最少允许的列数，当列数小于此值时，将隐藏内容列下拉框
                 clickToSelect : false,//是否启用点击选中行
                 //height : 50,//行高，不写则自动调整
                 uniqueId : 'USER_ID',//唯一标识id *
                 cardView : false,//是否显示详细视图
                 detailView : false,//是否显示父子表
                 columns: [
                     {
                         title: '序号',
                         width: '1%',
                         align: 'center',
                         formatter: function (value,row,index) {
                             return index + 1;
                         }
                     },
                     {
                         field: 'USER_NAME',
                         title: '名字'
                     }, {
                         field: 'PHONE',
                         title: '手机'
                     },
                     {
                         field: 'operate',
                         title: '操作'
                     },
                 ]
             });
         };
         debugger
         oTableInit.queryParams = function (params) {
             debugger
             let temp = {
                 limit: params.pageSize,
                 offset: params.pageNumber,
             };
             debugger
             return temp;
         };
         return oTableInit;
     };
</script>
</html>
