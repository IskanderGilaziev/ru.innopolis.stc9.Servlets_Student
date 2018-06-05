<%@ page import="Servlets.POJO_Stud.HomeWork" %>
<%@ page import="Servlets.POJO_Stud.Lesson" %>
<%@ page import="Servlets.POJO_Stud.Professor" %>
<%@ page import="Servlets.Service.*" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@include file="header.jsp"%>

<h1 class="title">Рабочая страница студента</h1>
<% LessonService lessonService = new LessonServiceImpl();
    ArrayList<Lesson> lessons = (ArrayList<Lesson>) lessonService.getAllLesson();
    request.setAttribute("lessons", lessons);
    HomeWorkService homeWorkService = new HomeWorkServiceImpl();
    List<HomeWork> homeWork = homeWorkService.getAllHomeWork();
    request.setAttribute("homeWork", homeWork);
    ProfessorService professorService = new ProfessorServiceImpl();
    List<Professor> professors = professorService.getAllProfessor();
    request.setAttribute("prof", professors);

%>
<div class="container">
    <main class="content">
        <h1>
            <ul>
                <c:forEach var="lessons" items="${lessons}">
                    <li>
                        Тема занятия: ${lessons.theme} <br>
                        Посещение занятия:${lessons.lesson}<br>
                    </li>
                </c:forEach>


            </ul>
        </h1>

    </main>
</div>


<%@include file="footer.jsp"%>
