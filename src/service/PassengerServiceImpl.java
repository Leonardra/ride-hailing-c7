package service;

import database.PassengerDataBase;
import exceptions.UserAlreadyExistException;
import exceptions.UserNotFoundException;
import user.Passenger;

import java.util.List;

public class PassengerServiceImpl implements PassengerService {

    private final PassengerDataBase passengerDataBase;


    public PassengerServiceImpl(){
        passengerDataBase = new PassengerDataBase();
    }

    @Override
    public void registerPassenger(Passenger passenger) throws UserAlreadyExistException{
        if(passengerDataBase.contains(passenger)){
            throw new UserAlreadyExistException("Passenger already exists");
        }
        passengerDataBase.save(passenger);
    }

    @Override
    public Passenger findPassenger(Passenger passenger) throws UserNotFoundException {
        return passengerDataBase.find(passenger);
    }

    @Override
    public Passenger findPassengerById(String id) throws UserNotFoundException {
        return passengerDataBase.findByPassengerId(id);
    }

    @Override
    public List<Passenger> findPassengersByName(String name) {
        return null;
    }

    @Override
    public void updatePassenger(Passenger passenger) {

    }

    @Override
    public void deletePassenger(Passenger passenger) {
        passengerDataBase.delete(passenger);
    }

    public long getNumberOfPassenger() {
        return passengerDataBase.getNumberOfPassenger();
    }
}
