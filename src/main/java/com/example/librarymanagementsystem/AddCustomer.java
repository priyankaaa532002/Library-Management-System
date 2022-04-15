package com.example.librarymanagementsystem;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;

import java.io.IOException;

public class AddCustomer {
    @FXML
    private Button btn_back;
    private FXMLLoader root;

    private Stage stage;

    private Scene scene;

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

    @FXML
    private Button btn_addCustomer;


    @FXML
    private ToggleGroup gender;

    @FXML
    private RadioButton tb_female;

    @FXML
    private RadioButton tb_male;

    @FXML
    private TextField tv_fName;

    @FXML
    private TextField tv_lName;

    @FXML
    private TextField tv_phoneNo;

    @FXML
    private TextField tv_userId;

    @FXML
    void onClickAddCustomer(ActionEvent event) {

    }

}
