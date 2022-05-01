package com.example.librarymanagementsystem;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Date;

public class IssueBook {
    @FXML
    private Button btn_back;
    private FXMLLoader root;

    private Stage stage;

    private Scene scene;

    @FXML
    private Button btn_issueBook;

    @FXML
    private TextField tv_bookId;

    @FXML
    private TextField tv_userId;

    @FXML
    private DatePicker dp_date;


    @FXML
    void onClickIssueBook(ActionEvent event) {
        int bookId = Integer.parseInt(tv_bookId.getText());
        int userId = Integer.parseInt(tv_userId.getText());
        Date date = Date.valueOf(dp_date.getValue());
        DataBase.issueBook(userId,bookId, date);
    }
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
}
