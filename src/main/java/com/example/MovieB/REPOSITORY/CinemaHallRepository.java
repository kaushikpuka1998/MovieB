package com.example.MovieB.REPOSITORY;

import com.example.MovieB.ENTITIES.CinemaHall;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CinemaHallRepository extends JpaRepository<CinemaHall, Long> {

    public CinemaHall findByName(String name);

    public CinemaHall save(CinemaHall cinemaHall);

    public void delete(CinemaHall cinemaHall);
}
