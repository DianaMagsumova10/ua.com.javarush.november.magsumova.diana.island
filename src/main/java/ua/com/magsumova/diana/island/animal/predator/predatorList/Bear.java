package ua.com.magsumova.diana.island.animal.predator.predatorList;

import ua.com.magsumova.diana.island.animal.Animal;
import ua.com.magsumova.diana.island.animal.Characteristic;
import ua.com.magsumova.diana.island.animal.herbivore.herbivoreList.Boar;
import ua.com.magsumova.diana.island.animal.herbivore.herbivoreList.Buffalo;
import ua.com.magsumova.diana.island.animal.herbivore.herbivoreList.Deer;
import ua.com.magsumova.diana.island.animal.herbivore.herbivoreList.Duck;
import ua.com.magsumova.diana.island.animal.herbivore.herbivoreList.Goat;
import ua.com.magsumova.diana.island.animal.herbivore.herbivoreList.Horse;
import ua.com.magsumova.diana.island.animal.herbivore.herbivoreList.Mouse;
import ua.com.magsumova.diana.island.animal.herbivore.herbivoreList.Rabbit;
import ua.com.magsumova.diana.island.animal.herbivore.herbivoreList.Sheep;
import ua.com.magsumova.diana.island.animal.predator.Predator;

import java.util.Map;
@Characteristic(weight = 500, maxSatiety = 80, maxOnOneLocation = 5, possibleDistance = 2)
public class Bear extends Predator {
    private static final Map<Class<? extends Animal>, Integer> CHANCE_TO_EAT =
            Map.of(Boa.class, 80, Horse.class, 40, Deer.class, 80, Rabbit.class, 80,
                    Mouse.class, 90, Goat.class, 70, Sheep.class, 70, Boar.class, 50,
                    Buffalo.class, 20, Duck.class, 70);

    @Override
    public Map<Class<? extends Animal>, Integer> getChanceToEat() {
        return CHANCE_TO_EAT;
    }

    @Override
    public String toString() {
        return "Bear";
    }
}
