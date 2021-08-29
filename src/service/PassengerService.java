package service;

import user.Passenger;

import java.util.List;

public interface PassengerService {
    void registerPassenger(Passenger passenger);
    Passenger findPassengerById(String id);
    List<Passenger> findPassengersByName(String name);
    void updatePassenger(Passenger passenger);
    void deletePassenger(Passenger passenger);

}
