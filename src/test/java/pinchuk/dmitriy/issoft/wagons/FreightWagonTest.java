package pinchuk.dmitriy.issoft.wagons;

import org.junit.jupiter.api.Test;
import pinchuk.dmitriy.issoft.domain.wagons.Cargo;
import pinchuk.dmitriy.issoft.domain.wagons.FreightWagon;
import pinchuk.dmitriy.issoft.domain.wagons.WagonType;
import pinchuk.dmitriy.issoft.wagons.samples.CargoSamples;
import pinchuk.dmitriy.issoft.wagons.samples.FreightWagonSamples;

import static junit.framework.Assert.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class FreightWagonTest {

    @Test
    void createValidFreightWagon() {
        FreightWagon freightWagon = FreightWagonSamples.anyValidFreightWagon();
        assertTrue(freightWagon.getNumber() != 0);
        assertTrue(freightWagon.getMaxWeight() != 0);
        assertFalse(freightWagon.ALL_TRAINS_FREIGHT_WAGONS.isEmpty());
        assertTrue(freightWagon.getWagonType() == WagonType.CARGO);
    }

    @Test
    void createInvalidFreightWagon() {
        assertThrows(IllegalArgumentException.class, FreightWagonSamples::anyInvalidFreightWagon);
    }

    @Test
    void createWagonsWithEqualNumber() {
        FreightWagon freightWagon = FreightWagon.of(11111, "model", 5000);;
        assertThrows(IllegalArgumentException.class, () -> FreightWagon.of(11111, "model", 5000));
    }

    @Test
    void addValidCargo() {
        FreightWagon freightWagon = FreightWagonSamples.anyValidFreightWagon();
        Cargo cargo = CargoSamples.anyValidCargo();
        assertTrue(freightWagon.addCargo(cargo));
        assertTrue(freightWagon.getCargo().equals(cargo));
        assertTrue(cargo.getFreightWagon().equals(freightWagon));
    }

    @Test
    void addCargoWithInvalidWeight() {
        FreightWagon freightWagon = FreightWagonSamples.anyValidFreightWagon();
        Cargo cargo = Cargo.of(9999999,"Stone");
        assertFalse(freightWagon.addCargo(cargo));
        assertTrue(freightWagon.getCargo() == null);
        assertTrue(cargo.getFreightWagon() == null);
    }

    @Test
    void addValidCargoInAnotherWagon() {
        FreightWagon firstFreightWagon = FreightWagon.of(77777, "model", 2000);
        FreightWagon secondFreightWagon = FreightWagon.of(88888, "model", 3000);
        Cargo cargo = CargoSamples.anyValidCargo();
        assertTrue(firstFreightWagon.addCargo(cargo));
        assertTrue(secondFreightWagon.getCargo().equals(cargo));
        assertTrue(cargo.getFreightWagon().equals(secondFreightWagon));
    }

    @Test
    void addInvalidCargoInAnotherWagon() {
        FreightWagon firstFreightWagon = FreightWagon.of(44444, "model", 2000);
        FreightWagon secondFreightWagon = FreightWagon.of(55555, "model", 2999);
        FreightWagon thirdFreightWagon = FreightWagon.of(66666, "model", 2500);
        Cargo cargo = CargoSamples.anyValidCargo();
        assertFalse(firstFreightWagon.addCargo(cargo));
        assertTrue(secondFreightWagon.getCargo() == null);
        assertTrue(cargo.getFreightWagon() != secondFreightWagon);
        assertTrue(thirdFreightWagon.getCargo() == null);
        assertTrue(cargo.getFreightWagon() != thirdFreightWagon);
    }
}
