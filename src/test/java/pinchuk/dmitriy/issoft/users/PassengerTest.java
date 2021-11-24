package pinchuk.dmitriy.issoft.users;

import org.junit.jupiter.api.Test;
import pinchuk.dmitriy.issoft.domain.users.Passenger;
import pinchuk.dmitriy.issoft.users.samples.PassengerSamples;

import static junit.framework.Assert.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class PassengerTest {

    @Test
    void createValidPassenger() {
        Passenger passenger = PassengerSamples.anyValidPassenger();
        assertNotNull(passenger.getId());
        assertNotNull(passenger.getUsername());
        assertNotNull(passenger.getTicket());
    }

    @Test
    void createPassengerWithoutTicket() {
        assertThrows(IllegalArgumentException.class, PassengerSamples::anyPassengerWithoutTicket);
    }
}
