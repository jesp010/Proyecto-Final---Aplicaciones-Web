
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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 *
 * @author Juan Enrique Solis Perla, ID: 165920
 */
@Entity
@DiscriminatorValue( value="PC" )
public class PostComun extends Post {

    @ManyToOne()
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;
    
    @OneToMany(mappedBy = "postComun", cascade = CascadeType.ALL, orphanRemoval=true)
    private transient List<Comentario> comentarios;
    
    public PostComun(){
        
    }

    public PostComun(Date fechaCreacion, String titulo, String contenido, Usuario usuario, List<Comentario> comentarios, Date fechaEdicion) {
        super(fechaCreacion, titulo, contenido, fechaEdicion);
        this.usuario = usuario;
        this.comentarios = comentarios;
    }
    
    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public List<Comentario> getComentarios() {
        return comentarios;
    }

    public void setComentarios(List<Comentario> comentarios) {
        this.comentarios = comentarios;
    }

//    @Override
//    public String toString() {
//        return "PostComun{" + "usuario=" + usuario + ", comentarios=" + comentarios + '}';
//    }
}
