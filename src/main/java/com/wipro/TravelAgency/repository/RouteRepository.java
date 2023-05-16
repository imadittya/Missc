package com.wipro.TravelAgency.repository;

import com.wipro.TravelAgency.entity.Route;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RouteRepository extends JpaRepository<Route, Long> {

    @Query("FROM Route where source =?1 and destination =?2")
    List<Route> routeListBySourceAndDestination(String source, String destination);
}
