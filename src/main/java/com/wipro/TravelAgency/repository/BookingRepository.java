package com.wipro.TravelAgency.repository;

import com.wipro.TravelAgency.entity.Booking;
import com.wipro.TravelAgency.entity.Route;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {
    @Query("from Booking where user.id = ?1")
    Optional<List<Booking>> getByUserId(long id);

    @Query("FROM Booking where dateOfTravel =?1 and vehicle.Id =?2")
    Optional<List<Booking>> getByDateAndVehicle(String dateOfTravel, long vehicleId);
}
