package ua.com.magsumova.diana.island.animal.herbivore.herbivoreList;

import ua.com.magsumova.diana.island.animal.Characteristic;
import ua.com.magsumova.diana.island.animal.herbivore.Herbivore;


@Characteristic(weight = 60, maxSatiety = 10, maxOnOneLocation = 140, possibleDistance = 3)
public class Goat extends Herbivore {
    @Override
    public String toString() {
        return "Goat";
    }
}
