package Control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Factoria.PersistenciaFachadaFactoria;
import Fachada.PersistenciaFachada;
import ObjetosNegocio.Municipio;
import ObjetosNegocio.UsuarioNormal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.servlet.RequestDispatcher;

/**
 *
 * @author Juan Enrique Solis Perla, ID: 165920
 */
@WebServlet(name = "RegisterServlet", urlPatterns = {"/register"})
public class RegisterServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        arrayMunicipios(request, response);
    }

    private void arrayMunicipios(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        PersistenciaFachada persistenciaFachada = PersistenciaFachadaFactoria.getPersistenciaFachada();
        ArrayList<Municipio> municipios = persistenciaFachada.findAllMunicipios();

        request.setAttribute("municipios", municipios);

        RequestDispatcher dispatcher = request.getRequestDispatcher("RegisterForm.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // nombre=juan&email=juan%40gmail.com&password=123&telefono=123123&date=2020-07-30&gender=hombre

        String nombre = request.getParameter("nombre");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String telefono = request.getParameter("telefono");
        String date = request.getParameter("date");
        String gender = request.getParameter("gender");
        String municipioID = request.getParameter("municipio");
        
        Date parsed = new Date();
        try {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        parsed = format.parse(date);
        } catch (Exception e){
            e.printStackTrace();
        }
        
        PersistenciaFachada persistenciaFachada = PersistenciaFachadaFactoria.getPersistenciaFachada();
        Municipio municipio = persistenciaFachada.findMunicipioByID(Integer.parseInt(municipioID));
        UsuarioNormal usuarioNormal = new UsuarioNormal(nombre, email, password, telefono, null, gender, parsed, null, null, municipio);
        persistenciaFachada.saveNormal(usuarioNormal);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/login");
        dispatcher.forward(request, response);

    }
}
