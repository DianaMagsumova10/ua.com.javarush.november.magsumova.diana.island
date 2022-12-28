package ua.com.magsumova.diana.island.animal.herbivore.herbivoreList;

import ua.com.magsumova.diana.island.animal.Characteristic;
import ua.com.magsumova.diana.island.animal.herbivore.Herbivore;


@Characteristic(weight = 300, maxSatiety = 50, maxOnOneLocation = 20, possibleDistance = 4)
public class Deer extends Herbivore {
    @Override
    public String toString() {
        return "Deer";
    }
}
