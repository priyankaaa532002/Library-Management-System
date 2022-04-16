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

public class DisplayAvailable implements Initializable {
    ObservableList<Book> items= FXCollections.observableArrayList();

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
        String search = tv_search.getText();

        tv_tableBooks.setItems(items);
        tc_bookId.setCellValueFactory(new PropertyValueFactory<Book,Integer>("id"));
        tc_bookName.setCellValueFactory(new PropertyValueFactory<Book,String>("name"));
        tc_author.setCellValueFactory(new PropertyValueFactory<Book,String>("author"));
        tc_publisher.setCellValueFactory(new PropertyValueFactory<Book,String>("pub"));
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library","root","");
            PreparedStatement statement;
            if(search.isBlank()){
                statement = con.prepareStatement("select * from book");
            }else{
                statement = con.prepareStatement("select * from book where name = '"+ search +"'");
            }
            ResultSet rs = statement.executeQuery();
            items.clear();
            tv_tableBooks.getItems().clear();

            while(rs.next()) {
                int s1 = rs.getInt(1);
                String s2 = rs.getString(2);
                String  s3 = rs.getString(3);
                String s4 = rs.getString(4);
                Book b =new Book(s1, s2, s3, s4);
                items.add(b);
                System.out.println(s1 + " " + s2 + " " + s3 + " " + s4);
            }
            con.close();
        }catch(Exception e ){}
    }

    @FXML
    private TableColumn<Book, String> tc_author;

    @FXML
    private TableColumn<Book, Integer> tc_bookId;

    @FXML
    private TableColumn<Book, String> tc_bookName;

    @FXML
    private TableColumn<Book, String> tc_publisher;

    @FXML
    private TableView<Book> tv_tableBooks;

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

        tv_tableBooks.setItems(items);
        tc_bookId.setCellValueFactory(new PropertyValueFactory<Book,Integer>("id"));
        tc_bookName.setCellValueFactory(new PropertyValueFactory<Book,String>("name"));
        tc_author.setCellValueFactory(new PropertyValueFactory<Book,String>("author"));
        tc_publisher.setCellValueFactory(new PropertyValueFactory<Book,String>("pub"));
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library","root","");
            PreparedStatement statement = con.prepareStatement("select * from book");
            ResultSet rs = statement.executeQuery();
            items.clear();
            tv_tableBooks.getItems().clear();

            while(rs.next()) {
                int s1 = rs.getInt(1);
                String s2 = rs.getString(2);
                String  s3 = rs.getString(3);
                String s4 = rs.getString(4);
                Book b =new Book(s1, s2, s3, s4);
                items.add(b);
                System.out.println(s1 + " " + s2 + " " + s3 + " " + s4);
            }
            con.close();
        }catch(Exception e ){}
    }
}
