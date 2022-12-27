package com.kjipo.graphqlExample;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Book {

    @Id
    private long id;

    private String title;

    private int pageCount;

    @ManyToOne
    @JoinColumn(name = "authorId")
    private Author author;

    public Book() {
    }

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

    public Author getAuthor() {
        return author;
    }
}
