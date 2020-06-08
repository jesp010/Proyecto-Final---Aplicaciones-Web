
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Fachada;

import ObjetosNegocio.Comentario;
import ObjetosNegocio.PostAnclado;
import ObjetosNegocio.PostComun;
import ObjetosNegocio.UsuarioAdministrador;
import ObjetosNegocio.UsuarioNormal;
import Repositorios.RepositorioComentario;
import Repositorios.RepositorioPost;
import Repositorios.RepositorioUsuario;

/**
 *
 * @author Luis Osuna
 */
public class BlogFachada {
    RepositorioUsuario usuario;
    RepositorioPost post;
    RepositorioComentario comentario;

    
    public BlogFachada(){
    usuario = new RepositorioUsuario();
    post = new RepositorioPost();
    comentario = new RepositorioComentario();
    }
    
    public void saveNormal(UsuarioNormal usuarioNormal){
        usuario.saveNormal(usuarioNormal);
    }
    
    public void saveAdmin(UsuarioAdministrador usuarioAdministrador){
        usuario.saveAdmin(usuarioAdministrador);
    }
    
    public void saveAnclado(PostAnclado postAnclado){
        post.saveAnclado(postAnclado);
    }
    
    public void saveComun(PostComun postComun){
        post.saveComun(postComun);
    }
    
    public void save(Comentario comentarios) {
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
    
    public boolean deleComun(Integer id) {
        return post.deleteComun(id);
    }
    
    
}
