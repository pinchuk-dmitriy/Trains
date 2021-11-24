package pinchuk.dmitriy.issoft.wagons.samples;

import pinchuk.dmitriy.issoft.domain.wagons.PassengerWagon;

import static pinchuk.dmitriy.issoft.domain.wagons.SeatStatus.NON_RESERVED_SEAT;

public class PassengerWagonSamples {

    public static PassengerWagon anyValidPassengerWagon() {
        return PassengerWagon.of(111111, "aaa", 50, NON_RESERVED_SEAT);
    }

    public static PassengerWagon anyInvalidPassengerWagon() {
        return PassengerWagon.of(0, "aaa", 0, null);
    }
}
