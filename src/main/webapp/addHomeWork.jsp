<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<div class="container">
    <main class="content">

        <h1 class="title">Добавление домашней работы</h1>

        <form action="/professor/addHomeWork" method="post">

            <input type="text" name="name" value=""> Домашняя работа <br>
            <input type="text" name="course" value=""> id-профессора <br>
            <input type="button" value="Enter">
        </form>

    </main>
</div>