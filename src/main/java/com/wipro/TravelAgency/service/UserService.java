package com.wipro.TravelAgency.service;

import com.wipro.TravelAgency.entity.User;
import com.wipro.TravelAgency.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public String CreateUser(String name, String email, int age, String password){
        userRepository.save(new User(name, email, age, password));
                return "User Created";
    }
}
