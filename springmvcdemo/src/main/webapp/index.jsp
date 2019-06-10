<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<body>
<h2>Hello World!</h2>
<button onclick="ceshi()">测试</button>
<script>
    function ceshi(){
        window.location.href='<%=basePath%>user/test.do?a='+ "111111";
    }
</script>
</body>
</html>
