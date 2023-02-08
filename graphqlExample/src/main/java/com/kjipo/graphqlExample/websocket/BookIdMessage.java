package com.kjipo.graphqlExample.websocket;

public class BookIdMessage {
    private String bookid;


//    public BookIdMessage(long bookid) {
//        this.bookid = bookid;
//    }

    public BookIdMessage() {

    }

    public BookIdMessage(String bookid) {
//        this.bookid = Long.parseLong(bookid);
        this.bookid = bookid;
    }

    public String getBookid() {
        return bookid;
    }

    public void setBookid(String bookid) {
        this.bookid = bookid;
    }

}
