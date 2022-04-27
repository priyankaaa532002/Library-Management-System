package com.example.librarymanagementsystem;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.Region;

import java.sql.*;
public class DataBase {

    private static void showMessage(String content, Alert.AlertType type) {
        Alert alert = new Alert(type, content, ButtonType.OK);
        alert.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
        alert.show();
    }
    public static void insertUser(int user_id,String fName,String lName, String gender , String phone){
        boolean present = false;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library", "root", "");
            Statement statement = con.createStatement();
            String S = "insert into user (user_id, fName, lName, gender, mobile) values ('"+user_id+"','"+ fName +"','"+lName+"','"+gender+"', '"+phone+"')";
            System.out.println("Inserted Successfully!");
            statement.execute(S);
        }  catch(SQLIntegrityConstraintViolationException sql) {
            present = true;
            showMessage("User already exists!", Alert.AlertType.ERROR);
        }   catch (Exception e) {
            System.out.println(e);
        }
        if(present == false) {
            showMessage("Inserted Successfully!", Alert.AlertType.NONE);
        }
    }

    public static void updateUser(int user_id,String fName,String lName, String gender , String phone){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library", "root", "");
            Statement statement = con.createStatement();
            String S = "update user set fName = '"+fName+"',lName = '"+lName+"', gender = '"+gender+"', mobile = '"+phone+"' where user_id = '"+user_id+"'";
            System.out.println("Inserted Successfully!");
            showMessage("Updated Successfully!", Alert.AlertType.NONE);
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
            showMessage("Updated Successfully!", Alert.AlertType.NONE);
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
            showMessage("Deleted Successfully!", Alert.AlertType.NONE);
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
            showMessage("Deleted Successfully!", Alert.AlertType.NONE);
            statement.execute(S);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void insertBook(int book_id,String name,String author, String publisher){
        boolean present = false;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library", "root", "");
            Statement statement = con.createStatement();
            String insertS = "insert into book (book_id, name , author, publisher) values ('"+book_id+"','"+ name +"','"+author+"','"+publisher+"')";
            statement.execute(insertS);
        } catch(SQLIntegrityConstraintViolationException sql) {
            showMessage("Book already inserted!", Alert.AlertType.ERROR);
            present = true;
        } catch(Exception e) {
            System.out.println(e);
        }

        if(present == false) {
            System.out.println("Inserted Successfully!");
            showMessage("Inserted Successfully!", Alert.AlertType.NONE);
        }
    }

    public static void issueBook(int user_id,int book_id){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library", "root", "");
            Statement statement = con.createStatement();
            String s = "insert into borrowed (user_id,book_id) values ('"+user_id+"','"+ book_id+"')";
            System.out.println("Inserted Successfully!");
            showMessage("Book Issued!", Alert.AlertType.NONE);
            statement.execute(s);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void returnBook(int user_id, int book_id){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library", "root", "");
            Statement statement = con.createStatement();
            String S = "delete from borrowed where book_id = '"+book_id+"' and user_id = '"+user_id+"'";
            System.out.println("Deleted Successfully!");
            showMessage("Book Returned!", Alert.AlertType.NONE);
            statement.execute(S);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void register(String user_name, String password){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library", "root", "");
            Statement statement = con.createStatement();
            String S = "insert into userLogin (user_name, password) values ('"+user_name+"','"+ password +"')";
            System.out.println("Inserted Successfully!");
            showMessage("Registered Successfully!", Alert.AlertType.NONE);
            statement.execute(S);
        }catch (Exception e){
            System.out.println(e);
        }
    }

    public static int login(String user_name , String password){
        int present = 0;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library", "root", "");
//            Statement statement = con.createStatement();
            PreparedStatement statement  = con.prepareStatement("select * from userLogin where user_name = '"+user_name+"' and password = '"+ password +"'");
            ResultSet rs = statement.executeQuery();
            int count = 0;
            while(rs.next()) {
                count++;
            }
//            System.out.println(rs.next());
            if(count==0){
                showMessage("Invalid credentials", Alert.AlertType.NONE);
                present =0;
            }else{
                showMessage("Logged In", Alert.AlertType.NONE);
                present = 1;
            }
        }catch (Exception e){
            System.out.println(e);
        }
        return present;
    }
    public static void displayUser(){

    }
}
