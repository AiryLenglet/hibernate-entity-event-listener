package me.lenglet.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Book extends Aggregate{

    @Id
    private int id = 22;

    private String title;

    private String author;

    Book() {
    }

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
        this.addObjectToCreate(new Library("title", "author"));
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
