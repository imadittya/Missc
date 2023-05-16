package com.wipro.TravelAgency.service;

import com.wipro.TravelAgency.entity.Booking;
import com.wipro.TravelAgency.entity.Route;
import com.wipro.TravelAgency.entity.User;
import com.wipro.TravelAgency.entity.Vehicle;
import com.wipro.TravelAgency.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class BookingService {

    @Autowired
    BookingRepository bookingRepository;

    public Booking getBookingById(long id) {
        Booking b1 = bookingRepository.findById(id).orElse(null);
        if (b1 == null) {
            return null;
        }
        return b1;
    }

    public List<Booking> getBookingByUserId(long id) {
        List<Booking> b2 = bookingRepository.getByUserId(id).orElse(null);
        if (b2 == null) {
            return null;
        }
        return b2;
    }

    public int seatReserved(String dateOfTravel, long vehicleId) {
        List<Booking> b3 = bookingRepository.getByDateAndVehicle(dateOfTravel, vehicleId).orElse(null);
        if (b3 == null) {
            return 0;
        } else {
            return b3.size();
        }
    }

    public boolean createBooking(Vehicle vehicle, Route route, User user, String dateOfTravel) {

        // check for seat availability
        if (vehicle.getNoOfSeats() - this.seatReserved(dateOfTravel, vehicle.getVehicleId()) <= 0) {
            return false;
        }

        // calculate Price of Travelling
        double totalPrice = vehicle.getPricePerKm() * route.getDistance();


        // create Booking
        Booking b4 = bookingRepository.save(new Booking(route, vehicle, user, totalPrice, dateOfTravel));
        if (b4 == null)
            return false;
        else
            return true;
    }

    public void cancelBooking(long bookingId){
        bookingRepository.delete(new Booking(bookingId));
    }

}
