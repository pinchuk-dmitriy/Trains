package pinchuk.dmitriy.issoft.wagons;

import org.junit.jupiter.api.Test;
import pinchuk.dmitriy.issoft.domain.wagons.Cargo;
import pinchuk.dmitriy.issoft.wagons.samples.CargoSamples;

import static junit.framework.Assert.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CargoTest {

    @Test
    void createValidCargo() {
        Cargo cargo = CargoSamples.anyValidCargo();
        assertTrue(cargo.getId() != 0);
        assertNull(cargo.getFreightWagon());
        assertNotNull(cargo.getNameOfCargo());
        assertTrue(cargo.getWeight() != 0);
    }

    @Test
    void createCargoWithoutWeight() {
        assertThrows(IllegalArgumentException.class, CargoSamples::anyCargoWithoutWeight);
    }
}
