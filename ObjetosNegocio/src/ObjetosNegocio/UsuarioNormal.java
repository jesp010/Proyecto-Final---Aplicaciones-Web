package ObjetosNegocio;

import java.io.Serializable;
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
@DiscriminatorValue( value="UN" )
public class UsuarioNormal extends Usuario {

    @OneToMany(mappedBy = "usuarioNormal", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Comentario> comentarios;
    
    public UsuarioNormal() {
        super();
    }
    
    public UsuarioNormal(String nombreCompleto, String correo, String contrasenia, String telefono, String avatar, List<PostComun> postsComunes,List<Comentario> comentarios) {
        super(nombreCompleto, correo, contrasenia, telefono, avatar, postsComunes);
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
