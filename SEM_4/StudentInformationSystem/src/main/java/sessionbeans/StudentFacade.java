package sessionbeans;

import entities.Student;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import java.util.List;

@Stateless
public class StudentFacade {
    @PersistenceContext(unitName = "SIS_PU")
    private EntityManager em;

    public void create(Student student) {
        em.persist(student);
    }

    public List<Student> findAll() {
        return em.createQuery("SELECT s FROM Student s", Student.class).getResultList();
    }

    public Student find(Object id) {
        return em.find(Student.class, id);
    }
}