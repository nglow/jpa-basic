package me.nglow.springjpabasic;

import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaPersist {

    public static void main(String[] args) {
        var entityManagerFactory = Persistence.createEntityManagerFactory("hello");
        var entityManager = entityManagerFactory.createEntityManager();
        var transaction = entityManager.getTransaction();

        transaction.begin();
        try {
            Member member = new Member();
            member.setId(4L);
            member.setName("memberD");
            entityManager.persist(member);

            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
        } finally {
            entityManager.close();
        }

        entityManagerFactory.close();
    }
}
