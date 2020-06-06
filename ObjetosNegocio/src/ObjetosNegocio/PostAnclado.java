package ObjetosNegocio;

import java.io.Serializable;
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
    @JoinColumn(name = "usuario_admin_id", nullable = false)
    private UsuarioAdministrador usuarioAdministrador;
    
    public PostAnclado() {
        super();
    }
    
    public PostAnclado()
}
