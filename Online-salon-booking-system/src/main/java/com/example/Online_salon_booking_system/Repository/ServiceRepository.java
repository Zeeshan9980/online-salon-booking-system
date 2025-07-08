package com.example.Online_salon_booking_system.Repository;

import com.example.Online_salon_booking_system.Entity.Service;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServiceRepository extends JpaRepository<Service,Long> {
}
