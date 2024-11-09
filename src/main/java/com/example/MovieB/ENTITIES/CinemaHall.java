package com.example.MovieB.ENTITIES;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class CinemaHall {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String location;
    @OneToMany(mappedBy = "cinemaHall")
    List<Show> shows;
}
