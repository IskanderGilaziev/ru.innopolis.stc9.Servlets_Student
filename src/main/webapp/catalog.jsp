<%--
  Created by IntelliJ IDEA.
  User: Искандер
  Date: 15/05/2018
  Time: 23:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="header.jsp"%>

<div class="container">
    <main class="content">
        <strong>catalog</strong>
        <%if((Integer)request.getSession().getAttribute("role")==1){%>
            this content admin
        <%}%>
        this content user
    </main><!-- .content -->
</div><!-- .container-->

<%@include file="sidebar.jsp"%>
<%@include file="footer.jsp"%>
