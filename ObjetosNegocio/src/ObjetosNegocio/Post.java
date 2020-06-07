package ObjetosNegocio;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Juan Enrique Solis Perla, ID: 165920
 */
@Entity
@Table(name = "posts")
@Inheritance( strategy = InheritanceType.SINGLE_TABLE )
@DiscriminatorColumn( name="type" )
public class Post implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "fecha_creacion", nullable = false)
    private Date fechaCreacion;
    
    @Column(name = "titulo", nullable = false)
    private String titulo;
    
    @Column(name = "contenido", nullable = false)
    private String contenido;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "fecha_edicion", nullable = true)
    private Date fechaEdicion;
    
    public Post() {
    }

    public Post(Date fechaCreacion, String titulo, String contenido, Date fechaEdicion) {
        this.fechaCreacion = fechaCreacion;
        this.titulo = titulo;
        this.contenido = contenido;
        this.fechaEdicion = this.fechaEdicion;
    }
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
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
        if (!(object instanceof Post)) {
            return false;
        }
        Post other = (Post) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

//    @Override
//    public String toString() {
//        return "Post{" + "id=" + id + ", fechaCreacion=" + fechaCreacion + ", titulo=" + titulo + ", contenido=" + contenido + '}';
//    }
}
