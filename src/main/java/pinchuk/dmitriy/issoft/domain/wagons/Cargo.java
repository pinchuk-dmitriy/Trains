package pinchuk.dmitriy.issoft.domain.wagons;

import java.util.concurrent.ThreadLocalRandom;

public class Cargo {

    private final static int MAX_ID = 999999;

    private final int id;
    private int weight;
    private String nameOfCargo;
    private FreightWagon freightWagon;

    public static Cargo of(int weight, String nameOfCargo) {

        if(weight == 0) {
            throw new IllegalArgumentException("Cargo cannot be without weight");
        }

        return new Cargo(weight, nameOfCargo);
    }

    private Cargo(int weight, String nameOfCargo) {

        this.id = ThreadLocalRandom.current().nextInt(1, MAX_ID);
        this.weight = weight;
        this.nameOfCargo = nameOfCargo;

    }

    public String getNameOfCargo() {
        return nameOfCargo;
    }

    public void setNameOfCargo(String nameOfCargo) {
        this.nameOfCargo = nameOfCargo;
    }

    public int getId() {
        return id;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public FreightWagon getFreightWagon() {
        return freightWagon;
    }

    public void setFreightWagon(FreightWagon freightWagon) {
        this.freightWagon = freightWagon;
    }
}
