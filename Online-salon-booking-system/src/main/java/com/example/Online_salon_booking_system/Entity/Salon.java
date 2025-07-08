package com.example.Online_salon_booking_system.Entity;

import jakarta.persistence.*;

@Entity
public class Salon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String address;
    private String contactnumber;
    @ManyToOne
    @JoinColumn(name="owner_id")
    private User owner;

    public Salon(Long id, String name, String address, String contactnumber, User owner) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.contactnumber = contactnumber;
        this.owner = owner;
    }

    public Salon() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContactnumber() {
        return contactnumber;
    }

    public void setContactnumber(String contactnumber) {
        this.contactnumber = contactnumber;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }
}
