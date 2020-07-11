<%-- 
    Document   : Home
    Created on : Jul 5, 2020, 2:40:44 PM
    Author     : Juan Enrique Solis Perla
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

    <!-- Auth user -->
    <!-- If there's no user in session object (null), redirect to login page-->
    <c:if test="${currentSessionUser == null}">
        <c:redirect url = "/login"/>
    </c:if>


    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home</title>

        <link rel="stylesheet" href="css/home.css">

        <!-- Google Fonts-->
        <link href="https://fonts.googleapis.com/css2?family=Merriweather+Sans:ital,wght@0,300;0,400;0,700;0,800;1,300;1,400;1,700;1,800&display=swap" rel="stylesheet">
        <link href="https://fonts.googleapis.com/css2?family=Martel+Sans:wght@200&display=swap" rel="stylesheet">
        <link href="https://fonts.googleapis.com/css2?family=Satisfy&display=swap" rel="stylesheet">

        <script src="js/posts.js"></script>
    </head>
    <body>
        <%@include file="jspf/Header.jspf" %>

        <c:if test="${currentSessionUser != null}">
            <div id="usuario-data" class="top-banner" tipo-usuario="<c:out value="${currentSessionUser.getClass().getName()}"/>" user-id="<c:out value="${currentSessionUser.getId()}"/>"><strong>Usuario: <c:out value="${currentSessionUser.getNombreCompleto()}"/> Email: <span id="usuario-email"><c:out value="${currentSessionUser.getCorreo()}"/></span></strong></div>
        </c:if>

        <main>
            <aside></aside>
            <form id="post-form">
                <h3> Crea Nuevo Post </h3>
                <label for="titulo">Titulo</label>
                <input id="titulo" name="titulo" type="text" placeholder="titulo" required/>
                <label for="contenido">Contenido</label>
                <textarea id='contenido' name='contenido' required></textarea>
                <button type="submit">Post</button>
            </form>

            <aside></aside>
            <section id="sectionAnclados"></section>
            <aside></aside>
            <section id="sectionComunes"></section>
        </main>

        <%@include file="jspf/Footer.jspf" %>
    </body>
</html>
