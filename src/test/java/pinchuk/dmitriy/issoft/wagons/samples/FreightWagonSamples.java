package pinchuk.dmitriy.issoft.wagons.samples;

import pinchuk.dmitriy.issoft.domain.wagons.FreightWagon;

import java.util.Random;

public class FreightWagonSamples {

    public static FreightWagon anyValidFreightWagon() {
        Random random = new Random();
        return FreightWagon.of(random.nextInt(), "model", 5000);
    }

    public static FreightWagon anyInvalidFreightWagon() {
        return FreightWagon.of(0, "model", 0);
    }
}
