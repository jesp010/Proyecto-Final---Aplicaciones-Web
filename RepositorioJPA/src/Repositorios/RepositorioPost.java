package Repositorios;

import ObjetosNegocio.PostComun;
import ObjetosNegocio.PostAnclado;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;

/**
 *
 * @author Juan Enrique Solis Perla, ID: 165920
 */
public class RepositorioPost {

    private EntityManagerFactory factory = null;
    private EntityManager em = null;

    public RepositorioPost() {
        factory = Persistence.createEntityManagerFactory(RepositorioBase.PU);
        em = factory.createEntityManager();
    }
    
    public PostComun findComunByID(Integer id) {
        em.getTransaction().begin();
        PostComun user = em.find(PostComun.class, id);
        em.getTransaction().commit();
        return user;
    }
    
    public PostAnclado findAncladoByID(Integer id) {
        em.getTransaction().begin();
        PostAnclado user = em.find(PostAnclado.class, id);
        em.getTransaction().commit();
        return user;
    }
    
    public ArrayList<PostComun> findAllComun() {
        em.getTransaction().begin();
        //Creates the query constructor
        CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
        //Builds the object
        cq.select(cq.from(PostComun.class));
        //Creates the query ready to execute
        Query q = em.createQuery(cq);
        //Execute the query and stores the result in an ArrayList
        ArrayList<PostComun> postsComunes = new ArrayList<>(q.getResultList());
        //Transaction ends
        em.getTransaction().commit();
        //If isn't null it is returned otherwise the method returns null
        if (postsComunes != null) {
            return postsComunes;
        }
        return null;
    }
    
    public ArrayList<PostAnclado> findAllAnclado() {
        em.getTransaction().begin();
        //Creates the query constructor
        CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
        //Builds the object
        cq.select(cq.from(PostComun.class));
        //Creates the query ready to execute
        Query q = em.createQuery(cq);
        //Execute the query and stores the result in an ArrayList
        ArrayList<PostAnclado> postsAnclados = new ArrayList<>(q.getResultList());
        //Transaction ends
        em.getTransaction().commit();
        //If isn't null it is returned otherwise the method returns null
        if (postsAnclados != null) {
            return postsAnclados;
        }
        return null;
    }
    
    public ArrayList<PostComun> findAllComunByUserID(Integer userID) {
        ArrayList<PostComun> allPosts = findAllComun();
        ArrayList<PostComun> posts = new ArrayList<>();
        
        //Check if ArrayList isn't empty
        if (allPosts.size() > 0) {
            for (PostComun r : allPosts) {
                if (userID == r.getUsuario().getId()) {
                    posts.add(r);
                }
            }
        }

        return posts;
    }
    
    public ArrayList<PostAnclado> findAllAncladoByAdminID(Integer adminID) {
        ArrayList<PostAnclado> allPosts = findAllAnclado();
        ArrayList<PostAnclado> posts = new ArrayList<>();
        
        //Check if ArrayList isn't empty
        if (allPosts.size() > 0) {
            for (PostAnclado r : allPosts) {
                if (adminID == r.getUsuarioAdministrador().getId()) {
                    posts.add(r);
                }
            }
        }

        return posts;
    }
    
    public void saveComun(PostComun postComun) {
        em.getTransaction().begin();
        em.persist(postComun);
        em.getTransaction().commit();
    }
    
    public void saveAnclado(PostAnclado postAnclado) {
        em.getTransaction().begin();
        em.persist(postAnclado);
        em.getTransaction().commit();
    }
    
    public boolean updateComun(PostComun postComun) {
        if (postComun != null) {
            em.getTransaction().begin();

            PostComun post_tmp = em.find(PostComun.class, postComun.getId());
            if (post_tmp != null) {
                post_tmp.setTitulo(postComun.getTitulo());
                post_tmp.setContenido(postComun.getContenido());
                post_tmp.setComentarios(postComun.getComentarios());
                post_tmp.setFechaEdicion(new Date());
                em.persist(post_tmp);
                em.getTransaction().commit();
                return true;
            } else {
                em.getTransaction().commit();
            }
        }
        return false;
    }
    
    public boolean updateAnclado(PostAnclado postAnclado) {
        if (postAnclado != null) {
            em.getTransaction().begin();

            PostComun post_tmp = em.find(PostComun.class, postAnclado.getId());
            if (post_tmp != null) {
                post_tmp.setTitulo(postAnclado.getTitulo());
                post_tmp.setContenido(postAnclado.getContenido());
                post_tmp.setFechaEdicion(new Date());
                em.persist(post_tmp);
                em.getTransaction().commit();
                return true;
            } else {
                em.getTransaction().commit();
            }
        }
        return false;
    }
    
    public boolean deleteComun(Integer id) {
        em.getTransaction().begin();
        PostComun postComun = em.find(PostComun.class, id);

        if (postComun != null) {
            try {
                em.remove(postComun);
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
    
    public boolean deleteAnclado(Integer id) {
        em.getTransaction().begin();
        PostAnclado postAnclado = em.find(PostAnclado.class, id);

        if (postAnclado != null) {
            try {
                em.remove(postAnclado);
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
