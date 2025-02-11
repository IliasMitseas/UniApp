package ilias.uniapp.db;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;
import static ilias.uniapp.UniApp.getEM;

public class Connector {

    public static void insertUniversity(University university) {
        EntityManager em = getEM();
        em.getTransaction().begin();

        em.createNativeQuery("INSERT INTO university (name, domain, webpage, alphatwocode, country, stateprovince, description, contact, universityviews) VALUES (?,?,?,?,?,?,?,?,?)")
                .setParameter(1, university.getName())
                .setParameter(2, university.getDomain())
                .setParameter(3, university.getWebpage())
                .setParameter(4, university.getAlphatwocode())
                .setParameter(5, university.getCountry())
                .setParameter(6, university.getStateprovince())
                .setParameter(7, university.getDescription())
                .setParameter(8, university.getContact())
                .setParameter(9, university.getUniversityviews())
                .executeUpdate();
        em.getTransaction().commit();
    }

    public static void insertUniversityViews(University university) {
        EntityManager em = getEM();
        em.getTransaction().begin();

        em.createNativeQuery("update university SET universityviews = ? WHERE name = ?")
                .setParameter(1, university.getUniversityviews())
                .setParameter(2, university.getName())
                .executeUpdate();
        em.getTransaction().commit();
    }

    //I have a problem cocncerning an update by name.
    public static void updateUniversity(University university) {
        EntityManager em = getEM();
        em.getTransaction().begin();

        em.createNativeQuery("UPDATE university SET name = ?, domain = ?, webpage = ?, alphatwocode = ?, country = ?, stateprovince = ? WHERE name = ?")
                .setParameter(1, university.getName())
                .setParameter(2, university.getDomain())
                .setParameter(3, university.getWebpage())
                .setParameter(4, university.getAlphatwocode())
                .setParameter(5, university.getCountry())
                .setParameter(6, university.getStateprovince())
                .setParameter(7, university.getName())
                .executeUpdate();
        em.getTransaction().commit();
    }

    public static University getUniversityByName(String universityName) {
        EntityManager em = getEM();
        University university = null;

        Query findUniByName = em.createNamedQuery("University.findByName", University.class);
        findUniByName.setParameter("name", universityName);
        university = (University) findUniByName.getSingleResult();  // Αν δεν υπάρχει, πετάει
        return university;
    }

    public static void deleteUniversity(University university) {
        EntityManager em = getEM();
        em.getTransaction().begin();
        em.remove(university);
        em.getTransaction().commit();
    }


    public static List<University> getUniversities(){
        EntityManager entityManager = getEM();

        Query findAllUniversities = entityManager.createNamedQuery("University.findAll", University.class);
        return findAllUniversities.getResultList();

    }
}