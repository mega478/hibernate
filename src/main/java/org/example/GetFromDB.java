package org.example;

import org.example.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.sql.SQLException;

public class GetFromDB {
    public static void main(String[] args) throws SQLException {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory();
        Session session = null;
        Employee employee = null;
        int id = 11;
        try {
            session = factory.getCurrentSession();

            session.beginTransaction();
            employee = session.get(Employee.class, id);
            session.getTransaction().commit();
            System.out.println(employee);


        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
            factory.close();

        }

        System.out.println("Hello world!");
    }
}