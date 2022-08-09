package com.example.library.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import com.example.library.Library.Book;

@Repository
public class MemoryBookRepository implements BookRepository {
    private Map<String, Book> booksmap;

    

    public MemoryBookRepository() {
        booksmap = new HashMap<>();
    }

    @Override
    public List<Book> getAll() {
        // TODO Auto-generated method stub
        List<Book> books = new ArrayList<>();
        books.addAll(booksmap.values());
        return books;
    }

    @Override
    public Book get(String bookid) {
        // TODO Auto-generated method stub
        return booksmap.get(bookid);
       
    }

    @Override
    public List<Book> findByAuthor(String author) {
        //Metodo 1 ojo que es menos optimo
        //List<Book> ret = new ArrayList<>();
        //for (Book book : booksmap.values()) {
            // valido existencia de parte de la cadena ingresada
            //if (book.getAuthor().indexOf(author) >= 0) {
               // ret.add(book);
            //}
        //}
        //return ret;

            //metodo 2 optimizado
        return booksmap.values().stream()
        .filter(book -> book.getAuthor().toLowerCase().indexOf(author.toLowerCase())>= 0)
        .collect(Collectors.toList());
    }


    @Override
    public List<Book> findByTitle(String title) {
        // TODO Auto-generated method stub
        return booksmap.values().stream()
        .filter(book -> book.getTitle().toLowerCase().indexOf(title.toLowerCase())>= 0)
        .collect(Collectors.toList());
    }

    @Override
    public Book save(Book book) {
        // TODO Auto-generated method stub
        if(book.getBookId() == null) {
            book.setBookId(String.valueOf(System.currentTimeMillis()));
        }
        booksmap.put(book.getBookId(), book);
        return book;
    }

    @Override
    public Book delete(String bookId) {
        return booksmap.remove(bookId);
        
    }

   

    
    
    
}
