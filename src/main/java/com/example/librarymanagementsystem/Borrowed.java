package com.example.librarymanagementsystem;

public class Borrowed {
    int uid,bid;
    String book;
    String user;

    Borrowed(){}
    Borrowed(int uid, String user,int bid,String book){
        this.uid = uid;
        this.bid = bid;
        this.book = book;
        this.user = user;
    }
    public int getUid() {
        return uid;
    }
    public void setUid(int uid) {
        this.uid = uid;
    }
    public int getBid() {
        return bid;
    }
    public void setBid(int bid) {
        this.bid = bid;
    }

    public void setBook(String book) {
        this.book = book;
    }

    public String getBook() {
        return book;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

}
