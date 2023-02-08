package com.kjipo.graphqlExample.websocket;

public class BookMessage {

    private long id;

    private String title;

    public BookMessage(long id, String title) {
       this.id = id;
       this.title = title;
    }


    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }
}
