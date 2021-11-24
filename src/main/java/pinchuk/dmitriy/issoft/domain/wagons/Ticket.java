package pinchuk.dmitriy.issoft.domain.wagons;

import java.time.Instant;
import java.util.concurrent.ThreadLocalRandom;

public class Ticket {

    private final int id;
    private final PassengerWagon passengerWagon;
    private final Instant departureDate;
    private final Instant arrivalDate;

    private final String seat;
    private int cost;

    public static Ticket of(Instant departureDate, Instant arrivalDate, PassengerWagon passengerWagon, String seat, int cost) {

        if(passengerWagon == null) {
            throw new IllegalArgumentException("Ticket cannot be created without passenger wagon");
        }

        if(passengerWagon.getRoominess() == passengerWagon.tickets.size()) {
            throw new IllegalArgumentException("Passenger wagon with number " + passengerWagon.getNumber() + " is full");
        } else {
            Ticket ticket = new Ticket(departureDate, arrivalDate, passengerWagon, seat, cost);
            passengerWagon.tickets.put(ticket.getId(), ticket);
            return ticket;
        }

    }

    private Ticket(Instant departureDate, Instant arrivalDate, PassengerWagon passengerWagon, String seat, int cost) {

        this.id = ThreadLocalRandom.current().nextInt(1, 999999);
        this.departureDate = departureDate;
        this.arrivalDate = arrivalDate;
        this.passengerWagon = passengerWagon;
        this.seat = seat;
        this.cost = cost;

    }

    public int getId() {
        return id;
    }

    public Instant getDepartureDate() {
        return departureDate;
    }

    public Instant getArrivalDate() {
        return arrivalDate;
    }

    public String getSeat() {
        return seat;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public PassengerWagon getPassengerWagon() {
        return passengerWagon;
    }
}
