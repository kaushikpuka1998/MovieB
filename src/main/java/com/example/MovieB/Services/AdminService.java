package com.example.MovieB.Services;

import com.example.MovieB.ENTITIES.CinemaHall;
import com.example.MovieB.ENTITIES.Show;
import com.example.MovieB.ENTITIES.ShowSeat;
import com.example.MovieB.REPOSITORY.ShowRepository;
import com.example.MovieB.REPOSITORY.ShowSeatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService {

    @Autowired
    ShowService showService;

    @Autowired
    CinemaHallService cinemaHallService;


    public Show addShow(Show show, List<ShowSeat> showSeats) {
        if (show.getCinemaHall().getId() == null) {
            CinemaHall savedCinemaHall = cinemaHallService.addCinemaHall(show.getCinemaHall());
            show.setCinemaHall(savedCinemaHall);
        }
        return showService.addShow(show, showSeats);
    }

    public Show updateShow(Show show, List<ShowSeat> showSeats) {
        return showService.updateShow(show, showSeats);
    }

    public void deleteShow(Long showId) {
        showService.deleteShow(showId);
    }

    public CinemaHall addCinemaHall(CinemaHall cinemaHall) {
        return cinemaHallService.addCinemaHall(cinemaHall);
    }

    public void removeCinemaHall(CinemaHall cinemaHall) {
        cinemaHallService.removeCinemaHall(cinemaHall);
    }

    public void updateCinemaHall(CinemaHall cinemaHall) {
        cinemaHallService.updateCinemaHall(cinemaHall);
    }

    public CinemaHall getCinemaHall(Long id) {
        return cinemaHallService.getCinemaHall(id);
    }

}
