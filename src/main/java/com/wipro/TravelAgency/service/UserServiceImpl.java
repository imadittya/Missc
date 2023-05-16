package com.wipro.TravelAgency.service;

import com.wipro.TravelAgency.entity.User;
import com.wipro.TravelAgency.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepo;


    public User createUser(User user) {
        // TODO Auto-generated method stub
        return userRepo.save(user);
    }


    public boolean deleteUser(String userName) {
        // TODO Auto-generated method stub
        boolean response = false;
        User user = findUserByUserName(userName);
        if(user != null)
        {
            userRepo.delete(user);
            response =  true;
        }
        return response;
    }


    public User updateUser(User user) {
        // TODO Auto-generated method stub
        return userRepo.save(user);
    }


    public User findUserByUserName(String userName) {
        // TODO Auto-generated method stub
        return userRepo.findById(userName).orElse(null);
    }


    public List<User> findAllUsers() {
        // TODO Auto-generated method stub
        return userRepo.findAll();
    }


    public List<User> findUserByName(String name) {
        // TODO Auto-generated method stub
        return userRepo.findUserByName(name);
    }


    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // TODO Auto-generated method stub
        User user = findUserByUserName(username);
        return new org.springframework.security.core.userdetails.User(user.getName(), user.getPassword(), new ArrayList<>());
    }


    public void createUserSession(String userName) {
        // TODO Auto-generated method stub
        User user = findUserByUserName(userName);
        user.setSession("active");
        userRepo.save(user);
    }


    public void removeUserSession(String userName) {
        // TODO Auto-generated method stub
        User user = findUserByUserName(userName);
        user.setSession("inactive");
        userRepo.save(user);

    }


    public String getUserSession(String userName) {
        // TODO Auto-generated method stub
        User user = findUserByUserName(userName);
        return user.getSession();
    }



}
