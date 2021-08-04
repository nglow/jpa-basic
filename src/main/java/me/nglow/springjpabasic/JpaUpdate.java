package me.nglow.springjpabasic;

import javax.persistence.Persistence;

public class JpaUpdate {

    public static void main(String[] args) {
        var entityManagerFactory = Persistence.createEntityManagerFactory("hello");
        var entityManager = entityManagerFactory.createEntityManager();
        var transaction = entityManager.getTransaction();

        transaction.begin();
        try {
            var member = entityManager.find(Member.class, 1L);
            System.out.println("Member.id = " + member.getId());
            System.out.println("Member.name = " + member.getName());

            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
        } finally {
            entityManager.close();
        }

        entityManagerFactory.close();
    }

}
