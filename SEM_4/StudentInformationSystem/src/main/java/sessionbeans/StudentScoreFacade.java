package sessionbeans;

import entities.StudentScore;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import java.util.List;

@Stateless
public class StudentScoreFacade {
    @PersistenceContext(unitName = "SIS_PU")
    private EntityManager em;

    public void create(StudentScore score) {
        em.persist(score);
    }

    public List<StudentScore> findAll() {
        // Dùng JOIN FETCH để lấy luôn thông tin Student và Subject, tránh lỗi Lazy Loading
        return em.createQuery("SELECT s FROM StudentScore s JOIN FETCH s.student JOIN FETCH s.subject", StudentScore.class).getResultList();
    }
}