package ilias.uniapp.db;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import static ilias.uniapp.UniApp.getEM;

public class Connector {

    public static void insertUniversity(University university) {
        EntityManager em = getEM();
        em.getTransaction().begin();
        
        em.createNativeQuery("INSERT INTO university (name, domain, webpage, alphatwocode, country, stateprovince) VALUES (?,?,?,?,?,?)")
        .setParameter(1, university.getName())
        .setParameter(2, university.getDomain())
        .setParameter(3, university.getWebpage())
        .setParameter(4, university.getAlphatwocode())
        .setParameter(5, university.getCountry())
        .setParameter(6, university.getStateprovince())
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

    public static University getUniversityById(Integer universityId) {
        EntityManager em = getEM();
        em.getTransaction().begin();

        Query findUniById = em.createNamedQuery("University.findById", University.class);
        University university = (University) findUniById.getSingleResult();
        return university;
    }


    public static void deleteUniversity(University university) {
        EntityManager em = getEM();
        em.getTransaction().begin();
        em.remove(university);
        em.getTransaction().commit();
    }

//    public static List<UniversityView> getMealViews() {
//        EntityManager em = getEM();
//
//        var qb = em.getCriteriaBuilder();
//        var query = qb.createQuery(MealView.class);
//        var root = query.from(MealView.class);
//        query.select(root).orderBy(qb.desc(root.get("viewCount")));
//
//        List<MealView> mealviews = em.createQuery(query).getResultList();
//
//        return mealviews;
//    }
//
//    public static void updateMealViewViews(Meal meal) {
//        EntityManager em = getEM();
//
//        var qb = em.getCriteriaBuilder();
//        var query = qb.createQuery(MealView.class);
//        var root = query.from(MealView.class);
//        query.select(root);
//        query.where(qb.equal(root.get("meal"), meal));
//
//        List<MealView> mealviews = em.createQuery(query).getResultList();
//
//        if (!mealviews.isEmpty()) {
//            MealView mealView = mealviews.get(0);
//            mealView.setViewCount(mealView.getViewCount() + 1);
//            saveMealView(mealView);
//        }
//    }
//
//    public static void insertMealView(Meal meal) {
//
//        MealView mealView = new MealView(meal, 1);
//        saveMealView(mealView);
//    }
//
//    private static void saveMealView(MealView mealView) {
//        EntityManager em = getEM();
//
//        em.getTransaction().begin();
//        em.persist(mealView);
//        em.getTransaction().commit();
//    }
//
//    public static void deleteMealView(Meal meal) {
//        EntityManager em = getEM();
//
//        var qb = em.getCriteriaBuilder();
//        var query = qb.createQuery(MealView.class);
//        var root = query.from(MealView.class);
//        query.select(root);
//        query.where(qb.equal(root.get("meal"), meal));
//
//        List<MealView> mealviews = em.createQuery(query).getResultList();
//
//        if (!mealviews.isEmpty()) {
//            MealView mealView = mealviews.get(0);
//            em.getTransaction().begin();
//            em.remove(mealView);
//            em.getTransaction().commit();
//        }
//    }
}
