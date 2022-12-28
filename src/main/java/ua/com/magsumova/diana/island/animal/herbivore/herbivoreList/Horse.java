package ua.com.magsumova.diana.island.animal.herbivore.herbivoreList;

import ua.com.magsumova.diana.island.animal.Characteristic;
import ua.com.magsumova.diana.island.animal.herbivore.Herbivore;

@Characteristic(weight = 400, maxSatiety = 60, maxOnOneLocation = 20, possibleDistance = 4)
public class Horse extends Herbivore {

    @Override
    public String toString() {
        return "Horse";
    }

}
