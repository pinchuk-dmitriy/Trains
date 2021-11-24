package pinchuk.dmitriy.issoft.users.samples;

import pinchuk.dmitriy.issoft.domain.users.Driver;

public class DriverSamples {

    public static Driver anyValidDriver() {
        Driver driver = new Driver("username", "dmitriy", "pinchuk", true);
        driver.setAge(20);
        return driver;
    }

    public static Driver anyDriverWithoutLicense() {
        Driver driver = new Driver("username", "dmitriy", "pinchuk", false);
        driver.setAge(20);
        return driver;
    }

    public static Driver anyUnderageDriver() {
        Driver driver = new Driver("username", "dmitriy", "pinchuk", true);
        driver.setAge(10);
        return driver;
    }

}
