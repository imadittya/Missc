package com.wipro.TravelAgency.service;

import com.wipro.TravelAgency.entity.Route;
import com.wipro.TravelAgency.entity.Vehicle;
import com.wipro.TravelAgency.repository.RouteRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class RouteService {

    @Autowired
    RouteRepository routeRepository;

    public List<Vehicle> routeListBySourceAndDestination(String source, String destination){
        Route r = routeRepository.routeListBySourceAndDestination(source, destination).get(0);
        return r.getVehicleList();
    }
}
