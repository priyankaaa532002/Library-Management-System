package com.example.librarymanagementsystem;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Region;
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
        String u = tv_username.getText();
        String p = tv_password.getText();
        if(u.isBlank() || p.isBlank()){
            showMessage("User name or password can not be blank",Alert.AlertType.NONE);
        }else {
            int val = DataBase.login(u,p);
            System.out.println(val);
            if (val != 0){
                root = new FXMLLoader(getClass().getResource("home_page.fxml"));
                stage = (Stage) (btn_login.getScene().getWindow());
                try {
                    stage.setScene(new Scene(root.load()));
                } catch (IOException e) {
                    System.out.println(e);
                }
            }
            else{

            }
        }
    }

    @FXML
    void onClickRegister(ActionEvent event) {
        String u = tv_username.getText();
        String p = tv_password.getText();
        if(u.isBlank() || p.isBlank()){
            showMessage("User name or password can not be blank",Alert.AlertType.NONE);
        }else {
            DataBase.register(u,p);
            root = new FXMLLoader(getClass().getResource("home_page.fxml"));
            stage = (Stage) (btn_login.getScene().getWindow());
            try {
                stage.setScene(new Scene(root.load()));
            } catch (IOException e) {
                System.out.println(e);
            }
        }

    }

    private void showMessage(String content, Alert.AlertType type) {
        Alert alert = new Alert(type, content, ButtonType.OK);
        alert.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
        alert.show();
    }
}