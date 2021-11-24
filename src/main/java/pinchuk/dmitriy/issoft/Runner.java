package pinchuk.dmitriy.issoft;

import pinchuk.dmitriy.issoft.domain.users.Driver;
import pinchuk.dmitriy.issoft.domain.users.Passenger;
import pinchuk.dmitriy.issoft.domain.wagons.*;

import java.time.Instant;

import static pinchuk.dmitriy.issoft.domain.wagons.SeatStatus.*;

public class Runner {
    public static void main(String[] args) {
        Driver driver = new Driver("dmitriy", true);
        driver.setAge(18);
        PassengerWagon passengerWagon = PassengerWagon.of(1, "aaa", 3, NON_RESERVED_SEAT);

        Ticket ticket1 = Ticket.of(Instant.now(), Instant.now(), passengerWagon, "42A", 10000);
        Ticket ticket2 = Ticket.of(Instant.now(), Instant.now(), passengerWagon, "43A", 10000);
        Ticket ticket3 = Ticket.of(Instant.now(), Instant.now(), passengerWagon, "44A", 10000);

        System.out.println("Size of passengerWagon with number " + passengerWagon.getNumber() + " " + passengerWagon.tickets.size());

        Passenger passenger1 = Passenger.of("aaa", ticket1);
        Passenger passenger2 = Passenger.of("bbb", ticket2);
        Passenger passenger3 = Passenger.of("ccc", ticket3);

        Locomotive locomotive = Locomotive.of(1, "aaa", driver);

        PassengerWagon passengerWagon1 = PassengerWagon.of(2, "aaa", 50, NON_RESERVED_SEAT);
        PassengerWagon passengerWagon2 = PassengerWagon.of(3, "aaa", 50, NON_RESERVED_SEAT);
        PassengerWagon passengerWagon3 = PassengerWagon.of(4, "aaa", 50, NON_RESERVED_SEAT);

        FreightWagon freightWagon = FreightWagon.of(1, "aaa", 50);
        FreightWagon freightWagon1 = FreightWagon.of(2, "aaa", 25);
        FreightWagon freightWagon2 = FreightWagon.of(3, "aaa", 30);
        freightWagon2.addCargo(Cargo.of(31, "Stone"));
        System.out.println("Cargo of freight wagon with number " + freightWagon.getNumber() + " " + freightWagon.getCargo());
        Train train = new Train(111111);
        System.out.println("Type of locomotive " + locomotive.getWagonType());
        System.out.println("Adding status " + train.add(locomotive));
        System.out.println("Adding status " + train.add(passengerWagon1));
        System.out.println("Adding status " + train.add(passengerWagon2));
        System.out.println("All train" + train);
        System.out.println("All train" + train);
        System.out.println("Size of train" + train.getSize());
        System.out.println("Age of driver " + driver.getAge());
        System.out.println("Driver of locomotive " + locomotive.getDriver());
        System.out.println("Contains status with passenger wagon with number " + passenger2.getId() + " " + train.contains(passengerWagon2));
        System.out.println("Remove passenger wagon from train status " + train.remove(passengerWagon));
        System.out.println("All train " + train);
        train.clear();
        System.out.println("All train after clearing " + train);
    }
}
