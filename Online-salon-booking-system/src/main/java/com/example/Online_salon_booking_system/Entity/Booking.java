package com.example.Online_salon_booking_system.Entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime bookingtime;
    private BookingStatus status;
    @ManyToOne
    private User user;
    @ManyToOne
    private Salon salon;
    @ManyToOne
    private Service service;


    public Booking(Long id, LocalDateTime bookingtime, BookingStatus status, User user, Salon salon, Service service) {
        this.id = id;
        this.bookingtime = bookingtime;
        this.status = status;
        this.user = user;
        this.salon = salon;
        this.service = service;
    }

    public Booking() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getBookingtime() {
        return bookingtime;
    }

    public void setBookingtime(LocalDateTime bookingtime) {
        this.bookingtime = bookingtime;
    }

    public BookingStatus getStatus() {
        return status;
    }

    public void setStatus(BookingStatus status) {
        this.status = status;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Salon getSalon() {
        return salon;
    }

    public void setSalon(Salon salon) {
        this.salon = salon;
    }

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }

    public void setBookingTime(LocalDateTime bookingTime) {
    }
}

