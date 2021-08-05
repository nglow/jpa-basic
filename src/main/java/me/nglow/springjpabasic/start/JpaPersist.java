package me.nglow.springjpabasic.start;

import javax.persistence.Persistence;

public class JpaPersist {

    public static void main(String[] args) {
        var entityManagerFactory = Persistence.createEntityManagerFactory("hello");
        var entityManager = entityManagerFactory.createEntityManager();
        var transaction = entityManager.getTransaction();

        transaction.begin();
        try {
            MemberDemo memberDemo = new MemberDemo();
            memberDemo.setId(1L);
            memberDemo.setName("memberA");
            entityManager.persist(memberDemo);

            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
        } finally {
            entityManager.close();
        }

        entityManagerFactory.close();
    }
}
