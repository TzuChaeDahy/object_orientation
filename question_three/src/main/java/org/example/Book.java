package org.example;

import java.lang.Integer;
import java.time.LocalDate;

public class Book {
    private String isbn;
    private String title;
    private String author;
    private String publisher;
    private Integer publishYear;

    public Book(String isbn, String title, String author, String publisher,  Integer publishYear) throws Exception {
        if (isbn == null || isbn.isEmpty()) {
            throw new Exception("ISBN inválido!");
        }
        this.isbn = isbn;

        if (title == null || title.isEmpty()) {
            throw new Exception("Titulo inválido!");
        }
        this.title = title;

        if (author == null || author.isEmpty()) {
            throw new Exception("Autor inválido!");
        }
        this.author = author;

        if (publisher == null || publisher.isEmpty()) {
            throw new Exception("Editora inválida!");
        }
        this.publisher = publisher;

        if (publishYear > LocalDate.now().getYear()) {
            throw new Exception("Data inválida!");
        }
        this.publishYear = publishYear;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public Integer getPublishYear() {
        return publishYear;
    }

    public String getPublisher() {
        return publisher;
    }
}
