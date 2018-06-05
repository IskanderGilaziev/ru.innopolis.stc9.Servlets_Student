<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div class="container">
    <main class="content">

        <h1 class="title">Cтуденты на удаление:</h1>
        <c:forEach items="${requestScope.get(\"student\")}" var="students">
            <form action="/professor/delete" method="post">

                <input type="hidden" value="${students.id}" name="id">
                <input type="submit" value="del">
                <a href="${pageContext.request.contextPath}/professor/delete?id=${students.name}"
                   name="${students.name}"> ${students.name} </a>


            </form>
        </c:forEach>
        <br>
    </main>
</div>


