package pinchuk.dmitriy.issoft.wagons.samples;

import pinchuk.dmitriy.issoft.domain.wagons.Locomotive;
import pinchuk.dmitriy.issoft.users.samples.DriverSamples;

public class LocomotiveSamples {

    public static Locomotive anyValidLocomotive() {
        return Locomotive.of(1111, "model", DriverSamples.anyValidDriver());
    }

    public static Locomotive anyLocomotiveWithoutDriver() {
        return Locomotive.of(1111, "model");
    }
}
