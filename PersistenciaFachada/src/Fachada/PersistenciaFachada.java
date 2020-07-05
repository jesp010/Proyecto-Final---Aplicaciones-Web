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

    //obtiene los datos de los dao
    public PersistenciaFachada() {
        usuario = new RepositorioUsuario();
        post = new RepositorioPost();
        comentario = new RepositorioComentario();
        estadoMunicipio = new RepositorioEstadoMunicipio();
    }

    //obtiene los datos de un usuario normal
    public void saveNormal(UsuarioNormal usuarioNormal) {
        usuario.saveNormal(usuarioNormal);
    }

    //obtiene los datos de un usuario Administrador
    public void saveAdmin(UsuarioAdministrador usuarioAdministrador) {
        usuario.saveAdmin(usuarioAdministrador);
    }

    //obtiene los post anclado que solo podra obtener el administrador
    public void saveAnclado(PostAnclado postAnclado) {
        post.saveAnclado(postAnclado);
    }

    //obtiene los post comun que solo un usuario podra hacer
    public void saveComun(PostComun postComun) {
        post.saveComun(postComun);
    }

    //obtiene los comentarios de un usuario normal
    public void saveComentario(Comentario comentarios) {
        comentario.save(comentarios);
    }

    // los update son las actualizaciones de los post o mensajes que haran los
    // los diferentes usuarios ya se administrador o normal
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
    
    public Municipio findMunicipioByID(Integer id){
        return estadoMunicipio.findMunicipioByID(id);
    }
    
    public ArrayList<Municipio> findAllMunicipios() {
        return estadoMunicipio.findAllMunicipios();
    }
    
    public ArrayList<Estado> findAllEstados() {
        return estadoMunicipio.findAllEstados();
    }
    
    public void populateEstadoMunicipioDB(){
        estadoMunicipio.populateDB();
    }
}
