package com.example.MovieB.REPOSITORY;

import com.example.MovieB.ENTITIES.Show;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShowRepository extends JpaRepository<Show, Long> {
}
