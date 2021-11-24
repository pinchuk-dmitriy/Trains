package pinchuk.dmitriy.issoft.users.samples;

import pinchuk.dmitriy.issoft.domain.users.Passenger;
import pinchuk.dmitriy.issoft.wagons.samples.TicketSamples;

public class PassengerSamples {

    public static Passenger anyValidPassenger() {
        Passenger passenger = Passenger.of("username", "dmitriy", "pinchuk", TicketSamples.anyValidTicket());
        passenger.setAge(20);
        return passenger;
    }

    public static Passenger anyPassengerWithoutTicket() {
        Passenger passenger = Passenger.of("username", "dmitriy", "pinchuk", null);
        passenger.setAge(20);
        return passenger;
    }
}
