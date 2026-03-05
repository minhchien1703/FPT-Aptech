package sessionbeans;

import entities.Subject;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import java.util.List;

@Stateless
public class SubjectFacade {
    @PersistenceContext(unitName = "SIS_PU")
    private EntityManager em;

    public List<Subject> findAll() {
        return em.createQuery("SELECT s FROM Subject s", Subject.class).getResultList();
    }

    public Subject find(Object id) {
        return em.find(Subject.class, id);
    }
}