package ObjetosNegocio;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 *
 * @author Juan Enrique Solis Perla, ID: 165920
 */
@Entity
@DiscriminatorValue( value="PA" )
public class PostAnclado extends Post {

    @ManyToOne()
    @JoinColumn(name = "usuario_id", nullable = false)
    private UsuarioAdministrador usuarioAdministrador;
    
    public PostAnclado() {
        super();
    }
    
    public PostAnclado(Date fechaCreacion, String titulo, String contenido, UsuarioAdministrador usuarioAdministrador, Date fechaEdicion){
        super(fechaCreacion, titulo, contenido, fechaEdicion);
        this.usuarioAdministrador = usuarioAdministrador;
    }

    public UsuarioAdministrador getUsuarioAdministrador() {
        return usuarioAdministrador;
    }

    public void setUsuarioAdministrador(UsuarioAdministrador usuarioAdministrador) {
        this.usuarioAdministrador = usuarioAdministrador;
    }

//    @Override
//    public String toString() {
//        return super.toString() + ", PostAnclado{" + "usuarioAdministrador=" + usuarioAdministrador + '}';
//    }
}
