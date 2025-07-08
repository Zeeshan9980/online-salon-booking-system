package com.example.Online_salon_booking_system.Service;

import com.example.Online_salon_booking_system.Entity.*;
import com.example.Online_salon_booking_system.Repository.BookingRepository;

import com.example.Online_salon_booking_system.Repository.SalonRepository;
import com.example.Online_salon_booking_system.Repository.ServiceRepository;
import com.example.Online_salon_booking_system.Repository.UserRepository;
import com.example.Online_salon_booking_system.Validation.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingService {
    @Autowired
    private BookingRepository bookingRepo;
    @Autowired
    private UserRepository userRepo;
    @Autowired
    private SalonRepository salonRepo;
    @Autowired
    private ServiceRepository serviceRepo;

    public Booking createBooking(BookingRequestDTO dto) {
        User user = userRepo.findById(dto.getUserId())
                .orElseThrow(() -> new ResourceNotFoundException("User not found with ID: " + dto.getUserId()));

        Salon salon = salonRepo.findById(dto.getSalonId())
                .orElseThrow(() -> new ResourceNotFoundException("Salon not found with ID: " + dto.getSalonId()));

        com.example.Online_salon_booking_system.Entity.Service service = serviceRepo.findById(dto.getServiceId())
                .orElseThrow(() -> new ResourceNotFoundException("Service not found with ID: " + dto.getServiceId()));

        Booking booking = new Booking();
        booking.setUser(user);
        booking.setSalon(salon);
        booking.setService(service);
        booking.setBookingtime(dto.getBookingTime());
        booking.setStatus(BookingStatus.BOOKED);

        return bookingRepo.save(booking);
    }

    public List<Booking> getUserBookings(Long userId) {
        if (!userRepo.existsById(userId)) {
            throw new ResourceNotFoundException("User not found with ID: " + userId);
        }

        return bookingRepo.findByUserId(userId);
    }

    public Booking updateBooking(Long bookingId, BookingRequestDTO dto) {
        Booking existingBooking = bookingRepo.findById(bookingId)
                .orElseThrow(() -> new ResourceNotFoundException("Booking not found with ID: " + bookingId));

        User user = userRepo.findById(dto.getUserId())
                .orElseThrow(() -> new ResourceNotFoundException("User not found with ID: " + dto.getUserId()));

        Salon salon = salonRepo.findById(dto.getSalonId())
                .orElseThrow(() -> new ResourceNotFoundException("Salon not found with ID: " + dto.getSalonId()));

        com.example.Online_salon_booking_system.Entity.Service service = serviceRepo.findById(dto.getServiceId())
                .orElseThrow(() -> new ResourceNotFoundException("Service not found with ID: " + dto.getServiceId()));

        existingBooking.setUser(user);
        existingBooking.setSalon(salon);
        existingBooking.setService(service);
        existingBooking.setBookingTime(dto.getBookingTime());

        return bookingRepo.save(existingBooking);
    }

    public void deleteBooking(Long bookingId) {
        Booking booking = bookingRepo.findById(bookingId)
                .orElseThrow(() -> new ResourceNotFoundException("Booking not found with ID: " + bookingId));

        bookingRepo.delete(booking);
    }
}

