package ObjetosNegocio;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;
import java.util.logging.Logger;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Juan Enrique Solis Perla, ID: 165920
 */
@Entity
@Table(name = "comentarios")
public class Comentario implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "fecha_hora", nullable = false)
    private Date fechaHora;

    @Column(name = "contenido", nullable = false)
    private String contenido;
    
    @ManyToOne()
    @JoinColumn(name = "post_id", nullable = false)
    private PostComun postComun;

    @ManyToOne()
    @JoinColumn(name = "usuario_id", nullable = false)
    private UsuarioNormal usuarioNormal;
    
    @OneToMany(mappedBy="comentarioPadre", cascade = CascadeType.ALL, orphanRemoval=true)
    private transient Set<Comentario> subComentarios;
    
    @ManyToOne
    private transient Comentario comentarioPadre;

    public Comentario() {

    }
    
    public Comentario(Date fechaHora, String contenido, PostComun postComun, UsuarioNormal usuarioNormal, Set<Comentario> subComentarios, Comentario comentarioPadre) {
        this.fechaHora = fechaHora;
        this.contenido = contenido;
        this.postComun = postComun;
        this.usuarioNormal = usuarioNormal;
        this.subComentarios = subComentarios;
        this.comentarioPadre = comentarioPadre;
    }
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(Date fechaHora) {
        this.fechaHora = fechaHora;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public UsuarioNormal getUsuarioNormal() {
        return usuarioNormal;
    }

    public void setUsuarioNormal(UsuarioNormal usuarioNormal) {
        this.usuarioNormal = usuarioNormal;
    }
    
    public Set<Comentario> getSubComentarios() {
        return subComentarios;
    }

    public void setSubComentarios(Set<Comentario> subComentarios) {
        this.subComentarios = subComentarios;
    }

    public Comentario getComentarioPadre() {
        return comentarioPadre;
    }

    public void setComentarioPadre(Comentario comentarioPadre) {
        this.comentarioPadre = comentarioPadre;
    }

    public PostComun getPostComun() {
        return postComun;
    }

    public void setPostComun(PostComun postComun) {
        this.postComun = postComun;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Comentario)) {
            return false;
        }
        Comentario other = (Comentario) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

//    @Override
//    public String toString() {
//        return "Comentario{" + "id=" + id + ", fechaHora=" + fechaHora + ", contenido=" + contenido + ", postComun=" + postComun + ", usuarioNormal=" + usuarioNormal + '}';
//    }
    
}
