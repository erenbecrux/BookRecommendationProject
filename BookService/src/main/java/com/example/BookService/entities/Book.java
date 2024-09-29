package com.example.BookService.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Book")
@Data
public class Book {

    @Id
    @GeneratedValue
    private int id;

    private String title;
    private String description;
    private float price;

    @ManyToOne
    private Author author;

    @ManyToOne
    private Genre genre;

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public float getPrice() {
        return price;
    }

    public Author getAuthor() {
        return author;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
