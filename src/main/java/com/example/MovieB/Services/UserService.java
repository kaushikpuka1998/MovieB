package com.example.MovieB.Services;

import com.example.MovieB.ENTITIES.Booking;
import com.example.MovieB.ENTITIES.User;
import com.example.MovieB.REPOSITORY.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public void addUser(User user) {
        userRepository.save(user);
    }

    public void removeUser(User user) {
        userRepository.delete(user);
    }

    public void updateUser(User user) {
        userRepository.save(user);
    }

    public Optional<User> getUser(Long id) {
        return userRepository.findById(id);
    }

    public List<Booking> getBookings(Long userId) {
        return userRepository.findById(userId).get().getBookings();
    }
}
