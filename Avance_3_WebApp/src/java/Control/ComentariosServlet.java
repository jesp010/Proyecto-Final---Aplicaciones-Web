package Control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Factoria.PersistenciaFachadaFactoria;
import Fachada.PersistenciaFachada;
import ObjetosNegocio.Comentario;
import ObjetosNegocio.PostAnclado;
import ObjetosNegocio.PostComun;
import ObjetosNegocio.UsuarioAdministrador;
import ObjetosNegocio.UsuarioNormal;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.PrintWriter;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Juan Enrique Solis Perla, ID: 165920
 */
@WebServlet(name = "ComentariosServlet", urlPatterns = {"/comentarios"})
public class ComentariosServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("application/json");
        PersistenciaFachada persistenciaFachada = PersistenciaFachadaFactoria.getPersistenciaFachada();
        int postId = Integer.parseInt(request.getParameter("postid"));

        Gson gson = new GsonBuilder().excludeFieldsWithModifiers(Modifier.TRANSIENT).create();
        ArrayList<Comentario> comentarios = persistenciaFachada.findAllPostComentarios(postId);
        String jsonComentarios = gson.toJson(comentarios);

        try (PrintWriter out = response.getWriter()) {
            out.write(jsonComentarios);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String comentario = request.getParameter("comentario");
        int postid = Integer.parseInt(request.getParameter("postid"));
        String tipoUsuario = request.getParameter("usertype");
        String usuarioEmail = request.getParameter("usuarioemail");

        PersistenciaFachada persistenciaFachada = PersistenciaFachadaFactoria.getPersistenciaFachada();
        PostComun pc = persistenciaFachada.findComunByID(postid);
        UsuarioNormal un = persistenciaFachada.findNormalByEmail(usuarioEmail);
        persistenciaFachada.saveComentario(new Comentario(new Date(), comentario, pc, un, null, null));
    }
}
