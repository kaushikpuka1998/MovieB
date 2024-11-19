package com.example.MovieB.Controllers;

import com.example.MovieB.ENTITIES.*;
import com.example.MovieB.Services.AdminService;
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

    @PostMapping("/addCinemaHall")
    public ResponseEntity<CinemaHall> addCinemaHall(@RequestBody CinemaHall cinemaHall) {
        return ResponseEntity.ok().body( adminService.addCinemaHall(cinemaHall));
    }

    @PostMapping("/addShow")
    public ResponseEntity<Show> addShow(@RequestBody ShowRequest showRequest) {
        return ResponseEntity.ok().body(adminService.addShow(showRequest.getShow(), showRequest.getShowSeats()));
    }

}
