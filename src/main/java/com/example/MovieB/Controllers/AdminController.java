package com.example.MovieB.Controllers;

import com.example.MovieB.ENTITIES.*;
import com.example.MovieB.Services.AdminService;
import com.example.MovieB.Services.KafkaProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    AdminService adminService;

    @Autowired
    KafkaProducerService kafkaProducerService;

    @PostMapping("/addCinemaHall")
    public ResponseEntity<CinemaHall> addCinemaHall(@RequestBody CinemaHall cinemaHall) {
        CinemaHall savedCinemaHall = adminService.addCinemaHall(cinemaHall);
        kafkaProducerService.sendMessage("cinemaHallTopic", savedCinemaHall);
        return ResponseEntity.ok().body(savedCinemaHall);
    }

    @PostMapping("/addShow")
    public ResponseEntity<Show> addShow(@RequestBody ShowRequest showRequest) {
        return ResponseEntity.ok().body(adminService.addShow(showRequest.getShow(), showRequest.getShowSeats()));
    }

}
