package Factoria;

import ObjetosNegocio.Comentario;
import ObjetosNegocio.Post;
import ObjetosNegocio.PostAnclado;
import ObjetosNegocio.PostComun;
import ObjetosNegocio.Usuario;
import ObjetosNegocio.UsuarioAdministrador;
import ObjetosNegocio.UsuarioNormal;


public class FactoriaBlog {
    public static Usuario getUsuario(String tipo){
        if(tipo.equals("Normal")){
            return new UsuarioNormal();
        }else if(tipo.equals("Administrador")){
            return new UsuarioAdministrador();
        }
        return null;
    }
    
    public static Post getPost(String tipo){
        if(tipo.equals("Comun")){
            return new PostComun();
        }else if(tipo.equals("Anclado")){
            return new PostAnclado();
        }
        return null;
    }
    public static Comentario getComentario(String tipo){
        if(tipo.equals("Comentario")){
            return new Comentario();
        }
        return null;
    }
}
