package user;

import exceptions.UserAlreadyExistException;
import exceptions.UserNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import service.PassengerServiceImpl;

import static org.junit.jupiter.api.Assertions.*;

class PassengerTest {

    PassengerServiceImpl passengerServiceImpl;
    Passenger passenger1;
    Passenger passenger2;
    @BeforeEach
    void setUp() {
        passengerServiceImpl = new PassengerServiceImpl();
        passenger1 = new Passenger("1",
                "Oluwatobi",
                "Jolayemi",
                "tobi@gmail.com",
                "08166863770",
                "myPassword");
        passenger2 = new Passenger("2",
                "Janet",
                "Ishola",
                "janet@gmail.com",
                "08166863551",
                "noPassword");
    }

    @Test
    @DisplayName("Create Passenger")
    void  thatUserCanBeCreated(){
        //given
        try {
            passengerServiceImpl.registerPassenger(passenger1);
            passengerServiceImpl.registerPassenger(passenger2);
        } catch (UserAlreadyExistException userAlreadyExistException) {
            System.err.printf("%s:", userAlreadyExistException.getLocalizedMessage());
        }
        assertEquals(2, passengerServiceImpl.getNumberOfPassenger());
    }

    @Test
    @DisplayName("Passenger Already Exists Test")
    void thatPassengerCannotBeRegisteredTwice(){
        Passenger passenger3 = new Passenger("1",
                "Oluwatosin",
                "Jolayemi",
                "tobi@gmail.com",
                "08166863770",
                "myPassword");
        try {
            passengerServiceImpl.registerPassenger(passenger1);
            passengerServiceImpl.registerPassenger(passenger2);
        } catch (UserAlreadyExistException userAlreadyExistException) {
            System.err.printf("%s:", userAlreadyExistException.getLocalizedMessage());
        }
        UserAlreadyExistException exception = assertThrows(
                UserAlreadyExistException.class,
                () ->passengerServiceImpl.registerPassenger(passenger3));
        assertEquals(2, passengerServiceImpl.getNumberOfPassenger());
        assertEquals("Passenger already exists",
                exception.getLocalizedMessage());

    }

    @Test
    @DisplayName("Find Passenger")
    void thatPassengerCanBeFound() {
        //given
        try {
            passengerServiceImpl.registerPassenger(passenger1);
            passengerServiceImpl.registerPassenger(passenger2);
        } catch (UserAlreadyExistException userAlreadyExistException) {
            System.err.printf("%s:", userAlreadyExistException.getLocalizedMessage());
        }
        assertEquals(2, passengerServiceImpl.getNumberOfPassenger());
        Passenger found = null;
        try {
            found = passengerServiceImpl.findPassenger(passenger2);
        } catch (UserNotFoundException exception) {
            exception.printStackTrace();
        }
        assertNotNull(found);
        assertEquals("janet@gmail.com", found.getEmailAddress());

    }

    @Test
    @DisplayName("User Not Found Exception")
    void thatUserNotFoundExceptionCanBeThrown(){
        UserNotFoundException exception = assertThrows(UserNotFoundException.class,
                ()->passengerServiceImpl.findPassenger(passenger2));
        assertEquals("Passenger not found", exception.getLocalizedMessage());

    }

    @Test
    @DisplayName("Find Passenger By Id")
    void thatPassengerCanBeFoundById(){
        try {
            passengerServiceImpl.registerPassenger(passenger1);
            passengerServiceImpl.registerPassenger(passenger2);
        } catch (UserAlreadyExistException userAlreadyExistException) {
            System.err.printf("%s:", userAlreadyExistException.getLocalizedMessage());
        }
        assertEquals(2, passengerServiceImpl.getNumberOfPassenger());
        Passenger found = null;
        try {
            found = passengerServiceImpl.findPassengerById("1");
        } catch (UserNotFoundException e) {
            System.err.printf("%s:", e.getLocalizedMessage());
        }
        assertEquals("Jolayemi", found.getLastName());

    }

    @Test
    @DisplayName("Delete Passenger")
    void thatUserCanBeDeleted() throws UserAlreadyExistException{
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