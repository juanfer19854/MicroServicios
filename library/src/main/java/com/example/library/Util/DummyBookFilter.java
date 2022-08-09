package com.example.library.Util;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

import com.example.library.Library.Book;
import com.example.library.service.BookService;

@Component
public class DummyBookFilter {
    private final BookService bookService;

    public DummyBookFilter(BookService bookService) {
        this.bookService = bookService;
    }

    //con la instrucción @PostConstruct se ejecuta este metodo durante el inicio y luego del constructor
    @PostConstruct
    public void init()
    {
        bookService.addBook(new Book(null, "El señor de los anillos", "Libro medieval", "XX1", "50", 30));
        try{Thread.sleep(100);}catch(InterruptedException e) {}
        bookService.addBook(new Book(null, "El patron del mal", "Novela", "XX2", "30", 100));
        try{Thread.sleep(100);}catch(InterruptedException e) {}
        bookService.addBook(new Book(null, "Apolo 11", "Ficcion", "XX3", "80", 10));

    }
    
}
