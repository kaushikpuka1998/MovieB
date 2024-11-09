package com.example.MovieB.ENTITIES;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String genre;
    private String description;

    @OneToMany(mappedBy = "movie")
    List<Show> shows;
}
