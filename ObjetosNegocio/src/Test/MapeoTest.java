package Test;

import ObjetosNegocio.*;
import java.util.ArrayList;
import java.util.Date;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class MapeoTest {

    public static void main(String[] args) {
        String PU = "ObjetosNegocioPU";
        EntityManagerFactory factory = null;
        EntityManager em = null;

        factory = Persistence.createEntityManagerFactory(PU);
        em = factory.createEntityManager();
        
        ArrayList<Object> objects = new ArrayList<>();
        
        Estado e1 = new Estado("Sonora", null);
        Estado e2 = new Estado("Sinaloa", null);
        
        objects.add(e1);
        objects.add(e2);
        
        Municipio m1 = new Municipio("Cajeme",  e1, null);
        Municipio m2 = new Municipio("Hermosillo",  e1, null);
        Municipio m3 = new Municipio("Navojoa",  e1, null);
        
        objects.add(m1);
        objects.add(m2);
        objects.add(m3);
        
        Municipio m4 = new Municipio("Los Mochis",  e2, null);
        Municipio m5 = new Municipio("Culiacan",  e2, null);
        Municipio m6 = new Municipio("Mazatlan",  e2, null);

        objects.add(m4);
        objects.add(m5);
        objects.add(m6);
        
        UsuarioAdministrador usuario1 = new UsuarioAdministrador("Juan Solis", "juan32dd2@gmail.com", "password", "6444253614", "jesp010", "male", new Date(), null, null, m1);
        UsuarioNormal usuario2 = new UsuarioNormal("Juan Solis", "juan42d2@gmail.com", "password", "6444253614", "jesp010", "male", new Date(), null, null, m4);

        objects.add(usuario1);
        objects.add(usuario2);

        PostAnclado post1 = new PostAnclado(new Date(), "Post #3d2 Anclado", "Este es el primer post", usuario1, null);
        PostComun post2 = new PostComun(new Date(), "Post #23d Comun", "Este es el segundo post", usuario2, null, null);

        objects.add(post1);
        objects.add(post2);

        Comentario c1 = new Comentario(new Date(), "Primer comentario", post2, usuario2, null, null);
        Comentario c2 = new Comentario(new Date(), "Primer comentario", post2, usuario2, null, null);

        ArrayList<Comentario> comentarios = new ArrayList<>();
        comentarios.add(c1);
        comentarios.add(c2);

        usuario2.setComentarios(comentarios);
        
        em.getTransaction().begin();
        for (Object o : objects) {
            em.persist(o);
        }
        em.getTransaction().commit();
    }
}
