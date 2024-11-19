package com.example.MovieB.ENTITIES;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class CinemaHall {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String location;
    @OneToMany(mappedBy = "cinemaHall")
    List<Show> shows;
}
