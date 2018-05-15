<%--
  Created by IntelliJ IDEA.
  User: Искандер
  Date: 15/05/2018
  Time: 22:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<aside class="left-sidebar">
    <strong>Left Sidebar:</strong>
    <c:set var="userName" value="Name"/>

    <c:if test="${10>9}">
        <p>true</p>
    </c:if>

    <c:forEach var="num" items="${list}">
        <p>
            ${num}
        </p>
    </c:forEach>

    <c:forEach items="${requestScope.get(\"student\")}" var="stud">
        <a href="/teacher/student?id=${stud.id}" name="${stud.lastName}">
            ${stud.firstName} ${stud.lastName}
        </a><br>
    </c:forEach>

</aside><!-- .left-sidebar -->
