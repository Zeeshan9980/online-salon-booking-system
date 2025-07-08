package com.example.Online_salon_booking_system.Repository;

import com.example.Online_salon_booking_system.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long> {
    Optional<User> findByEmail(String email);
}

