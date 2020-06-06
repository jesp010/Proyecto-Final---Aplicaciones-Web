package ObjetosNegocio;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author Juan Enrique Solis Perla, ID: 165920
 */
@Entity
public class UsuarioNormal extends Usuario {

    public UsuarioNormal() {
        super();
    }
}
