package pinchuk.dmitriy.issoft.wagons.samples;

import pinchuk.dmitriy.issoft.domain.wagons.Cargo;

public class CargoSamples {

    public static Cargo anyValidCargo() {
        return Cargo.of(3000, "Stone");
    }

    public static Cargo anyCargoWithoutWeight() {
        return Cargo.of(0, "Stone");
    }

}
