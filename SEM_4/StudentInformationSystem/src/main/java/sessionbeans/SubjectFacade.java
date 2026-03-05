package sessionbeans;

import entities.Subject;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;
import jakarta.persistence.PersistenceContext;

import java.util.List;

@Stateless
public class SubjectFacade {
    private EntityManager getEntityManager() {
        return Persistence.createEntityManagerFactory("SIS_PU").createEntityManager();
    }

    public List<Subject> findAll() {
        EntityManager em = getEntityManager();
        return em.createQuery("SELECT s FROM Subject s", Subject.class).getResultList();
    }

    public Subject find(Object id) {
        EntityManager em = getEntityManager();
        return em.find(Subject.class, id);
    }
}