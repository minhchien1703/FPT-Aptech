package sessionbeans;

import entities.StudentScore;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;
import jakarta.persistence.PersistenceContext;

import java.util.List;

@Stateless
public class StudentScoreFacade {
    private EntityManager getEntityManager() {
        return Persistence.createEntityManagerFactory("SIS_PU").createEntityManager();
    }

    public List<StudentScore> findAll() {
        EntityManager em = getEntityManager();
        try {
            // Sử dụng JOIN FETCH để tránh lỗi Lazy Loading khi hiển thị ở index.jsp
            return em.createQuery("SELECT s FROM StudentScore s JOIN FETCH s.student JOIN FETCH s.subject", StudentScore.class).getResultList();
        } finally {
            em.close();
        }
    }

    public void create(StudentScore score) {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(score);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }

    public StudentScore find(Object id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(StudentScore.class, id);
        } finally {
            em.close();
        }
    }

    public void edit(StudentScore score) {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(score); // Dùng merge để cập nhật dữ liệu
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }
}