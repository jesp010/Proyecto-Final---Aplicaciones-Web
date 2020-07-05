package Repositorios;

import ObjetosNegocio.Estado;
import ObjetosNegocio.Municipio;
import ObjetosNegocio.Usuario;
import ObjetosNegocio.UsuarioNormal;
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
public class RepositorioEstadoMunicipio {

    private EntityManagerFactory factory = null;
    private EntityManager em = null;

    public RepositorioEstadoMunicipio() {
        factory = Persistence.createEntityManagerFactory(RepositorioBase.PU);
        em = factory.createEntityManager();
    }

    public Municipio findMunicipioByID(Integer id) {
        em.getTransaction().begin();
        Municipio municipio = em.find(Municipio.class, id);
        em.getTransaction().commit();
        return municipio;
    }
    
    public Estado findEstadoByID(Integer id) {
        em.getTransaction().begin();
        Estado estado = em.find(Estado.class, id);
        em.getTransaction().commit();
        return estado;
    }

    public ArrayList<Municipio> findAllMunicipios() {
        em.getTransaction().begin();
        //Creates the query constructor
        CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
        //Builds the object
        cq.select(cq.from(Municipio.class));
        //Creates the query ready to execute
        Query q = em.createQuery(cq);
        //Execute the query and stores the result in an ArrayList
        ArrayList<Municipio> municipios = new ArrayList<>(q.getResultList());
        //Transaction ends
        em.getTransaction().commit();
        //If suppliers isn't null it is returned otherwise the method returns null
        if (municipios != null) {
            return municipios;
        }
        return null;
    }

    public ArrayList<Estado> findAllEstados() {
        em.getTransaction().begin();
        //Creates the query constructor
        CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
        //Builds the object
        cq.select(cq.from(Estado.class));
        //Creates the query ready to execute
        Query q = em.createQuery(cq);
        //Execute the query and stores the result in an ArrayList
        ArrayList<Estado> estados = new ArrayList<>(q.getResultList());
        //Transaction ends
        em.getTransaction().commit();
        return estados;
    }

    public void populateDB() {
        ArrayList<Object> objects = new ArrayList<>();

        Estado e1 = new Estado("Sonora", null);
        Estado e2 = new Estado("Sinaloa", null);
        Estado e3 = new Estado("Jalisco", null);

        objects.add(e1);
        objects.add(e2);
        objects.add(e3);

        Municipio m1 = new Municipio("Cajeme", e1, null);
        Municipio m2 = new Municipio("Hermosillo", e1, null);
        Municipio m3 = new Municipio("Navojoa", e1, null);

        objects.add(m1);
        objects.add(m2);
        objects.add(m3);

        Municipio m4 = new Municipio("Los Mochis", e2, null);
        Municipio m5 = new Municipio("Culiacan", e2, null);
        Municipio m6 = new Municipio("Mazatlan", e2, null);

        objects.add(m4);
        objects.add(m5);
        objects.add(m6);

        Municipio m7 = new Municipio("Guadalajara", e3, null);
        Municipio m8 = new Municipio("Tonala", e3, null);
        Municipio m9 = new Municipio("Zapopan", e3, null);

        objects.add(m7);
        objects.add(m8);
        objects.add(m9);

        em.getTransaction().begin();
        for (Object o : objects) {
            em.persist(o);
        }
        em.getTransaction().commit();
    }
}
