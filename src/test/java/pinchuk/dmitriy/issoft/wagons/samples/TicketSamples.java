package pinchuk.dmitriy.issoft.wagons.samples;

import pinchuk.dmitriy.issoft.domain.wagons.Ticket;

import java.time.Instant;

public class TicketSamples {

    public static Ticket anyValidTicket() {
        return Ticket.of(Instant.now(), Instant.now(), PassengerWagonSamples.anyValidPassengerWagon(), "10A", 10000);
    }

    public static Ticket anyTicketWithoutWagon() {
        return Ticket.of(Instant.now(), Instant.now(), null, "10A", 10000);
    }
}
