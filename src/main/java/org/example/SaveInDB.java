package org.example;

import org.example.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.sql.*;
import java.time.LocalDateTime;

public class SaveInDB {
    public static void main(String[] args) throws SQLException {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory();
        Session session = null;
        try {
            session = factory.getCurrentSession();
            Employee employee = new Employee("Elvis", 34, "7077733565", LocalDateTime.now());
            session.beginTransaction();
            session.save(employee);
            session.getTransaction().commit();
            System.out.println("Done!");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
            factory.close();

        }


//        try {
//            Class.forName("com.mysql.cj.jdbc.Driver");
//            System.out.println("Driver load Success!");
//        } catch (ClassNotFoundException e){
//            e.printStackTrace();
//        }
//        Connection connection = DriverManager.getConnection(
//                "jdbc:mysql://localhost:3306/dbdb",
//                "bestuser", "bestuser");
//
//        Statement statement = connection.createStatement();
//        ResultSet results = statement.executeQuery("SELECT * FROM table1");
//
//        while (results.next()) {
//            Integer id = results.getInt(1);
//            String name = results.getString(2);
//            System.out.println(results.getRow() + ". " + id + "\t"+ name);
//        }
//        connection.close();

        System.out.println("Hello world!");
    }
}