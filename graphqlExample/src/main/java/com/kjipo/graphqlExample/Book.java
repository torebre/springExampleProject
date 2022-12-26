package com.kjipo.graphqlExample;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Book {

    @Id
    private long id;

    private String title;

    private int pageCount;

    private long authorId;

    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPageCount() {
        return pageCount;
    }

    public long getAuthorId() {
        return authorId;
    }
}
