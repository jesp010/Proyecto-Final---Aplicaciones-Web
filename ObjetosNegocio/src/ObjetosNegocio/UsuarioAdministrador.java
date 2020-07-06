/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ObjetosNegocio;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 *
 * @author Juan Enrique Solis Perla, ID: 165920
 */
@Entity
@DiscriminatorValue( value="UA" )
public class UsuarioAdministrador extends Usuario {
    
    @OneToMany(mappedBy = "usuarioAdministrador", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<PostAnclado> postsAnclados;
    
    public UsuarioAdministrador(){
        super();
    }

    public UsuarioAdministrador(String nombreCompleto, String correo, String contrasenia, String telefono, String avatar, String genero, Date fechaNacimiento, List<PostComun> postsComunes,List<PostAnclado> postsAnclados, Municipio municipio){
        super(nombreCompleto, correo, contrasenia, telefono, avatar, genero, fechaNacimiento, postsComunes, municipio);
        this.postsAnclados = postsAnclados;
    }

    public List<PostAnclado> getPostsAnclados() {
        return postsAnclados;
    }

    public void setPostsAnclados(List<PostAnclado> postsAnclados) {
        this.postsAnclados = postsAnclados;
    }

//    @Override
//    public String toString() {
//        return super.toString() + ", UsuarioAdministrador{" + "postsAnclados=" + postsAnclados + '}';
//    }
}
