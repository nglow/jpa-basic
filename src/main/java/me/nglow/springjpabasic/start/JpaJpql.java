package me.nglow.springjpabasic.start;

import javax.persistence.Persistence;

public class JpaJpql {

    public static void main(String[] args) {
        var entityManagerFactory = Persistence.createEntityManagerFactory("hello");
        var entityManager = entityManagerFactory.createEntityManager();
        var transaction = entityManager.getTransaction();

        transaction.begin();
        try {
            var members = entityManager.createQuery("select m from MemberDemo m", MemberDemo.class)
                    .getResultList();
            for (MemberDemo memberDemo : members) {
                System.out.println(memberDemo.toString());
            }
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
        } finally {
            entityManager.close();
        }

        entityManagerFactory.close();
    }
}
