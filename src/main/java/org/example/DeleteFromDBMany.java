package org.example;

import org.example.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.sql.SQLException;

public class DeleteFromDBMany {
    public static void main(String[] args) throws SQLException {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory();
                Session session = null;
                try {
                    session = factory.getCurrentSession();
                    session.beginTransaction();
                    session.createQuery("DELETE Employee WHERE name = 'Anton'").executeUpdate();

                    session.getTransaction().commit();


                } catch (Exception e){
                    e.printStackTrace();
                } finally {
                        session.close();
                        factory.close();

                }






        System.out.println("Done!");
    }
}