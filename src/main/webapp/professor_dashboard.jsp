<%@ page import="Servlets.DAO_Stud.ProfessorDAOImpl" %>
<%@ page import="java.sql.SQLException" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="header.jsp"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<% ProfessorDAOImpl professorDAO = new ProfessorDAOImpl();%>
        <div class="container">
            <main class="content">
                <strong>Рабочее пространство профессора</strong>
                    <h2>
                        Приветествую Вас,

                    /h2>
                </main><!-- .content -->
        </div><!-- .container-->

<%@include file="sidebar.jsp"%>
<%@include file="footer.jsp"%>


