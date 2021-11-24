package pinchuk.dmitriy.issoft.domain.users;

import pinchuk.dmitriy.issoft.domain.wagons.Ticket;

public class Passenger extends User {

    private Ticket ticket;

    public static Passenger of(String username, Ticket ticket) {

        if(ticket == null) {
            throw new IllegalArgumentException("Passenger cannot be without ticket");
        }

        return new Passenger(username, ticket);

    }

    public static Passenger of(String username, String firstName, String lastName, Ticket ticket) {

        if(ticket == null) {
            throw new IllegalArgumentException("Passenger cannot be without ticket");
        }

        return new Passenger(username, firstName, lastName, ticket);

    }

    private Passenger(String username, Ticket ticket) {

        super(username);
        this.ticket = ticket;

    }

    private Passenger(String username, String firstName, String lastName, Ticket ticket) {

        super(username, firstName, lastName);
        this.ticket = ticket;

    }

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }
}
