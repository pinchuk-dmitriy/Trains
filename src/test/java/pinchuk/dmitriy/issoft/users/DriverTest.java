package pinchuk.dmitriy.issoft.users;

import org.junit.jupiter.api.Test;
import pinchuk.dmitriy.issoft.domain.users.Driver;
import pinchuk.dmitriy.issoft.users.samples.DriverSamples;

import static junit.framework.Assert.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class DriverTest {

    @Test
    void createValidDriver() {
        Driver driver = DriverSamples.anyValidDriver();
        assertNotNull(driver.getId());
        assertNotNull(driver.getUsername());
        assertTrue(driver.getAge() >= Driver.MIN_AGE_OF_DRIVER);
        assertTrue(driver.isHaveLicense());
    }

    @Test
    void createDriverWithoutLicense() {
        Driver driver = DriverSamples.anyDriverWithoutLicense();
        assertFalse(driver.isHaveLicense());
    }

    @Test
    void createUnderageDriver() {
        assertThrows(IllegalArgumentException.class, DriverSamples::anyUnderageDriver);
    }

}
