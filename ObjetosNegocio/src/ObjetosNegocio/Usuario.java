package ObjetosNegocio;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import javax.persistence.Persistence;
import javax.persistence.Table;

/**
 *
 * @author Juan Enrique Solis Perla, ID: 165920
 */
@Entity
@Table(name = "usuarios")
@Inheritance( strategy = InheritanceType.SINGLE_TABLE )
@DiscriminatorColumn( name="type" )
public class Usuario implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nombre_completo", nullable = false)
    private String nombreCompleto;
    
    @Column(name = "correo", nullable = false)
    private String correo;
    
    @Column(name = "contrasenia", nullable = false)
    private String contrasenia;
    
    @Column(name = "telefono", nullable = false)
    private String telefono;
    
    @Column(name = "avatar", nullable = false)
    private String avatar;
    
    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<PostComun> postsComunes;

    public Usuario() {
    }

    public Usuario(String nombreCompleto, String correo, String contrasenia, String telefono, String avatar, List<PostComun> postsComunes) {
        this.nombreCompleto = nombreCompleto;
        this.correo = correo;
        this.contrasenia = contrasenia;
        this.telefono = telefono;
        this.avatar = avatar;
        this.postsComunes = postsComunes;
    }
    
    public Integer getId() {
        return id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public List<PostComun> getPostsComunes() {
        return postsComunes;
    }

    public void setPostsComunes(List<PostComun> postsComunes) {
        this.postsComunes = postsComunes;
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
        if (!(object instanceof Usuario)) {
            return false;
        }
        Usuario other = (Usuario) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

//    @Override
//    public String toString() {
//        return "Usuario{" + "id=" + id + ", nombreCompleto=" + nombreCompleto + ", correo=" + correo + ", contrasenia=" + contrasenia + ", telefono=" + telefono + ", avatar=" + avatar + ", postsComunes=" + postsComunes + '}';
//    }
}
