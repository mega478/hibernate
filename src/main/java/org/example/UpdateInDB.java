package org.example;

import org.example.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.sql.SQLException;
import java.util.List;

public class UpdateInDB {
    public static void main(String[] args) throws SQLException {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory();
        Session session = null;
        int id = 13;
        try {
            session = factory.getCurrentSession();
            session.beginTransaction();
            Employee empl = session.get(Employee.class, id);
            empl.setPhone("7077733565");

            session.getTransaction().commit();


        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
            factory.close();

        }


        System.out.println("Done!");
    }
}