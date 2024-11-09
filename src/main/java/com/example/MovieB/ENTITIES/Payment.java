package com.example.MovieB.ENTITIES;

import jakarta.persistence.*;

@Entity
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private PaymentMode mode;
    private double amount;

    @OneToOne
    @JoinColumn(name = "booking_id")
    private Booking booking;
}
