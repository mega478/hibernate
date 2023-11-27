package org.example;

import org.example.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.sql.SQLException;
import java.util.List;

public class GetFromDBMany {
    public static void main(String[] args) throws SQLException {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory();
        List<Employee> emps = null;
        Session session = null;
        try {
            session = factory.getCurrentSession();

            session.beginTransaction();
            emps = session.createQuery("from Employee").getResultList();
            for (Employee emp : emps) {
                System.out.println(emp);
            }
            session.getTransaction().commit();


        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
            factory.close();
        }
        System.out.println("Hello world!");
    }
}