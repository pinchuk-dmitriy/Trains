package pinchuk.dmitriy.issoft.wagons;

import org.junit.jupiter.api.Test;
import pinchuk.dmitriy.issoft.domain.wagons.PassengerWagon;
import pinchuk.dmitriy.issoft.domain.wagons.Ticket;
import pinchuk.dmitriy.issoft.wagons.samples.TicketSamples;

import java.time.Instant;

import static junit.framework.Assert.assertNotNull;
import static junit.framework.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static pinchuk.dmitriy.issoft.domain.wagons.SeatStatus.NON_RESERVED_SEAT;

public class TicketTest {

    @Test
    void createValidTicket() {
        Ticket ticket = TicketSamples.anyValidTicket();
        assertTrue(ticket.getId() != 0);
        assertNotNull(ticket.getPassengerWagon());
        assertNotNull(ticket.getSeat());
    }

    @Test
    void createTicketWithoutWagon() {
        assertThrows(IllegalArgumentException.class, TicketSamples::anyTicketWithoutWagon);
    }

    @Test
    void createTicketInFullRoominessOfWagon() {
        PassengerWagon passengerWagon = PassengerWagon.of(111111, "aaa", 2, NON_RESERVED_SEAT);
        Ticket firstTicket = Ticket.of(Instant.now(), Instant.now(), passengerWagon, "1a", 10000);
        Ticket secondTicket = Ticket.of(Instant.now(), Instant.now(), passengerWagon, "1a", 10000);
        assertTrue(passengerWagon.tickets.size() == 2);
        assertThrows(IllegalArgumentException.class, () -> Ticket.of(Instant.now(), Instant.now(), passengerWagon, "1a", 10000));
    }

}
