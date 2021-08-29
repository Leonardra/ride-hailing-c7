package user;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import service.PassengerServiceImpl;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PassengerTest {

    PassengerServiceImpl passengerServiceImpl;
    @BeforeEach
    void setUp() {
        passengerServiceImpl = new PassengerServiceImpl();
    }

    @Test
    @DisplayName("Create Passenger")
    void  thatUserCanBeCreated(){
        //given
        Passenger passenger1 = new Passenger("1",
                "Oluwatobi",
                "Jolayemi",
                "tobi@gmail.com",
                "08166863770",
                "myPassword");
        Passenger passenger2 = new Passenger("2",
                "Janet",
                "Ishola",
                "janet@gmail.com",
                "08166863551",
                "noPassword");

        passengerServiceImpl.registerPassenger(passenger1);
        passengerServiceImpl.registerPassenger(passenger2);
        assertEquals(2, passengerServiceImpl.getNumberOfPassenger());
    }

    @Test
    @DisplayName("Delete Passenger")
    void thatUserCanBeDeleted(){
        //given
        Passenger passenger1 = new Passenger("1",
                "Oluwatobi",
                "Jolayemi",
                "tobi@gmail.com",
                "08166863770",
                "myPassword");
        Passenger passenger2 = new Passenger("2",
                "Janet",
                "Ishola",
                "janet@gmail.com",
                "08166863551",
                "noPassword");

        passengerServiceImpl.registerPassenger(passenger1);
        passengerServiceImpl.registerPassenger(passenger2);
        passengerServiceImpl.deletePassenger(passenger2);
        assertEquals(1, passengerServiceImpl.getNumberOfPassenger());
    }
}