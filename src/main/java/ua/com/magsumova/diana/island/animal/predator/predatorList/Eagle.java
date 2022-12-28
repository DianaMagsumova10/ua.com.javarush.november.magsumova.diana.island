package ua.com.magsumova.diana.island.animal.predator.predatorList;

import ua.com.magsumova.diana.island.animal.Animal;
import ua.com.magsumova.diana.island.animal.Characteristic;
import ua.com.magsumova.diana.island.animal.herbivore.herbivoreList.Duck;
import ua.com.magsumova.diana.island.animal.herbivore.herbivoreList.Mouse;
import ua.com.magsumova.diana.island.animal.herbivore.herbivoreList.Rabbit;
import ua.com.magsumova.diana.island.animal.predator.Predator;

import java.util.Map;

@Characteristic(weight = 6, maxSatiety = 1, maxOnOneLocation = 20, possibleDistance = 3)
public class Eagle extends Predator {
    private static final Map<Class<? extends Animal>, Integer> CHANCE_TO_EAT =
            Map.of(Fox.class, 10, Rabbit.class, 90, Mouse.class, 90, Duck.class, 80);

    @Override
    public Map<Class<? extends Animal>, Integer> getChanceToEat() {
        return CHANCE_TO_EAT;
    }

    @Override
    public String toString() {
        return "Eagle";
    }

}
