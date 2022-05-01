package com.example.librarymanagementsystem;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.scene.layout.Region;
import javafx.stage.Stage;


import java.io.IOException;

public class AddBook {
    @FXML
    private Button btn_back;
    private FXMLLoader root;

    private Stage stage;

    private Scene scene;

    @FXML
    private Button btn_addBook;


    @FXML
    private TextField tv_authorName;

    @FXML
    private TextField tv_bookId;

    @FXML
    private TextField tv_bookName;

    @FXML
    private TextField tv_publisherName;

    @FXML
    private Button btn_deleteBook;

    @FXML
    private Button btn_updateBook;

    @FXML
    void onClickDeleteBook(ActionEvent event) {
        int id = Integer.parseInt(tv_bookId.getText());
        DataBase.deleteBook(id);
    }

    @FXML
    void onClickUpdateBook(ActionEvent event) {
        String name = tv_bookName.getText();
        String author = tv_authorName.getText();
        int id = Integer.parseInt(tv_bookId.getText());
        String pub = tv_publisherName.getText();
        DataBase.updateBook(id,name,author,pub);
    }


    @FXML
    void onClickAddBook(ActionEvent event) {
        String name = tv_bookName.getText();
        String author = tv_authorName.getText();
        int id = Integer.parseInt(tv_bookId.getText());
        String pub = tv_publisherName.getText();
        if(name.isEmpty() || author.isEmpty()) {
            showMessage("All Fields are required", Alert.AlertType.ERROR);
        } else {
            DataBase.insertBook(id, name, author, pub);
        }
    }

    private static void showMessage(String content, Alert.AlertType type) {
        Alert alert = new Alert(type, content, ButtonType.OK);
        alert.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
        alert.show();
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
