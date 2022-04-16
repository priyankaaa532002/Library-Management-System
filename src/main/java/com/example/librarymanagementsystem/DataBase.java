package com.example.librarymanagementsystem;
import java.sql.*;
public class DataBase {
    public static void insertUser(int user_id,String fName,String lName, String gender , String phone){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library", "root", "");
            Statement statement = con.createStatement();
            String insertS = "insert into user (user_id, fName, lName, gender, mobile) values ('"+user_id+"','"+ fName +"','"+lName+"','"+gender+"', '"+phone+"')";
            System.out.println("Inserted Successfully!");
            statement.execute(insertS);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void insertBook(int book_id,String name,String author, String publisher){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library", "root", "");
            Statement statement = con.createStatement();
            String insertS = "insert into book (book_id, name , author, publisher) values ('"+book_id+"','"+ name +"','"+author+"','"+publisher+"')";
            System.out.println("Inserted Successfully!");
            statement.execute(insertS);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
