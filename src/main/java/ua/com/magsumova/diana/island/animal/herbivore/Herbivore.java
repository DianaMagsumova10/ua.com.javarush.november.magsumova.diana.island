package ua.com.magsumova.diana.island.animal.herbivore;

import ua.com.magsumova.diana.island.animal.Animal;
import ua.com.magsumova.diana.island.animal.Gender;
import ua.com.magsumova.diana.island.island.Location;

import java.util.List;

public abstract class Herbivore extends Animal {
    public boolean breed(Location location) {
        location.getLock().lock();
        try {
            List<Herbivore> herbivoresFemale = location.getHerbivores().stream().filter(herbivore ->
                    herbivore.getGender() == Gender.FEMALE && !herbivore.isBreed()).toList();
            if (herbivoresFemale.isEmpty()) {
                return false;
            }
            for (int i = 0; i < herbivoresFemale.size(); i++) {
                Herbivore herbivoreFemale = herbivoresFemale.get(i);
                if (this.getGender() == Gender.MALE && !this.isBreed() && this.equals(herbivoreFemale)) {
                    this.setBreed(true);
                    this.setSatiety(Math.max(0, this.getSatiety() - this.getMaxSatiety() / 10));
                    herbivoreFemale.setBreed(true);
                    herbivoreFemale.setSatiety(Math.max(0, herbivoreFemale.getSatiety() - herbivoreFemale.getMaxSatiety() / 10));
                    return true;
                }
            }
            return false;
        } finally {
            location.getLock().unlock();
        }
    }
}
