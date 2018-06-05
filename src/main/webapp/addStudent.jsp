<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<div class="container">
    <main class="content">

        <h1 class="title">Добавление студента</h1>


        <h1></h1>
        <form action="/professor/add" method="post">
            <input type="text" name="id"> Id-студента<br>
            <input type="text" name="name"> Имя студента <br>
            <input type="text" name="lastName"> Фамилия студента <br>
            <input type="text" name="course"> Курс <br>
            <input type="hidden" name="">
            <input type="button" value="Enter">
        </form>

    </main>
</div>