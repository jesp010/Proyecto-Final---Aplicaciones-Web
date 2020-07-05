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

//        ArrayList<Object> objects = new ArrayList<>();
//        UsuarioAdministrador usuario1 = new UsuarioAdministrador("Juan Solis", "juan@gmail.com", "password", "6444253614", "jesp010", null, null);
//        UsuarioNormal usuario2 = new UsuarioNormal("Juan Solis", "juan@gmail.com", "password", "6444253614", "jesp010", null, null);

//        objects.add(usuario1);
//        objects.add(usuario2);
//
//        PostAnclado post1 = new PostAnclado(new Date(), "Post #1 Anclado", "Este es el primer post", usuario1, null);
//        PostComun post2 = new PostComun(new Date(), "Post #2 Comun", "Este es el segundo post", usuario2, null, null);
//
//        objects.add(post1);
//        objects.add(post2);
//
//        Comentario c1 = new Comentario(new Date(), "Primer comentario", post2, usuario2, null, null);
//        Comentario c2 = new Comentario(new Date(), "Primer comentario", post2, usuario2, null, null);
//
//        ArrayList<Comentario> comentarios = new ArrayList<>();
//        comentarios.add(c1);
//        comentarios.add(c2);
//
//        usuario2.setComentarios(comentarios);
//        
//        em.getTransaction().begin();
//        for (Object o : objects) {
//            em.persist(o);
//        }
//        em.getTransaction().commit();
    }
}
