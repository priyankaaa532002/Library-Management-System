package com.example.librarymanagementsystem;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

import java.io.IOException;

public class DisplayBorrowed {
    @FXML
    private Button btn_back;
    private FXMLLoader root;

    private Stage stage;

    private Scene scene;

    @FXML
    private TableView<?> table_borrowed;

    @FXML
    private TableColumn<?, ?> tc_StudentName;

    @FXML
    private TableColumn<?, ?> tc_bookId;

    @FXML
    private TableColumn<?, ?> tc_bookName;

    @FXML
    private TableColumn<?, ?> tc_studentId;

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
