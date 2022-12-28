package ua.com.magsumova.diana.island.animal.herbivore.herbivoreList;

import ua.com.magsumova.diana.island.animal.Characteristic;
import ua.com.magsumova.diana.island.animal.herbivore.Herbivore;
@Characteristic(weight = 2, maxSatiety = 0.45, maxOnOneLocation = 150, possibleDistance = 2)
public class Rabbit extends Herbivore {

    @Override
    public String toString() {
        return "Rabbit";
    }
}
