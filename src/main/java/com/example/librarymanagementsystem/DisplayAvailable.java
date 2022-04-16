package com.example.librarymanagementsystem;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class DisplayAvailable {
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
    private TableColumn<?, ?> tc_author;

    @FXML
    private TableColumn<?, ?> tc_bookId;

    @FXML
    private TableColumn<?, ?> tc_bookName;

    @FXML
    private TableColumn<?, ?> tc_publisher;

    @FXML
    private TableView<?> tv_tableBooks;

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
