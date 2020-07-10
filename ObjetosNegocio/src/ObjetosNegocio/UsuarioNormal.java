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
 * @author Luis Carlos Osuna Cuen, ID:165650
 */
@Entity
@DiscriminatorValue( value="UN" )
public class UsuarioNormal extends Usuario {

    @OneToMany(mappedBy = "usuarioNormal", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private transient List<Comentario> comentarios;
    
    public UsuarioNormal() {
        super();
    }
    
    public UsuarioNormal(String nombreCompleto, String correo, String contrasenia, String telefono, String avatar, String genero, Date fechaNacimiento, List<PostComun> postsComunes,List<Comentario> comentarios, Municipio municipio) {
        super(nombreCompleto, correo, contrasenia, telefono, avatar, genero, fechaNacimiento, postsComunes, municipio);
        this.comentarios = comentarios;
    }

    public List<Comentario> getComentarios() {
        return comentarios;
    }

    public void setComentarios(List<Comentario> comentarios) {
        this.comentarios = comentarios;
    }

//    @Override
//    public String toString() {
//        return "UsuarioNormal{" + "comentarios=" + comentarios + '}';
//    }
}
