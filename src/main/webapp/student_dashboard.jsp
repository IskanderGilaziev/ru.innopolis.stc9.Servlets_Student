<%@ page import="Servlets.DAO_Stud.StudentDAOImpl" %><%--
  Created by IntelliJ IDEA.
  User: Искандер
  Date: 15/05/2018
  Time: 23:10
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@include file="header.jsp"%>
<% StudentDAOImpl student = new StudentDAOImpl();%>
<div class="container">
    <main class="content">
        <strong>Рабочее пространство студента</strong>
        <strong><%= request.getSession().getAttribute("name")%>, hello! </strong>

        <table>
            <tr>
                <td>Имя студента</td>
                <td>Фамилия студента</td>

            </tr>
            <c:forEach var="student" items="${listStudent}">
                <tr>
                    <td><p> ${student.getName()}</p></td>
                </tr>
                <tr>
                    <td><p> ${student.getLast_name()}</p></td>
                </tr>
            </c:forEach>
        </table>
        
    </main><!-- .content -->
</div><!-- .container-->

<%@include file="sidebar.jsp"%>
<%@include file="footer.jsp"%>
