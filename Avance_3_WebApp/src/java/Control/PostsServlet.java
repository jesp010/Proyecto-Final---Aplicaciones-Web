package Control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Factoria.PersistenciaFachadaFactoria;
import Fachada.PersistenciaFachada;
import ObjetosNegocio.PostAnclado;
import ObjetosNegocio.PostComun;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.PrintWriter;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Juan Enrique Solis Perla, ID: 165920
 */
@WebServlet(name = "PostsServlet", urlPatterns = {"/posts"})
public class PostsServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("application/json");
        PersistenciaFachada persistenciaFachada = PersistenciaFachadaFactoria.getPersistenciaFachada();
        HttpSession session = request.getSession();
        String action = request.getParameter("action");
        
        Gson gson = new GsonBuilder().excludeFieldsWithModifiers(Modifier.TRANSIENT).create();

            if (action.equalsIgnoreCase("anclados")) {
                ArrayList<PostAnclado> postsAnclados = persistenciaFachada.findAllPostAnclado();
                String jsonPostsAnclados = gson.toJson(postsAnclados);
                
                try (PrintWriter out = response.getWriter()) {
                    out.write(jsonPostsAnclados);
                }
            } else if (action.equalsIgnoreCase("comunes")){
                ArrayList<PostComun> postsComunes = persistenciaFachada.findAllPostComun();
                String jsonPostsComunes = gson.toJson(postsComunes);

                try (PrintWriter out = response.getWriter()) {
                    out.write(jsonPostsComunes);
                }
            }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("doPost");
    }
}
