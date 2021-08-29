package database;

import user.Passenger;

import java.util.HashMap;
import java.util.Map;

public class PassengerDataBase {
    Map<String , Passenger> database = new HashMap<>();

    public int getNumberOfPassenger() {
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
}
