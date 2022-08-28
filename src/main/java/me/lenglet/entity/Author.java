package me.lenglet.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Author {

    @Id
    private int id = 22;

    private String name;

    Author() {
    }

    public Author(String name) {
        this.name = name;
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
}
