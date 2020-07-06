<%-- 
    Document   : Home
    Created on : Jul 5, 2020, 2:40:44 PM
    Author     : juan
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home</title>

        <link rel="stylesheet" href="css/home.css">

        <!-- Google Fonts-->
        <link href="https://fonts.googleapis.com/css2?family=Merriweather+Sans:ital,wght@0,300;0,400;0,700;0,800;1,300;1,400;1,700;1,800&display=swap" rel="stylesheet">
        <link href="https://fonts.googleapis.com/css2?family=Martel+Sans:wght@200&display=swap" rel="stylesheet">
        <link href="https://fonts.googleapis.com/css2?family=Satisfy&display=swap" rel="stylesheet">
    </head>
    <body>
        <%@include file="jspf/Header.jspf" %>

        <div class="top-banner"><strong>Usuario: <c:out value="${currentSessionUser.getNombreCompleto()}"/> Email: <c:out value="${currentSessionUser.getCorreo()}"/></strong></div>
        <main>

            <aside>
            </aside>
            <section>
                <c:forEach items="${postsAnclados}" var="postAnclado">
                    <article class="admin-post">
                        <p>by: <strong><span class="user-email"><c:out value="${postAnclado.getUsuarioAdministrador().getCorreo()}"/></span></strong></p>
                        <h2><c:out value="${postAnclado.getTitulo()}"/></h2>
                        <p><c:out value="${postAnclado.getContenido()}"/></p>
                    </article>
                </c:forEach>

                <article class="admin-post">
                    <p>by: <strong><span class="user-email">juan@gmail.com</span></strong></p>
                    <h2>Title Admin Post</h2>
                    <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Praesent elementum facilisis velit, at fermentum
                        ipsum ullamcorper eget. Duis et porta nunc. Pellentesque quis facilisis ipsum. Fusce iaculis vel est
                        quis
                        volutpat.</p>
                </article>
                <article class="admin-post">
                    <p>by: <strong><span class="user-email">juan@gmail.com</span></strong></p>
                    <h2>Title Admin Post</h2>
                    <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Praesent elementum facilisis velit, at fermentum
                        ipsum ullamcorper eget. Duis et porta nunc. Pellentesque quis facilisis ipsum. Fusce iaculis vel est
                        quis
                        volutpat.</p>
                </article>
                <article class="admin-post">
                    <p>by: <strong><span class="user-email">juan@gmail.com</span></strong></p>
                    <h2>Title Admin Post</h2>
                    <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Praesent elementum facilisis velit, at fermentum
                        ipsum ullamcorper eget. Duis et porta nunc. Pellentesque quis facilisis ipsum. Fusce iaculis vel est
                        quis
                        volutpat.</p>
                </article>
                
                <c:forEach items="${postsComunes}" var="postComun">
                    <article class="normal-post">
                        <p>by: <strong><span class="user-email"><c:out value="${postComun.getUsuario().getCorreo()}"/></span></strong></p>
                        <h2><c:out value="${postComun.getTitulo()}"/></h2>
                        <p><c:out value="${postComun.getContenido()}"/></p>
                    </article>
                </c:forEach>
                
                <article class="normal-post">
                    <p>by: <strong><span class="user-email">juan@gmail.com</span></strong></p>
                    <h2>Title Normal Post</h2>
                    <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Praesent elementum facilisis velit, at fermentum
                        ipsum ullamcorper eget. Duis et porta nunc. Pellentesque quis facilisis ipsum. Fusce iaculis vel est
                        quis
                        volutpat.</p>
                </article>

                <article class="normal-post">
                    <p>by: <strong><span class="user-email">juan@gmail.com</span></strong></p>
                    <h2>Title Normal Post</h2>
                    <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Praesent elementum facilisis velit, at fermentum
                        ipsum ullamcorper eget. Duis et porta nunc. Pellentesque quis facilisis ipsum. Fusce iaculis vel est
                        quis
                        volutpat.</p>
                </article>

                <article class="normal-post">
                    <p>by: <strong><span class="user-email">juan@gmail.com</span></strong></p>
                    <h2>Title Normal Post</h2>
                    <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Praesent elementum facilisis velit, at fermentum
                        ipsum ullamcorper eget. Duis et porta nunc. Pellentesque quis facilisis ipsum. Fusce iaculis vel est
                        quis
                        volutpat.</p>
                </article>

            </section>
        </main>

        <%@include file="jspf/Footer.jspf" %>
    </body>
</html>
