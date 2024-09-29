package com.example.BookService.services;

import com.example.BookService.entities.Author;
import com.example.BookService.entities.Book;
import com.example.BookService.entities.Genre;
import com.example.BookService.repositories.AuthorRepository;
import com.example.BookService.repositories.BookRepository;
import com.example.BookService.repositories.GenreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Autowired
    BookRepository bookRepository;
    @Autowired
    GenreRepository genreRepository;
    @Autowired
    AuthorRepository authorRepository;

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public Book addBook(Book book) {
        Author bookAuthor = authorRepository.findById(book.getAuthor().getId()).orElseThrow(()-> new RuntimeException("no author"));
        Genre bookGenre = genreRepository.findById(book.getGenre().getId()).orElseThrow(()-> new RuntimeException("no genre"));

        Book newBook = new Book();
        newBook.setId(book.getId());
        newBook.setDescription(book.getDescription());
        newBook.setPrice(book.getPrice());
        newBook.setTitle(book.getTitle());
        newBook.setAuthor(bookAuthor);
        newBook.setGenre(bookGenre);

        return bookRepository.saveAndFlush(newBook);
    }

    public Genre addGenre(Genre genre) {
        return genreRepository.saveAndFlush(genre);
    }

    public Author addAuthor(Author author) {
        return authorRepository.saveAndFlush(author);
    }
}
