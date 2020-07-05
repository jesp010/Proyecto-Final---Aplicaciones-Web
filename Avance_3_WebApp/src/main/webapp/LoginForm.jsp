<%-- 
    Document   : LoginForm
    Created on : Jul 2, 2020, 7:09:14 PM
    Author     : Juan Enrique Solis Perla, ID: 165920
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
        <link rel="stylesheet" href="css/register-login-style.css">

        <!-- Google Fonts-->
        <link href="https://fonts.googleapis.com/css2?family=Merriweather+Sans:ital,wght@0,300;0,400;0,700;0,800;1,300;1,400;1,700;1,800&display=swap" rel="stylesheet">
        <link href="https://fonts.googleapis.com/css2?family=Martel+Sans:wght@200&display=swap" rel="stylesheet">
        <link href="https://fonts.googleapis.com/css2?family=Satisfy&display=swap" rel="stylesheet">


    </head>
    <body>
        <%@include file="jspf/Header.jspf" %>
        
        <div class="login-page">
            <div class="form">
                <h2>Inicia Sesion</h2>
                <form class="login-form">
                    <input type="text" placeholder="email"/>
                    <input type="password" placeholder="contraseña"/>
                    <button>login</button>
                    <p class="message">No estás registrado?<a href="RegisterForm.jsp">Crea una cuenta!</a></p>
                </form>
            </div>
        </div>
        
        <%@include file="jspf/Footer.jspf" %>
    </body>
</html>
