package database;

import exceptions.UserNotFoundException;
import user.Passenger;

import java.util.HashMap;
import java.util.Map;

public class PassengerDataBase {
    private final Map<String , Passenger> database;

    public PassengerDataBase(){
        database = new HashMap<>();
    }

    public long getNumberOfPassenger() {
        return database.size();
    }

    public void save(Passenger passenger) {
        database.put(passenger.getId(), passenger);
    }

    public void delete(Passenger passenger) {
        if(database.containsValue(passenger)){
        database.remove(passenger.getId());
        }
    }

    public boolean contains(Passenger passenger) {
        return database.containsValue(passenger);
    }

    public Passenger find(Passenger passenger) throws UserNotFoundException {
        Passenger foundPassenger = null;
       for(Passenger p: database.values()){
           if(p.equals(passenger)){
               foundPassenger = p;
           }
       }
       if(foundPassenger == null){
           throw new UserNotFoundException("Passenger not found");
       }
       return foundPassenger;
    }

    public Passenger findByPassengerId(String passengerId) throws UserNotFoundException {
       if(!database.containsKey(passengerId)){
           throw new UserNotFoundException("Passenger not found");
       }
       return database.get(passengerId);
    }
}
