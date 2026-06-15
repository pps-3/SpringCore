package com.example;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

public class Main {

    public static void main(String[] args) {

        EntityManagerFactory emf =
                Persistence.createEntityManagerFactory(
                        "myunit");

        EntityManager em =
                emf.createEntityManager();

        // a
        System.out.println("A");

        TypedQuery<Sale> q1 =
                em.createQuery(
                "from Sale s where s.product.pid=:id",
                Sale.class);

        q1.setParameter("id",101);

        q1.getResultList()
          .forEach(System.out::println);

        // b
        System.out.println("\nB");

        TypedQuery<Sale> q2 =
                em.createQuery(
                """
                from Sale s
                where s.qty
                between :a and :b
                """,
                Sale.class);

        q2.setParameter("a",5);
        q2.setParameter("b",20);

        q2.getResultList()
          .forEach(System.out::println);

        // c
        System.out.println("\nC");

        TypedQuery<Sale> q3 =
                em.createQuery(
                """
                from Sale s
                where s.pricePerUnit
                < s.product.price
                """,
                Sale.class);

        q3.getResultList()
          .forEach(System.out::println);

        // d
        System.out.println("\nD");

        TypedQuery<Sale> q4 =
                em.createQuery(
                """
                from Sale s
                order by s.qty asc
                """,
                Sale.class);

        q4.getResultList()
          .forEach(System.out::println);

        // e
        System.out.println("\nE");

        TypedQuery<Sale> q5 =
                em.createQuery(
                "from Sale",
                Sale.class);

        q5.setFirstResult(4);
        q5.setMaxResults(4);

        q5.getResultList()
          .forEach(System.out::println);

        em.close();
        emf.close();
    }
}