<%@ page import="Servlets.POJO_Stud.Lesson" %>
<%@ page import="Servlets.POJO_Stud.Student" %>
<%@ page import="Servlets.Service.LessonService" %>
<%@ page import="Servlets.Service.LessonServiceImpl" %>
<%@ page import="Servlets.Service.StudentService" %>
<%@ page import="Servlets.Service.StudentServiceImpl" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@include file="header.jsp" %>
<html>
<head>
    <title>Рабочая страница профессора</title>
</head>
<body>


<h1 class="title">Погнали</h1>
<% StudentService studentService = new StudentServiceImpl();
    ArrayList<Student> students = (ArrayList<Student>) studentService.getAllStudent();
    request.setAttribute("students", students);
    LessonService lessonService = new LessonServiceImpl();
    ArrayList<Lesson> lessons = (ArrayList<Lesson>) lessonService.getAllLesson();
    request.setAttribute("lessons", lessons);
%>
<div class="container">
    <main class="content">
        <table> Таблица студентов
            <thead>
            <tr>
                <th>Name</th>
                <th>Last name</th>
                <th>Course</th>
            </tr>
            </thead>

            <tbody>
            <%for (int i = 0; i < students.size(); i++) {%>
            <tr>
                <td><%=students.get(i).getName()%>
                </td>
                <td><%=students.get(i).getLast_name()%>
                </td>
                <td><%=students.get(i).getCourse()%>
                </td>
            </tr>
            <%}%>

            </tbody>

        </table>
    </main>
</div>
</body>
</html>

<%@include file="sidebar.jsp"%>
<%@include file="footer.jsp"%>


