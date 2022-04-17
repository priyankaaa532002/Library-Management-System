package com.example.librarymanagementsystem;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class HomePage {

    @FXML
    private Button btn_addBooks;

    @FXML
    private Button btn_addCustomer;

    @FXML
    private Button btn_displayAvailable;

    @FXML
    private Button btn_displayBorrowed;

    @FXML
    private Button btn_displayCustomers;

    @FXML
    private Button btn_issueBook;

    @FXML
    private Button btn_returnBook;

    private FXMLLoader root;

    private Stage stage;

    private Scene scene;

    @FXML
    void onClickAddBook(ActionEvent event) {
        root = new FXMLLoader(getClass().getResource("add_book.fxml"));
        stage = (Stage) (btn_addBooks.getScene().getWindow());
        try {
            stage.setScene(new Scene(root.load()));
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    @FXML
    void onClickAddCustomer(ActionEvent event) {
        root = new FXMLLoader(getClass().getResource("add_customer.fxml"));
        stage = (Stage) (btn_addCustomer.getScene().getWindow());
        try {
            stage.setScene(new Scene(root.load()));
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    @FXML
    void onClickDisplayAvailable(ActionEvent event) {
        root = new FXMLLoader(getClass().getResource("display_available.fxml"));
        stage = (Stage) (btn_displayAvailable.getScene().getWindow());
        try {
            stage.setScene(new Scene(root.load()));
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    @FXML
    void onClickDisplayBorrowed(ActionEvent event) {
        root = new FXMLLoader(getClass().getResource("display_borrowed.fxml"));
        stage = (Stage) (btn_displayBorrowed.getScene().getWindow());
        try {
            stage.setScene(new Scene(root.load()));
        } catch (IOException e) {
            System.out.println(e);
        }

    }

    @FXML
    void onClickLogOut(ActionEvent event) {
        System.exit(0);
    }

    @FXML
    void onClickDisplayCustomer(ActionEvent event) {
        root = new FXMLLoader(getClass().getResource("display_customers.fxml"));
        stage = (Stage) (btn_displayCustomers.getScene().getWindow());
        try {
            stage.setScene(new Scene(root.load()));
        } catch (IOException e) {
            System.out.println(e);
        }

    }

    @FXML
    void onClickIssue(ActionEvent event) {
        root = new FXMLLoader(getClass().getResource("issue_book.fxml"));
        stage = (Stage) (btn_issueBook.getScene().getWindow());
        try {
            stage.setScene(new Scene(root.load()));
        } catch (IOException e) {
            System.out.println(e);
        }

    }

    @FXML
    void onClickReturn(ActionEvent event) {
        root = new FXMLLoader(getClass().getResource("return_book.fxml"));
        stage = (Stage) (btn_returnBook.getScene().getWindow());
        try {
            stage.setScene(new Scene(root.load()));
        } catch (IOException e) {
            System.out.println(e);
        }

    }

}
