<%-- 
    Document   : RegisterForm
    Created on : Jul 2, 2020, 7:12:10 PM
    Author     : juan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registro</title>
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
                <h2>Registro de Usuario</h2>
                <form class="register-form">
                    <input type="text" placeholder="nombre completo" required/>
                    <input type="email" placeholder="email" required/>
                    <input type="password" placeholder="contraseña" required/>
                    <input type="text" placeholder="telefono" required/>

                    <div class="box">
                        <select>
                            <option value="volvo">Selecciona Estado</option>
                            <option value="saab">Saab</option>
                            <option value="mercedes">Mercedes</option>
                            <option value="audi">Audi</option>
                        </select>
                    </div>
                    <div class="box">
                        <select>
                            <option value="volvo">Selecciona Ciudad</option>
                            <option value="saab">Saab</option>
                            <option value="mercedes">Mercedes</option>
                            <option value="audi">Audi</option>
                        </select>
                    </div>

                    <div class="form-date">
                        <br>
                        Fecha de nacimiento
                        <br>
                        <input type="date" name="date" id="date" required>
                    </div>
                    <div class="form-sex">
                        <label for="hombre">Hombre</label>
                        <input type="radio" id="male" name="gender" value="hombre" required>
                        <label for="mujer">Mujer</label>
                        <input type="radio" id="female" name="gender" value="mujer" required>
                    </div>
                    <div>

                    </div>
                    <button>create</button>
                    <p class="message">Ya estás registrado? <a href="LoginForm.jsp">Inicia Sesion</a></p>
                </form>
            </div>
        </div>
        
        <%@include file="jspf/Footer.jspf" %>
    </body>
</html>
