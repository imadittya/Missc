package com.wipro.TravelAgency.repository;

import com.wipro.TravelAgency.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
    public List<User> findUserByName(String userName);
}
