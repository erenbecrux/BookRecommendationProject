package com.example.BookService.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "Genre")
@Data
public class Genre {

    @Id
    @GeneratedValue
    private int id;

    private String genre;

    public Genre() {}
    public Genre(String genre) {
        this.genre =genre;
    }
    public int getId() {
        return id;
    }

    public String getGenre() {
        return genre;
    }
}
