package com.example.Online_salon_booking_system.Entity;

import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public class BookingRequestDTO {
    @NotNull
    private Long userId;

    @NotNull
    private Long salonId;

    @NotNull
    private Long serviceId;

    @NotNull
    private LocalDateTime bookingTime;


    public BookingRequestDTO(Long userId, Long salonId, Long serviceId, LocalDateTime bookingTime) {
        this.userId = userId;
        this.salonId = salonId;
        this.serviceId = serviceId;
        this.bookingTime = bookingTime;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getSalonId() {
        return salonId;
    }

    public void setSalonId(Long salonId) {
        this.salonId = salonId;
    }

    public Long getServiceId() {
        return serviceId;
    }

    public void setServiceId(Long serviceId) {
        this.serviceId = serviceId;
    }

    public LocalDateTime getBookingTime() {
        return bookingTime;
    }

    public void setBookingTime(LocalDateTime bookingTime) {
        this.bookingTime = bookingTime;
    }
}

