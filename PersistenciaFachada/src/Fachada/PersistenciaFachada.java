package Fachada;

import ObjetosNegocio.Comentario;
import ObjetosNegocio.Estado;
import ObjetosNegocio.Municipio;
import ObjetosNegocio.PostAnclado;
import ObjetosNegocio.PostComun;
import ObjetosNegocio.UsuarioAdministrador;
import ObjetosNegocio.UsuarioNormal;
import Repositorios.RepositorioComentario;
import Repositorios.RepositorioPost;
import Repositorios.RepositorioUsuario;
import Repositorios.RepositorioEstadoMunicipio;
import java.util.ArrayList;

/**
 *
 * @author Luis Osuna
 *
 */
public class PersistenciaFachada {

    RepositorioUsuario usuario;
    RepositorioPost post;
    RepositorioComentario comentario;
    RepositorioEstadoMunicipio estadoMunicipio;

    public PersistenciaFachada() {
        usuario = new RepositorioUsuario();
        post = new RepositorioPost();
        comentario = new RepositorioComentario();
        estadoMunicipio = new RepositorioEstadoMunicipio();
    }

    public void saveNormal(UsuarioNormal usuarioNormal) {
        usuario.saveNormal(usuarioNormal);
    }

    public void saveAdmin(UsuarioAdministrador usuarioAdministrador) {
        usuario.saveAdmin(usuarioAdministrador);
    }

    public UsuarioNormal findNormalByEmail(String email) {
        return usuario.findNormalByEmail(email);
    }
    
    public UsuarioAdministrador findAdminByEmail(String email) {
        return usuario.findAdminByEmail(email);
    }

    public void saveAnclado(PostAnclado postAnclado) {
        post.saveAnclado(postAnclado);
    }

    public void saveComun(PostComun postComun) {
        post.saveComun(postComun);
    }

    public void saveComentario(Comentario comentarios) {
        comentario.save(comentarios);
    }

    public boolean updateComun(PostComun postComun) {
        return post.updateComun(postComun);
    }

    public boolean updateAnclado(PostAnclado postAnclado) {
        return post.updateAnclado(postAnclado);
    }

    public boolean deleteAnclado(Integer id) {
        return post.deleteAnclado(id);
    }

    public boolean deleteComun(Integer id) {
        return post.deleteComun(id);
    }

    public Estado findEstadoByID(Integer id) {
        return estadoMunicipio.findEstadoByID(id);
    }

    public Municipio findMunicipioByID(Integer id) {
        return estadoMunicipio.findMunicipioByID(id);
    }

    public ArrayList<Municipio> findAllMunicipios() {
        return estadoMunicipio.findAllMunicipios();
    }

    public ArrayList<Estado> findAllEstados() {
        return estadoMunicipio.findAllEstados();
    }

    public void populateEstadoMunicipioDB() {
        estadoMunicipio.populateDB();
    }

    public void saveDemoUsuarioAdmins() {
        usuario.saveDemoUsuarioAdmins();
    }
}
