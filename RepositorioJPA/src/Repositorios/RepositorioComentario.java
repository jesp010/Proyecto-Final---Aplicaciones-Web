package Repositorios;

import ObjetosNegocio.Comentario;
import java.util.ArrayList;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;

/**
 *
 * @author Juan Enrique Solis Perla, ID: 165920
 */
public class RepositorioComentario {

    private EntityManagerFactory factory = null;
    private EntityManager em = null;

    public RepositorioComentario() {
        factory = Persistence.createEntityManagerFactory(RepositorioBase.PU);
        em = factory.createEntityManager();
    }

    public Comentario findByID(Integer id) {
        em.getTransaction().begin();
        Comentario message = em.find(Comentario.class, id);
        em.getTransaction().commit();
        return message;
    }
    
    public ArrayList<Comentario> findAll() {
        em.getTransaction().begin();
        //Creates the query constructor
        CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
        //Builds the object
        cq.select(cq.from(Comentario.class));
        //Creates the query ready to execute
        Query q = em.createQuery(cq);
        //Execute the query and stores the result in an ArrayList
        ArrayList<Comentario> comentarios = new ArrayList<>(q.getResultList());
        //Transaction ends
        em.getTransaction().commit();
        if (comentarios != null) {
            return comentarios;
        }
        return null;
    }
    
    public ArrayList<Comentario> findAllByUsuarioID(Integer userID) {
        ArrayList<Comentario> allComentarios = findAll();
        ArrayList<Comentario> comentarios = new ArrayList<>();
        
        //Check if ArrayList isn't empty
        if (allComentarios.size() > 0) {
            for (Comentario m : allComentarios) {
                if (userID == m.getUsuarioNormal().getId()) {
                    comentarios.add(m);
                }
            }
        }

        return comentarios;
    }
    
    public ArrayList<Comentario> findAllPostComentarios(Integer postID) {
        em.getTransaction().begin();
        //Creates the query constructor
        CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
        //Builds the object
        cq.select(cq.from(Comentario.class));
        //Creates the query ready to execute
        Query q = em.createQuery(cq);
        //Execute the query and stores the result in an ArrayList
        ArrayList<Comentario> allComentarios = new ArrayList<>(q.getResultList());

        ArrayList<Comentario> comentarios = new ArrayList<>();
        for (Comentario m : allComentarios) {
            if (postID == m.getPostComun().getId()) {
                comentarios.add(m);
            }
        }
        //Transaction ends
        em.getTransaction().commit();

        return comentarios;
    }
    
    public void save(Comentario comentario) {
        em.getTransaction().begin();
        em.persist(comentario);
        em.getTransaction().commit();
    }
    
    public boolean update(Comentario comentario) {
        if (comentario != null) {
            em.getTransaction().begin();

            Comentario comentario_tmp = em.find(Comentario.class, comentario.getId());
            if (comentario_tmp != null) {
                comentario_tmp.setComentarioPadre(comentario.getComentarioPadre());
                comentario_tmp.setContenido(comentario.getContenido());
                comentario_tmp.setPostComun(comentario.getPostComun());
                comentario_tmp.setUsuarioNormal(comentario.getUsuarioNormal());
                comentario_tmp.setSubComentarios(comentario.getSubComentarios());
                comentario_tmp.setFechaHora(comentario.getFechaHora());
                em.persist(comentario_tmp);
                em.getTransaction().commit();
                return true;
            } else {
                em.getTransaction().commit();
            }
        }
        return false;
    }
    
    public boolean delete(Integer id) {
        em.getTransaction().begin();
        Comentario comentario = em.find(Comentario.class, id);

        if (comentario != null) {
            try {
                em.remove(comentario);
                em.getTransaction().commit();

            } catch (javax.persistence.RollbackException ex) {
                ex.printStackTrace();
                return false;
            } catch (Exception ex) {
                ex.printStackTrace();
                return false;
            }
            return true;
        } else {
            em.getTransaction().commit();
            return false;
        }
    }
}
