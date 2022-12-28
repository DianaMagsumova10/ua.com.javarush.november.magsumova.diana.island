package ua.com.magsumova.diana.island.animal.herbivore.herbivoreList;

import ua.com.magsumova.diana.island.animal.Characteristic;
import ua.com.magsumova.diana.island.animal.herbivore.Herbivore;



@Characteristic(weight = 700, maxSatiety = 100, maxOnOneLocation = 10, possibleDistance = 3)
public class Buffalo extends Herbivore {
    @Override
    public String toString() {
        return "Buffalo";
    }

}
