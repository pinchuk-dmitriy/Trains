package pinchuk.dmitriy.issoft.wagons.samples;

import pinchuk.dmitriy.issoft.domain.wagons.Train;

import java.util.Random;

public class TrainSamples {

    public static Train anyValidTrain() {
        Random random = new Random();
        return new Train(random.nextInt());
    }


    public static Train anyInvalidTrain() {
        return new Train(0);
    }
}
