package Control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Factoria.PersistenciaFachadaFactoria;
import Fachada.PersistenciaFachada;
import ObjetosNegocio.UsuarioAdministrador;
import javax.servlet.RequestDispatcher;
import ObjetosNegocio.UsuarioNormal;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Juan Enrique Solis Perla, ID: 165920
 */
@WebServlet(name = "LoginServlet", urlPatterns = {"/login"})
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        RequestDispatcher dispatcher = request.getRequestDispatcher("LoginForm.jsp");
        dispatcher.forward(request, response);
    }

    private void login(HttpServletRequest request, HttpServletResponse response, String email, String password)
            throws ServletException, IOException {
        PersistenciaFachada persistenciaFachada = PersistenciaFachadaFactoria.getPersistenciaFachada();

        UsuarioNormal usuarioNormal = persistenciaFachada.findNormalByEmail(email);
        if (usuarioNormal != null) {
            if (usuarioNormal.getClass().getName() == "ObjetosNegocio.UsuarioNormal") {
                if (usuarioNormal.getContrasenia().equals(password)) {
                    HttpSession session = request.getSession(true);
                    session.setAttribute("currentSessionUser", usuarioNormal);
                    response.sendRedirect("home"); //logged-in page   
                    return;
                }
            }
        }

        UsuarioAdministrador usuarioAdministrador = persistenciaFachada.findAdminByEmail(email);
        if (usuarioAdministrador != null) {
            if (usuarioAdministrador.getClass().getName() == "ObjetosNegocio.UsuarioAdministrador") {
                if (usuarioAdministrador.getContrasenia().equals(password)) {
                    HttpSession session = request.getSession(true);
                    session.setAttribute("currentSessionUser", usuarioAdministrador);
                    response.sendRedirect("admin"); //logged-in admin page  
                    return;
                }
            }
        }

        request.setAttribute("authError", true);
        RequestDispatcher dispatcher = request.getRequestDispatcher("LoginForm.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String email = request.getParameter("email");
        String password = request.getParameter("password");
        login(request, response, email, password);
    }
}
