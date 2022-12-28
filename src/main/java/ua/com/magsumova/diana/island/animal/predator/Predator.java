package ua.com.magsumova.diana.island.animal.predator;

import ua.com.magsumova.diana.island.animal.Animal;
import ua.com.magsumova.diana.island.animal.Characteristic;
import ua.com.magsumova.diana.island.animal.Gender;
import ua.com.magsumova.diana.island.animal.herbivore.herbivoreList.Boar;
import ua.com.magsumova.diana.island.animal.herbivore.herbivoreList.Buffalo;
import ua.com.magsumova.diana.island.animal.herbivore.herbivoreList.Deer;
import ua.com.magsumova.diana.island.animal.herbivore.herbivoreList.Duck;
import ua.com.magsumova.diana.island.animal.herbivore.herbivoreList.Goat;
import ua.com.magsumova.diana.island.animal.herbivore.herbivoreList.Mouse;
import ua.com.magsumova.diana.island.animal.herbivore.herbivoreList.Rabbit;
import ua.com.magsumova.diana.island.animal.herbivore.herbivoreList.Sheep;
import ua.com.magsumova.diana.island.island.Location;

import java.util.List;
import java.util.Map;

public abstract class Predator extends Animal {
    @Override
    public boolean breed(Location location) {
        location.getLock().lock();
        try {
            List<Predator> predatorsFemale = location.getPredators().stream().filter(predator ->
                    predator.getGender() == Gender.FEMALE && !predator.isBreed()).toList();
            if (predatorsFemale.isEmpty()) {
                return false;
            }
            for (int i = 0; i < predatorsFemale.size(); i++) {
                Predator predatorFemale = predatorsFemale.get(i);
                if (this.getGender() == Gender.MALE && !this.isBreed() && this.equals(predatorFemale)) {
                    this.setBreed(true);
                    this.setSatiety(Math.max(0, this.getSatiety() - this.getMaxSatiety() / 10));
                    predatorFemale.setBreed(true);
                    predatorFemale.setSatiety(Math.max(0, predatorFemale.getSatiety() - predatorFemale.getMaxSatiety() / 10));
                    return true;
                }
            }
            return false;
        } finally {
            location.getLock().unlock();
        }
    }


}
