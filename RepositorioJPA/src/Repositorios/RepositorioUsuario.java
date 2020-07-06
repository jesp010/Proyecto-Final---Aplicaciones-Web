package Repositorios;

import ObjetosNegocio.Usuario;
import ObjetosNegocio.UsuarioAdministrador;
import ObjetosNegocio.UsuarioNormal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaQuery;

/**
 *
 * @author Juan Enrique Solis Perla, ID: 165920
 */
public class RepositorioUsuario {

    private EntityManagerFactory factory = null;
    private EntityManager em = null;

    public RepositorioUsuario() {
        factory = Persistence.createEntityManagerFactory(RepositorioBase.PU);
        em = factory.createEntityManager();
    }

    public UsuarioNormal findNormalByID(Integer id) {
        em.getTransaction().begin();
        UsuarioNormal user = em.find(UsuarioNormal.class, id);
        em.getTransaction().commit();
        return user;
    }

    public UsuarioAdministrador findAdminByID(Integer id) {
        // get length of id (Can't be > 11
        em.getTransaction().begin();
        UsuarioAdministrador user = em.find(UsuarioAdministrador.class, id);
        em.getTransaction().commit();
        return user;
    }

    public UsuarioNormal findNormalByAvatar(String avatar) {
        ArrayList<UsuarioNormal> users = findNormalAll();
        for (UsuarioNormal u : users) {
            if (u.getAvatar().equals(avatar)) {
                return u;
            }
        }
        return null;
    }

    public UsuarioAdministrador findAdminByAvatar(String avatar) {
        ArrayList<UsuarioAdministrador> users = findAdminAll();
        for (UsuarioAdministrador u : users) {
            if (u.getAvatar().equals(avatar)) {
                return u;
            }
        }
        return null;
    }

    public UsuarioAdministrador findAdminByEmail(String email) {
        ArrayList<UsuarioAdministrador> users = findAdminAll();
        for (UsuarioAdministrador u : users) {
            if (u.getCorreo().equals(email)) {
                return u;
            }
        }
        return null;
    }

    public UsuarioNormal findNormalByEmail(String email) {
        ArrayList<UsuarioNormal> users = findNormalAll();
        for (UsuarioNormal u : users) {
            if (u.getCorreo().equals(email)) {
                return u;
            }
        }
        return null;
    }

    public ArrayList<UsuarioNormal> findNormalAll(UsuarioNormal user) {
        ArrayList<UsuarioNormal> users = findNormalAll();
        if (users.size() > 0) {
            for (int i = 0; i < users.size(); i++) {
                if (users.get(i).getId() == user.getId()) {
                    users.remove(i);
                }
            }
        }
        return users;
    }

    public ArrayList<UsuarioAdministrador> findAdminlAll(UsuarioAdministrador user) {
        ArrayList<UsuarioAdministrador> users = findAdminAll();
        if (users.size() > 0) {
            for (int i = 0; i < users.size(); i++) {
                if (users.get(i).getId() == user.getId()) {
                    users.remove(i);
                }
            }
        }
        return users;
    }

    public ArrayList<UsuarioNormal> findNormalAll() {
        em.getTransaction().begin();
        //Creates the query constructor
        CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
        //Builds the object
        cq.select(cq.from(UsuarioNormal.class));
        //Creates the query ready to execute
        Query q = em.createQuery(cq);
        //Execute the query and stores the result in an ArrayList
        ArrayList<UsuarioNormal> users = new ArrayList<>(q.getResultList());
        //Transaction ends
        em.getTransaction().commit();

        return users;
    }

    public ArrayList<UsuarioAdministrador> findAdminAll() {
        em.getTransaction().begin();
        //Creates the query constructor
        CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
        //Builds the object
        cq.select(cq.from(UsuarioAdministrador.class));
        //Creates the query ready to execute
        Query q = em.createQuery(cq);
        //Execute the query and stores the result in an ArrayList
        ArrayList<UsuarioAdministrador> users = new ArrayList<>(q.getResultList());
        //Transaction ends
        em.getTransaction().commit();
        //If suppliers isn't null it is returned otherwise the method returns null

        return users;
    }

    public void saveNormal(UsuarioNormal user) {
        em.getTransaction().begin();
        em.persist(user);
        em.getTransaction().commit();
    }

    public void saveAdmin(UsuarioAdministrador user) {
        em.getTransaction().begin();
        em.persist(user);
        em.getTransaction().commit();
    }

    public boolean updateUsuarioNormal(UsuarioNormal user) {
        if (user != null) {
            em.getTransaction().begin();

            UsuarioNormal user_tmp = em.find(UsuarioNormal.class, user.getId());
            if (user_tmp != null) {
                user_tmp.setAvatar(user.getAvatar());
                user_tmp.setContrasenia(user.getContrasenia());
                user_tmp.setCorreo(user.getCorreo());
                user_tmp.setNombreCompleto(user.getNombreCompleto());
                user_tmp.setTelefono(user.getTelefono());
                user_tmp.setPostsComunes(user.getPostsComunes());
                user_tmp.setComentarios(user.getComentarios());

                try {
                    em.persist(user_tmp);
                    em.getTransaction().commit();
                } catch (javax.persistence.RollbackException e) {
                    e.printStackTrace();
                    return false;
                } catch (Exception ex) {
                    ex.printStackTrace();
                    return false;
                }
                return true;
            } else {
                em.getTransaction().commit();
            }
        }
        return false;
    }

    public boolean updateUsuarioAdmin(UsuarioAdministrador user) {
        if (user != null) {
            em.getTransaction().begin();

            UsuarioAdministrador user_tmp = em.find(UsuarioAdministrador.class, user.getId());
            if (user_tmp != null) {
                user_tmp.setAvatar(user.getAvatar());
                user_tmp.setContrasenia(user.getContrasenia());
                user_tmp.setCorreo(user.getCorreo());
                user_tmp.setNombreCompleto(user.getNombreCompleto());
                user_tmp.setTelefono(user.getTelefono());
                user_tmp.setPostsComunes(user.getPostsComunes());
                user_tmp.setPostsAnclados(user.getPostsAnclados());

                try {
                    em.persist(user_tmp);
                    em.getTransaction().commit();
                } catch (javax.persistence.RollbackException e) {
                    e.printStackTrace();
                    return false;
                } catch (Exception ex) {
                    ex.printStackTrace();
                    return false;
                }
                return true;
            } else {
                em.getTransaction().commit();
            }
        }
        return false;
    }

    public boolean deleteUsuarioAdministrador(Integer id) {
        em.getTransaction().begin();
        UsuarioAdministrador user = em.find(UsuarioAdministrador.class, id);

        if (user != null) {
            try {
                em.remove(user);
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

    public boolean deleteUsuarioNormal(Integer id) {
        em.getTransaction().begin();
        UsuarioNormal user = em.find(UsuarioNormal.class, id);

        if (user != null) {
            try {
                em.remove(user);
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

    public void saveDemoUsuarioAdmins() {
        RepositorioEstadoMunicipio rem = new RepositorioEstadoMunicipio();
        rem.populateDB();
        UsuarioAdministrador ua1 = new UsuarioAdministrador("Juan Enrique Solis Perla", "juan@gmail.com", "passwordXD", "6442415263", null, "male", new Date(), null, null, rem.findAllMunicipios().get(0));
        UsuarioAdministrador ua2 = new UsuarioAdministrador("Jose Perez Lopez", "jose@gmail.com", "passwordXD", "6442158946", null, "male", new Date(), null, null, rem.findAllMunicipios().get(1));

        saveAdmin(ua1);
        saveAdmin(ua2);
    }
}
