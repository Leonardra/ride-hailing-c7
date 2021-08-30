package service;

import exceptions.UserAlreadyExistException;
import exceptions.UserNotFoundException;
import user.Passenger;

import java.util.List;

public interface PassengerService {
    void registerPassenger(Passenger passenger) throws UserAlreadyExistException;
    Passenger findPassenger(Passenger passenger) throws UserNotFoundException;
    Passenger findPassengerById(String id) throws UserNotFoundException;
    List<Passenger> findPassengersByName(String name);
    void updatePassenger(Passenger passenger);
    void deletePassenger(Passenger passenger);

}
