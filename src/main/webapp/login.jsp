<%--
  Created by IntelliJ IDEA.
  User: Искандер
  Date: 14/05/2018
  Time: 22:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Регистрация</title>
</head>
<body>

    <%= request.getAttribute("message") %>
    <%=("authError".equals(request.getParameter("errorMsg")))? "неверно ввели логин или пароль": ""%><br>
    <%=("noAuth".equals(request.getParameter("errorMsg"))) ? "необходимо идентифицироваться":""%>
    <form action="${pageContext.request.contextPath}/login" method="post">

        <input type="text" placeholder="user" name="userName"><br>
        <input type="text" placeholder="password" name="userPassword"><br>
        <input type="submit" value="OK" ><br>
    </form>



</body>
</html>
