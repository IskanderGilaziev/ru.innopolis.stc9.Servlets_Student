<%--
  Created by IntelliJ IDEA.
  User: Искандер
  Date: 15/05/2018
  Time: 22:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<head>
    <meta charset="utf-8" />
    <script src="https://cdnjs.cloudflare.com/ajax/libs/html5shiv/3.7.3/html5shiv.min.js"></script>
    <![endif]-->
    <title></title>
    <meta name="keywords" content="" />
    <meta name="description" content="" />
    <link href="../webResource/style.css" rel="stylesheet">
</head>

<body>

<div class="wrapper">

    <header class="header">
        <div class="main_header">Самый лучший университет!</div>
        <div class="logout">
            <%=(String) request.getSession().getAttribute("login")
            %>
            <a href="${pageContext.request.contextPath}/login?action=logout">Выйти</a>
        </div>
    </header><!-- .header-->

    <div class="middle">
