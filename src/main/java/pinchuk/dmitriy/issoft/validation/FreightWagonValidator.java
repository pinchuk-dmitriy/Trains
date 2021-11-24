package pinchuk.dmitriy.issoft.validation;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pinchuk.dmitriy.issoft.domain.wagons.Cargo;
import pinchuk.dmitriy.issoft.domain.wagons.FreightWagon;

public class FreightWagonValidator {

    public Logger logger = LoggerFactory.getLogger(FreightWagonValidator.class);

    public boolean validatorForAddCargo(FreightWagon freightWagon, Cargo cargo) {

        if(freightWagon.getMaxWeight() == 0) {

            logger.warn("Max weight is 0");
            return false;

        }

        if(cargo.getWeight() > freightWagon.getMaxWeight()) {

            logger.warn("The weight of cargo is more than max weight of freight wagon with number " + freightWagon.getNumber());
            return false;

        } else {

            logger.warn("The weight of the cargo is placed on the wagon with number " + freightWagon.getNumber());
            return true;

        }

    }
}
