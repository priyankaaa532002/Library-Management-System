package com.example.librarymanagementsystem;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;

public class DisplayBorrowed implements Initializable {
    ObservableList<Borrowed> items= FXCollections.observableArrayList();
    @FXML
    private Button btn_back;
    private FXMLLoader root;

    private Stage stage;

    private Scene scene;

    @FXML
    private Button btn_search;
    @FXML
    private TextField tv_search;
    @FXML
    void onClickSearch(ActionEvent event) {
        table_borrowed.setItems(items);
        String search = tv_search.getText();
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library","root","");
            PreparedStatement statement;
            if (search.isBlank()){
                statement = con.prepareStatement("select user_id,fname,book_id,name from " +
                        "user natural join (borrowed natural join book)");
            }else {
                statement = con.prepareStatement("select user_id,fname,book_id,name from " +
                        "user natural join (borrowed natural join book) where name = '"+search+"'");
            }
            ResultSet rs = statement.executeQuery();
            items.clear();
            table_borrowed.getItems().clear();
            tc_bookId.setCellValueFactory(new PropertyValueFactory<Borrowed,Integer>("bid"));
            tc_bookName.setCellValueFactory(new PropertyValueFactory<Borrowed,String>("book"));
            tc_studentId.setCellValueFactory(new PropertyValueFactory<Borrowed,Integer>("uid"));
            tc_StudentName.setCellValueFactory(new PropertyValueFactory<Borrowed,String>("user"));

            while(rs.next()) {
                int s1 = rs.getInt(1);
                String s2 = rs.getString(2);
                int  s3 = rs.getInt(3);
                String s4 = rs.getString(4);
                Borrowed b =new Borrowed(s1, s2, s3, s4);
                items.add(b);
                System.out.println(s1 + " " + s2 + " " + s3 + " " + s4);
            }
            table_borrowed.setItems(items);
            con.close();
        }catch(Exception e ){}
    }

    @FXML
    private TableView<Borrowed> table_borrowed;

    @FXML
    private TableColumn<Borrowed, String> tc_StudentName;

    @FXML
    private TableColumn<Borrowed, Integer> tc_bookId;

    @FXML
    private TableColumn<Borrowed, String> tc_bookName;

    @FXML
    private TableColumn<Borrowed, Integer> tc_studentId;

    @FXML
    void onClickBack(ActionEvent event) {
        root = new FXMLLoader(getClass().getResource("home_page.fxml"));
        stage = (Stage) (btn_back.getScene().getWindow());
        try {
            stage.setScene(new Scene(root.load()));
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        table_borrowed.setItems(items);

        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library","root","");
            PreparedStatement statement = con.prepareStatement("select user_id,fname,book_id,name from " +
                    "user natural join (borrowed natural join book)");
            ResultSet rs = statement.executeQuery();
            items.clear();
            table_borrowed.getItems().clear();
            tc_bookId.setCellValueFactory(new PropertyValueFactory<Borrowed,Integer>("bid"));
            tc_bookName.setCellValueFactory(new PropertyValueFactory<Borrowed,String>("book"));
            tc_studentId.setCellValueFactory(new PropertyValueFactory<Borrowed,Integer>("uid"));
            tc_StudentName.setCellValueFactory(new PropertyValueFactory<Borrowed,String>("user"));

            while(rs.next()) {
                int s1 = rs.getInt(1);
                String s2 = rs.getString(2);
                int  s3 = rs.getInt(3);
                String s4 = rs.getString(4);
                Borrowed b =new Borrowed(s1, s2, s3, s4);
                items.add(b);
                System.out.println(s1 + " " + s2 + " " + s3 + " " + s4);
            }
            table_borrowed.setItems(items);
            con.close();
        }catch(Exception e ){}
    }
}
