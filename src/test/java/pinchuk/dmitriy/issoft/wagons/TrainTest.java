package pinchuk.dmitriy.issoft.wagons;

import org.junit.jupiter.api.Test;
import pinchuk.dmitriy.issoft.domain.wagons.*;
import pinchuk.dmitriy.issoft.wagons.samples.FreightWagonSamples;
import pinchuk.dmitriy.issoft.wagons.samples.LocomotiveSamples;
import pinchuk.dmitriy.issoft.wagons.samples.PassengerWagonSamples;
import pinchuk.dmitriy.issoft.wagons.samples.TrainSamples;

import static junit.framework.Assert.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TrainTest {

    @Test
    void createValidTrain() {
        Train train = TrainSamples.anyValidTrain();
        assertTrue(train.getNumber() != 0);
        assertTrue(train.isEmpty());
    }

    @Test
    void createTrainWithoutNumber() {
        assertThrows(IllegalArgumentException.class, TrainSamples::anyInvalidTrain);
    }

    @Test
    void addFirstWagonLocomotive() {
        Locomotive locomotive = LocomotiveSamples.anyValidLocomotive();
        Train train = TrainSamples.anyValidTrain();
        assertTrue(train.add(locomotive));
        assertTrue(train.getSize() == 1);
    }

    @Test
    void addFirstPassengerWagon() {
        PassengerWagon passengerWagon = PassengerWagonSamples.anyValidPassengerWagon();
        Train train = TrainSamples.anyValidTrain();
        assertThrows(IllegalArgumentException.class, () -> train.add(passengerWagon));
        assertTrue(train.getSize() == 0);
    }

    @Test
    void addFirstFreightWagon() {
        FreightWagon freightWagon = FreightWagonSamples.anyValidFreightWagon();
        Train train = TrainSamples.anyValidTrain();
        assertThrows(IllegalArgumentException.class, () -> train.add(freightWagon));
        assertTrue(train.getSize() == 0);
    }

    @Test
    void addValidWagons() {
        Locomotive locomotive = LocomotiveSamples.anyValidLocomotive();
        Train train = TrainSamples.anyValidTrain();
        assertTrue(train.add(locomotive));
        PassengerWagon passengerWagon1 = PassengerWagonSamples.anyValidPassengerWagon();
        assertTrue(train.add(passengerWagon1));
        PassengerWagon passengerWagon2 = PassengerWagonSamples.anyValidPassengerWagon();
        assertTrue(train.add(passengerWagon2));
        assertTrue(train.getSize() == 3);
    }

    @Test
    void addWagonsWithDifferentTypes() {
        Train train = createTrainWithLocomotive();
        PassengerWagon passengerWagon = PassengerWagonSamples.anyValidPassengerWagon();
        assertTrue(train.add(passengerWagon));
        FreightWagon freightWagon = FreightWagonSamples.anyValidFreightWagon();
        assertThrows(IllegalArgumentException.class, () -> train.add(freightWagon));
        assertTrue(train.getSize() == 2);
    }

    @Test
    void addInvalidWagon() {
        Train train = createTrainWithLocomotive();
        assertThrows(IllegalArgumentException.class, () -> train.add(null));
        assertThrows(IllegalArgumentException.class, () -> train.add(PassengerWagonSamples.anyInvalidPassengerWagon()));
    }

    @Test
    void addWagonInEmptyTrain() {
        Locomotive locomotive = LocomotiveSamples.anyValidLocomotive();
        Train train = TrainSamples.anyValidTrain();
        assertTrue(train.add(locomotive));
        assertTrue(train.getHead().equals(locomotive));
    }

    @Test
    void addWagonInFront() {
        Train train = createTrainWithLocomotive();
        PassengerWagon passengerWagon1 = PassengerWagonSamples.anyValidPassengerWagon();
        assertTrue(train.add(passengerWagon1));
        PassengerWagon passengerWagon2 = PassengerWagonSamples.anyValidPassengerWagon();
        assertTrue(train.addFront(passengerWagon2));
        assertTrue(train.getTail().equals(passengerWagon1));
        assertTrue(train.getHead().getWagonType() == WagonType.LOCOMOTIVE);
        assertTrue(train.getSize() == 3);
    }

    @Test
    void addWagonWithWrongTypeInFront() {
        Train train = createTrainWithLocomotive();
        PassengerWagon passengerWagon = PassengerWagonSamples.anyValidPassengerWagon();
        assertTrue(train.add(passengerWagon));
        FreightWagon freightWagon = FreightWagonSamples.anyValidFreightWagon();
        assertThrows(IllegalArgumentException.class, () -> train.addFront(freightWagon));
        assertTrue(train.getSize() == 2);
    }

    @Test
    void containsValidWagon() {
        Train train = createTrainWithLocomotive();
        PassengerWagon passengerWagon = PassengerWagonSamples.anyValidPassengerWagon();
        assertTrue(train.add(passengerWagon));
        assertTrue(train.contains(passengerWagon));
    }

    @Test
    void containsInvalidWagon() {
        Train train = createTrainWithLocomotive();
        PassengerWagon passengerWagon1 = PassengerWagonSamples.anyValidPassengerWagon();
        PassengerWagon passengerWagon2 = PassengerWagonSamples.anyValidPassengerWagon();
        assertTrue(train.add(passengerWagon1));
        assertFalse(train.contains(passengerWagon2));
    }

    @Test
    void containsInEmptyTrain() {
        Train train = TrainSamples.anyValidTrain();
        PassengerWagon passengerWagon1 = PassengerWagonSamples.anyValidPassengerWagon();
        assertFalse(train.contains(passengerWagon1));
    }

    @Test
    void removeValidWagon() {
        Train train = createTrainWithLocomotive();
        PassengerWagon passengerWagon = PassengerWagonSamples.anyValidPassengerWagon();
        assertTrue(train.add(passengerWagon));
        assertTrue(train.remove(passengerWagon));
        assertTrue(train.getSize() == 1);
    }

    @Test
    void removeInvalidWagon() {
        Train train = createTrainWithLocomotive();
        PassengerWagon passengerWagon1 = PassengerWagonSamples.anyValidPassengerWagon();
        PassengerWagon passengerWagon2 = PassengerWagonSamples.anyValidPassengerWagon();
        assertTrue(train.add(passengerWagon1));
        assertFalse(train.remove(passengerWagon2));
        assertTrue(train.getSize() == 2);
    }

    @Test
    void removeASingleWagon() {
        Locomotive locomotive = LocomotiveSamples.anyValidLocomotive();
        Train train = TrainSamples.anyValidTrain();
        train.add(locomotive);
        assertTrue(train.remove(locomotive));
        assertTrue(train.isEmpty());
    }

    @Test
    void clearTrain() {
        Train train = createTrainWithLocomotive();
        PassengerWagon passengerWagon1 = PassengerWagonSamples.anyValidPassengerWagon();
        assertTrue(train.add(passengerWagon1));
        assertTrue(train.getSize() == 2);
        train.clear();
        assertTrue(train.isEmpty());
    }


    private Train createTrainWithLocomotive() {
        Locomotive locomotive = LocomotiveSamples.anyValidLocomotive();
        Train train = TrainSamples.anyValidTrain();
        train.add(locomotive);
        return train;
    }

}
