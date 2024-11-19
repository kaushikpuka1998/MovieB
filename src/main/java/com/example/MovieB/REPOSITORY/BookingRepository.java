package com.example.MovieB.REPOSITORY;

import com.example.MovieB.ENTITIES.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {
    public Booking save(Booking booking);
    public Optional<Booking> findById(Long id);
}
