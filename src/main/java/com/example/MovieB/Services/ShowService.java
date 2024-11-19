package com.example.MovieB.Services;

import com.example.MovieB.ENTITIES.Show;
import com.example.MovieB.ENTITIES.ShowSeat;
import com.example.MovieB.REPOSITORY.ShowRepository;
import com.example.MovieB.REPOSITORY.ShowSeatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShowService {
    @Autowired
    private ShowRepository showRepository;

    @Autowired
    private ShowSeatRepository showSeatRepository;

    public Show addShow(Show show, List<ShowSeat> showSeats) {
        Show savedShow = showRepository.save(show);
        for (ShowSeat seat : showSeats) {
            seat.setShow(savedShow);
            showSeatRepository.save(seat);
        }
        return savedShow;
    }

    public Show updateShow(Show show, List<ShowSeat> showSeats) {
        Show savedShow = showRepository.save(show);
        for (ShowSeat seat : showSeats) {
            seat.setShow(savedShow);
            showSeatRepository.save(seat);
        }
        return savedShow;
    }

    public void deleteShow(Long showId) {
        showRepository.deleteById(showId);
    }
}
