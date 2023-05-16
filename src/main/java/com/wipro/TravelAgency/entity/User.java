package com.wipro.TravelAgency.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    private long userName;

    private String name;

    private String email;

    private int age;

    private String password;
    @OneToMany(mappedBy = "user")
    private List<Booking> bookings;

    private String session = "inactive";


    public User(String name, String email, int age, String password) {
        this.name = name;
        this.email = email;
        this.age = age;
        this.password = password;
    }

}
