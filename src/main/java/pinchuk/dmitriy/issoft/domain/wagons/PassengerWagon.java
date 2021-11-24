package pinchuk.dmitriy.issoft.domain.wagons;

import java.util.HashMap;
import java.util.Map;

import static pinchuk.dmitriy.issoft.domain.wagons.WagonType.PASSENGER;

public class PassengerWagon extends Wagon {

    public Map<Integer, Ticket> tickets = new HashMap<>();

    private final int roominess;
    private final SeatStatus typeOfSeat;

    public static PassengerWagon of(int number, String model, int roominess, SeatStatus typeOfSeat) {

        if(roominess == 0) {
            throw new IllegalArgumentException("Invalid roominess");
        }

        return new PassengerWagon(number, model, roominess, typeOfSeat);
    }


    private PassengerWagon(int number, String model, int roominess, SeatStatus typeOfSeat) {
        super(number, model);
        super.setWagonType(PASSENGER);

        this.roominess = roominess;
        this.typeOfSeat = typeOfSeat;
    }

    public int getRoominess() {
        return roominess;
    }

    public SeatStatus getTypeOfSeat() {
        return typeOfSeat;
    }

}
