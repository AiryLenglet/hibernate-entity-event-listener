package me.lenglet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.LockModeType;

@RestController
public class Controller {

    @Autowired
    private BookService bookService;

    @GetMapping
    void test() {
        this.bookService.createBook();
    }

}
