package com.example.BookService.controllers;

import com.example.BookService.entities.Author;
import com.example.BookService.entities.Book;
import com.example.BookService.entities.Genre;
import com.example.BookService.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping("/books")
    public List<Book> showAllBooks() {
        return bookService.getAllBooks();
    }

    @PostMapping("/books")
    public Book postBook(@RequestBody Book book) {
        return bookService.addBook(book);
    }

    @PostMapping("/genre")
    public Genre postGenre(@RequestBody Genre genre) {
        return bookService.addGenre(genre);
    }

    @PostMapping("/author")
    public Author postAuthor(@RequestBody Author author) {
        return bookService.addAuthor(author);
    }
}
