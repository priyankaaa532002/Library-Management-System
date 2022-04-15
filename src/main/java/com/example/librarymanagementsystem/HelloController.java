package com.example.librarymanagementsystem;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloController {
    @FXML
    private Button btn_login;

    @FXML
    private Button btn_register;

    @FXML
    private TextField tv_password;

    @FXML
    private TextField tv_username;

    @FXML
    private ImageView imageView;

    private FXMLLoader root;

    private Stage stage;

    private Scene scene;

    @FXML
    void onClickLogin(ActionEvent event) {

    }

    @FXML
    void onClickRegister(ActionEvent event) {
        root = new FXMLLoader(getClass().getResource("home_page.fxml"));
        stage = (Stage) (btn_login.getScene().getWindow());
        try {
            stage.setScene(new Scene(root.load()));
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}