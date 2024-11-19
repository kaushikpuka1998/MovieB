package com.example.MovieB.ENTITIES;

import lombok.Data;

import java.util.List;

@Data
public class ShowRequest {
    private Show show;
    private List<ShowSeat> showSeats;
}
