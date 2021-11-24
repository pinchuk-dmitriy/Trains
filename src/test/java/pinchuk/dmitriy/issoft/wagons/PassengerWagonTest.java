package pinchuk.dmitriy.issoft.wagons;

import org.junit.jupiter.api.Test;
import pinchuk.dmitriy.issoft.domain.wagons.PassengerWagon;
import pinchuk.dmitriy.issoft.domain.wagons.WagonType;
import pinchuk.dmitriy.issoft.wagons.samples.PassengerWagonSamples;

import static junit.framework.Assert.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class PassengerWagonTest {

    @Test
    void createValidPassengerWagon() {
        PassengerWagon passengerWagon = PassengerWagonSamples.anyValidPassengerWagon();
        assertTrue(passengerWagon.getRoominess() != 0);
        assertTrue(passengerWagon.getNumber() != 0);
        assertTrue(passengerWagon.getWagonType() == WagonType.PASSENGER);
        assertNotNull(passengerWagon.getTypeOfSeat());
    }

    @Test
    void createInvalidPassengerWagon() {
        assertThrows(IllegalArgumentException.class, () -> PassengerWagonSamples.anyInvalidPassengerWagon());
    }
}
