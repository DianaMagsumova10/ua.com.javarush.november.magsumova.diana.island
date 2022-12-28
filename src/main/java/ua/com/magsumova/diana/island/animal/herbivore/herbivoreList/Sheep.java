package ua.com.magsumova.diana.island.animal.herbivore.herbivoreList;

import ua.com.magsumova.diana.island.animal.Characteristic;
import ua.com.magsumova.diana.island.animal.herbivore.Herbivore;
@Characteristic(weight = 70, maxSatiety = 15, maxOnOneLocation = 140, possibleDistance = 3)
public class Sheep extends Herbivore {
    @Override
    public String toString() {
        return "Sheep";
    }
}
