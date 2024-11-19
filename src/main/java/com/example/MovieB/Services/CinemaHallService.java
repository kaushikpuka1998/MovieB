package com.example.MovieB.Services;

import com.example.MovieB.ENTITIES.CinemaHall;
import com.example.MovieB.REPOSITORY.CinemaHallRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CinemaHallService {

    @Autowired
    CinemaHallRepository cinemaHallRepository;

    public CinemaHall addCinemaHall(CinemaHall cinemaHall) {
        return cinemaHallRepository.save(cinemaHall);
    }

    public void removeCinemaHall(CinemaHall cinemaHall) {
        cinemaHallRepository.delete(cinemaHall);
    }

    public void updateCinemaHall(CinemaHall cinemaHall) {
        cinemaHallRepository.save(cinemaHall);
    }

    public CinemaHall getCinemaHall(Long id) {
        return cinemaHallRepository.findById(id).get();
    }

    public CinemaHall getCinemaHallByName(String name) {
        return cinemaHallRepository.findByName(name);
    }
}
