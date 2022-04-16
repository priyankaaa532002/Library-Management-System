package com.example.librarymanagementsystem;
import java.sql.*;
public class DataBase {
    public static void insertUser(int user_id,String fName,String lName, String gender , String phone){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library", "root", "");
            Statement statement = con.createStatement();
            String S = "insert into user (user_id, fName, lName, gender, mobile) values ('"+user_id+"','"+ fName +"','"+lName+"','"+gender+"', '"+phone+"')";
            System.out.println("Inserted Successfully!");
            statement.execute(S);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void updateUser(int user_id,String fName,String lName, String gender , String phone){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library", "root", "");
            Statement statement = con.createStatement();
            String S = "update user set fName = '"+fName+"',lName = '"+lName+"', gender = '"+gender+"', mobile = '"+phone+"' where user_id = '"+user_id+"'";
            System.out.println("Inserted Successfully!");
            statement.execute(S);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void updateBook(int id,String name,String auth, String pub){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library", "root", "");
            Statement statement = con.createStatement();
            String S = "update book set name = '"+name+"',author = '"+auth+"', publisher = '"+pub+"' where book_id = '"+id+"'";
            System.out.println("Inserted Successfully!");
            statement.execute(S);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void deleteUser(int user_id){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library", "root", "");
            Statement statement = con.createStatement();
            String S = "delete from user where user_id = '"+user_id+"' ";
            System.out.println("Inserted Successfully!");
            statement.execute(S);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void deleteBook(int book_id){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library", "root", "");
            Statement statement = con.createStatement();
            String S = "delete from book where book_id = '"+book_id+"' ";
            System.out.println("Inserted Successfully!");
            statement.execute(S);
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

    public static void insertBorrowed(int user_id,String user,int book_id,String book){

    }

    public static void displayUser(){

    }
}
