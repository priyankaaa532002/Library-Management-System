package com.example.librarymanagementsystem;

public class Book {
    private int id;
    private String name,author,pub;
    Book(){}
    Book(int id,String name, String author, String pub){
        this.id = id;
        this.name = name;
        this.author = author;
        this.pub = pub;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }
    public void setAuthor(String last) {
        this.author = author;
    }

    public String getPub() {
        return pub;
    }
    public void setPub(String phone) {
        this.pub = pub;
    }
}
