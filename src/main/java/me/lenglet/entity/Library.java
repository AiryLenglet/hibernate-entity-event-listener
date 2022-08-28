package me.lenglet.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Library extends Aggregate{

    @Id
    private int id = 22;

    private String title;

    private String author;

    Library() {
    }

    public Library(String title, String author) {
        this.title = title;
        this.author = author;
        this.addObjectToCreate(new Author("author"));
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
