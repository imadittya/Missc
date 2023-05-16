package com.wipro.TravelAgency.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long bookingId;
    @OneToOne
    private Route route;
    @OneToOne
    private Vehicle vehicle;
    @ManyToOne
    private User user;
    private double totalPrice;
    private boolean bookingStatus;
    private String dateOfTravel;

    public Booking(Route route, Vehicle vehicle, User user, double totalPrice, String dateOfTravel) {
        this.route = route;
        this.vehicle = vehicle;
        this.user = user;
        this.totalPrice = totalPrice;
        this.dateOfTravel = dateOfTravel;
        this.bookingStatus = false;
    }

    public Booking(long bookingId){
        this.bookingId = bookingId;
    }

}
