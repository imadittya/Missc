package com.wipro.TravelAgency.service;

import com.wipro.TravelAgency.entity.Vehicle;
import com.wipro.TravelAgency.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class VehicleService {

    @Autowired
    VehicleRepository vehicleRepository;

    public int seatCapacity(long id){
       Vehicle v =  vehicleRepository.findById(id).orElse(null);
       if(v == null){
           return -1;
       }
       return v.getNoOfSeats();
    }
}
