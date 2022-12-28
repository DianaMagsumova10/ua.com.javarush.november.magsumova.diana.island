package ua.com.magsumova.diana.island.animal.herbivore.herbivoreList;

import ua.com.magsumova.diana.island.animal.Characteristic;
import ua.com.magsumova.diana.island.animal.herbivore.Herbivore;
import ua.com.magsumova.diana.island.island.Location;


@Characteristic(weight = 0.01, maxSatiety = 0, maxOnOneLocation = 1000)
public class Caterpillar extends Herbivore {
    @Override
    public boolean move(Location currentLocation, Location[][] locations) {
        return false;
    }

    @Override
    public String toString() {
        return "Caterpillar";
    }
}
