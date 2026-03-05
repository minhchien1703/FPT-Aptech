package sessionbeans;

import entities.Student;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;
import jakarta.persistence.PersistenceContext;

import java.util.List;

@Stateless
public class StudentFacade {
    private EntityManager getEntityManager() {
        return Persistence.createEntityManagerFactory("SIS_PU").createEntityManager();
    }

    public void create(Student student) {
        EntityManager em = Persistence.createEntityManagerFactory("SIS_PU").createEntityManager();
        try {
            em.getTransaction().begin();

            em.persist(student);

            em.getTransaction().commit();
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            e.printStackTrace();
        } finally {
            em.close();
        }
    }

    public List<Student> findAll() {
        EntityManager em = getEntityManager();
        return em.createQuery("SELECT s FROM Student s", Student.class).getResultList();
    }

    public Student find(Object id) {
        EntityManager em = getEntityManager();
        return em.find(Student.class, id);
    }
}