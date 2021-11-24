package pinchuk.dmitriy.issoft.domain.wagons;

import pinchuk.dmitriy.issoft.validation.FreightWagonValidator;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import static pinchuk.dmitriy.issoft.domain.wagons.WagonType.CARGO;

public class FreightWagon extends Wagon {

    /**
     * This map contains all freight wagons that were created
     *
     * It allows distributing cargos among all freight wagons of all trains
     *
     * It allows finding free place among all freight wagons independent to a certain train
     */
    public static final Map<Integer, FreightWagon> ALL_TRAINS_FREIGHT_WAGONS = new HashMap<>();

    private final FreightWagonValidator freightWagonValidator;
    private final int maxWeight;
    private Cargo cargo;

    public static FreightWagon of(int number, String model, int maxWeight) {

        if(number == 0 || maxWeight == 0) {
            throw new IllegalArgumentException("Freight wagon cannot be without number and weight");
        }

        if(ALL_TRAINS_FREIGHT_WAGONS.get(number) != null){
            throw new IllegalArgumentException("This number of freight wagon is busy");
        }

        FreightWagon freightWagon = new FreightWagon(number, model, maxWeight);
        FreightWagon.ALL_TRAINS_FREIGHT_WAGONS.put(freightWagon.getNumber(), freightWagon);

        return freightWagon;
    }

    private FreightWagon(int number, String model, int maxWeight) {
        super(number, model);
        super.setWagonType(CARGO);

        this.maxWeight = maxWeight;
        freightWagonValidator = new FreightWagonValidator();
    }

    public boolean addCargo(Cargo cargo) {

        if(freightWagonValidator.validatorForAddCargo(this, cargo)) {

            this.cargo = cargo;
            cargo.setFreightWagon(this);
            return true;

        } else return addInAnotherWagon(cargo);
    }

    private boolean addInAnotherWagon(Cargo cargo) {

        Optional<Map.Entry<Integer, FreightWagon>> freightWagon = ALL_TRAINS_FREIGHT_WAGONS.entrySet().stream()
                .filter(x -> x.getValue().maxWeight >= cargo.getWeight())
                .filter(x -> x.getValue().getCargo() == null)
                .findFirst();

        if(freightWagon.isPresent()) {
            freightWagon.get().getValue().addCargo(cargo);
            return true;
        }

        return false;
    }

    public int getMaxWeight() {
        return maxWeight;
    }

    public Cargo getCargo() {
        return cargo;
    }

}
