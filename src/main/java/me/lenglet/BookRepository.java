package me.lenglet;

import me.lenglet.entity.Book;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Service
@Transactional
public class BookRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public void persist(Book book) {
        this.entityManager.persist(book);
    }
}
