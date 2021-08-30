package user;

import java.util.Objects;

public class Passenger {

    private String passengerId;
    private String firstName;
    private String lastName;
    private String emailAddress;
    private String phoneNumber;
    private String password;

    public Passenger(String passengerId, String firstName, String lastName, String emailAddress,
                     String phoneNumber, String password) {
        this.passengerId = passengerId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailAddress = emailAddress;
        this.phoneNumber = phoneNumber;
        this.password = password;
    }

    public String getId() {
        return passengerId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Passenger)) return false;
        Passenger passenger = (Passenger) o;
        return Objects.equals(passengerId, passenger.passengerId) || Objects.equals(emailAddress, passenger.emailAddress) || Objects.equals(phoneNumber, passenger.phoneNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(passengerId, emailAddress, phoneNumber);
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public String getLastName() {
        return lastName;
    }
}
