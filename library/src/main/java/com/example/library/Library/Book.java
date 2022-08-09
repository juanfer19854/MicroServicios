package com.example.library.Library;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public @Data class Book {
    private String bookId;
    private String title;
    private String descripcion;
    private String author;
    private String price;
    private int qty;
    public Book(String bookId, String title, String descripcion, String author, String price, int qty) {
        this.bookId = bookId;
        this.title = title;
        this.descripcion = descripcion;
        this.author = author;
        this.price = price;
        this.qty = qty;
    }

    
    
}
