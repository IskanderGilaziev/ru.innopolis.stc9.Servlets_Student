<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<div class="container">
    <main class="content">

        <h1 class="title">Добавление студента:</h1>

        <form action="/professor/addLesson" method="post">

            <input type="text" name="id" value=""> Id-занятия<br>
            <input type="text" name="idStudent" value="">Id студента <br>
            <input type="text" name="idProfessor" value=""> Id профессора <br>
            <input type="text" name="theme" value=""> Тема занятия <br>
            <input type="text" name="isLesson" value=""> Посещение занятия <br>
            <input type="submit" value="Enter">
        </form>

    </main>
</div>