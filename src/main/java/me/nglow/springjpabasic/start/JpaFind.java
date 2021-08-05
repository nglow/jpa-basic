package me.nglow.springjpabasic.start;

import javax.persistence.Persistence;

public class JpaFind {

    public static void main(String[] args) {
        var entityManagerFactory = Persistence.createEntityManagerFactory("hello");
        var entityManager = entityManagerFactory.createEntityManager();
        var transaction = entityManager.getTransaction();

        transaction.begin();
        try {
            var member = entityManager.find(MemberDemo.class, 1L);
            member.setName("ChangedName");

            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
        } finally {
            entityManager.close();
        }

        entityManagerFactory.close();
    }
}
