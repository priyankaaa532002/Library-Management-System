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

public class DisplayCustomers implements Initializable {

    ObservableList<User> items= FXCollections.observableArrayList();

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

    }

    @FXML
    private TableView<User> table_users;

    @FXML
    private TableColumn<User, String> tc_first;

    @FXML
    private TableColumn<User, String> tc_gender;

    @FXML
    private TableColumn<User, String> tc_last;

    @FXML
    private TableColumn<User, String> tc_phone;

    @FXML
    private TableColumn<User, Integer> tc_userId;

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

        table_users.setItems(items);
        tc_userId.setCellValueFactory(new PropertyValueFactory<User,Integer>("id"));
        tc_first.setCellValueFactory(new PropertyValueFactory<User,String>("name"));
        tc_last.setCellValueFactory(new PropertyValueFactory<User,String>("last"));
        tc_gender.setCellValueFactory(new PropertyValueFactory<User,String>("gender"));
        tc_phone.setCellValueFactory(new PropertyValueFactory<User,String>("phone"));
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library","root","");
            PreparedStatement statement = con.prepareStatement("select * from user");
            ResultSet rs = statement.executeQuery();
            items.clear();
            table_users.getItems().clear();

            while(rs.next()) {
                int s1 = rs.getInt(1);
                String s2 = rs.getString(2);
                String  s3 = rs.getString(3);
                String s4 = rs.getString(4);
                String s5 = rs.getString(5);
                User stu =new User(s1, s2, s3, s4,s5);
                items.add(stu);
                System.out.println(s1 + " " + s2 + " " + s3 + " " + s4);
            }
            con.close();
        }catch(Exception e ){}
    }
}
