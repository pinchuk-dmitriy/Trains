package pinchuk.dmitriy.issoft.domain.wagons;

public class Wagon {

    private final int number;

    private WagonType wagonType;
    private final String model;

    protected Wagon(int number, String model) {

        if(number == 0) {
            throw new IllegalArgumentException("Invalid number");
        }

        this.number = number;
        this.model = model;

    }

    public int getNumber() {
        return number;
    }

    public WagonType getWagonType() {
        return wagonType;
    }

    protected String getModel() {
        return model;
    }

    protected void setWagonType(WagonType wagonType) {
        this.wagonType = wagonType;
    }

}
