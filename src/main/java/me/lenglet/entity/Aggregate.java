package me.lenglet.entity;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import javax.persistence.Transient;
import java.util.LinkedList;
import java.util.Queue;

@MappedSuperclass
public class Aggregate {

    private transient Queue<Object> objectsToCreate = new LinkedList<>();

    public Object pollObjectToCreate() {
        return this.objectsToCreate.poll();
    }

    protected void addObjectToCreate(Object object) {
        this.objectsToCreate.add(object);
    }
}
