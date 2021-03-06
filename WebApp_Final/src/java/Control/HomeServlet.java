package Control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Factoria.PersistenciaFachadaFactoria;
import Fachada.PersistenciaFachada;
import com.google.gson.Gson;
import javax.servlet.RequestDispatcher;

/**
 *
 * @author Juan Enrique Solis Perla, ID: 165920
 */
@WebServlet(name = "HomeServlet", urlPatterns = {"/home"})
public class HomeServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        processRequest(request, response);
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        PersistenciaFachada persistenciaFachada = PersistenciaFachadaFactoria.getPersistenciaFachada();
        request.setAttribute("postsComunes", persistenciaFachada.findAllPostComun());
        request.setAttribute("postsAnclados", persistenciaFachada.findAllPostAnclado());
        
        RequestDispatcher dispatcher = request.getRequestDispatcher("Home.jsp");
        dispatcher.forward(request, response);
//        response.sendRedirect(request.getContextPath() + "/home");

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
}
