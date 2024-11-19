package com.example.MovieB.Services;

import com.example.MovieB.ENTITIES.Booking;
import com.example.MovieB.ENTITIES.Show;
import com.example.MovieB.ENTITIES.ShowSeat;
import com.example.MovieB.REPOSITORY.BookingRepository;
import com.example.MovieB.REPOSITORY.ShowRepository;
import com.example.MovieB.REPOSITORY.ShowSeatRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Bookingservice {

    @Autowired
    private ShowRepository showRepository;

    @Autowired
    private ShowSeatRepository showSeatRepository;

    @Autowired
    private BookingRepository bookingRepository;

    @Transactional
    public Booking bookSeats(List<Long> seatIds){
        //logic to book seats
        Booking booking = new Booking();
        List<ShowSeat> seats = showSeatRepository.findAllById(seatIds);
        for (ShowSeat seat : seats) {
            if (!seat.isAvailable()) {
                throw new RuntimeException("Seat " + seat.getSeatNumber() + " is already booked");
            }
            seat.setAvailable(false);
            seat.setBooking(booking);
        }
        booking.setShowSeats(seats);
        return bookingRepository.save(booking);

    }

    @Transactional
    public void cancelBooking(Long bookingId){
        //logic to cancel booking
        Booking booking = bookingRepository.findById(bookingId).get();
        List<ShowSeat> seats = booking.getShowSeats();
        for (ShowSeat seat : seats) {
            seat.setAvailable(true);
            seat.setBooking(null);
        }
        bookingRepository.delete(booking);
    }
}
