package pinchuk.dmitriy.issoft.wagons;

import org.junit.jupiter.api.Test;
import pinchuk.dmitriy.issoft.domain.wagons.Locomotive;
import pinchuk.dmitriy.issoft.users.samples.DriverSamples;
import pinchuk.dmitriy.issoft.wagons.samples.LocomotiveSamples;

import static junit.framework.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class LocomotiveTest {

    @Test
    void createValidLocomotive() {
        Locomotive locomotive = LocomotiveSamples.anyValidLocomotive();
        assertTrue(locomotive.getNumber() != 0);
        assertTrue(locomotive.getDriver().isHaveLicense());
        assertTrue(locomotive.getDriver().getAge() >= 18);
    }

    @Test
    void createLocomotiveWithoutDriver() {
        Locomotive locomotive = LocomotiveSamples.anyLocomotiveWithoutDriver();
        assertTrue(locomotive.getDriver() == null);
    }

    @Test
    void createLocomotiveWithUnderageDriver() {
        assertThrows(IllegalArgumentException.class, () -> Locomotive.of(1111, "model", DriverSamples.anyUnderageDriver()));
    }

    @Test
    void createLocomotiveWithDriverWithoutLicense() {
        assertThrows(IllegalArgumentException.class, () -> Locomotive.of(1111, "model", DriverSamples.anyDriverWithoutLicense()));
    }
}
