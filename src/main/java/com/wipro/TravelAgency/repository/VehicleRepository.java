package com.wipro.TravelAgency.repository;

import com.wipro.TravelAgency.entity.Vehicle;
import com.wipro.TravelAgency.service.VehicleService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle, Long> {

    
}
