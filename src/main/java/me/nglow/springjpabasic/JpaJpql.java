package me.nglow.springjpabasic;

import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

public class JpaJpql {

    public static void main(String[] args) {
        var entityManagerFactory = Persistence.createEntityManagerFactory("hello");
        var entityManager = entityManagerFactory.createEntityManager();
        var transaction = entityManager.getTransaction();

        transaction.begin();
        try {
            var members = entityManager.createQuery("select m from Member m", Member.class)
                    .getResultList();
            for (Member member : members) {
                System.out.println(member.toString());
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
