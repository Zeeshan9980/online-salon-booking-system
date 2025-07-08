package com.example.Online_salon_booking_system.Repository;

import com.example.Online_salon_booking_system.Entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookingRepository extends JpaRepository<Booking,Long> {
    List<Booking> findByUserId(Long userId);
}
