package service;

import database.PassengerDataBase;
import service.PassengerService;
import user.Passenger;

import java.util.List;

public class PassengerServiceImpl implements PassengerService {

    private PassengerDataBase passengerDataBase = new PassengerDataBase();

    @Override
    public void registerPassenger(Passenger passenger) {
        passengerDataBase.save(passenger);
    }

    @Override
    public Passenger findPassengerById(String id) {
        return null;
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

    public int getNumberOfPassenger() {
        return passengerDataBase.getNumberOfPassenger();
    }
}
