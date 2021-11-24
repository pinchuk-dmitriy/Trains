package pinchuk.dmitriy.issoft.domain.wagons;

import pinchuk.dmitriy.issoft.domain.users.Driver;

import static pinchuk.dmitriy.issoft.domain.wagons.WagonType.LOCOMOTIVE;

public class Locomotive extends Wagon {

    private Driver driver;

    public static Locomotive of(int number, String model, Driver driver) {
        driverIsValid(driver);
        return new Locomotive(number, model, driver);
    }

    public static Locomotive of(int number, String model) {
        return new Locomotive(number, model);
    }

    private Locomotive(int number, String model) {
        super(number, model);
        super.setWagonType(LOCOMOTIVE);
    }

    private Locomotive(int number, String model, Driver driver) {
        super(number, model);
        super.setWagonType(LOCOMOTIVE);

        this.driver = driver;
    }


    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    private static boolean driverIsValid(Driver driver) {

        if(driver == null) {
            throw new IllegalArgumentException("Driver is empty");
        }

        if(driver.getAge() == 0) {
            throw new IllegalArgumentException("Wrong driver age");
        }

        if(!driver.isHaveLicense()) {
            throw new IllegalArgumentException("Driver has not license");
        }

        return true;
    }

}
