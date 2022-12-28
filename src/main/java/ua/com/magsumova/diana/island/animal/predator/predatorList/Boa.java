package ua.com.magsumova.diana.island.animal.predator.predatorList;

import ua.com.magsumova.diana.island.animal.Animal;
import ua.com.magsumova.diana.island.animal.Characteristic;
import ua.com.magsumova.diana.island.animal.herbivore.herbivoreList.Duck;
import ua.com.magsumova.diana.island.animal.herbivore.herbivoreList.Mouse;
import ua.com.magsumova.diana.island.animal.herbivore.herbivoreList.Rabbit;
import ua.com.magsumova.diana.island.animal.predator.Predator;

import java.util.Map;

@Characteristic(weight = 15, maxSatiety = 3, maxOnOneLocation = 30, possibleDistance = 1)
public class Boa extends Predator {
    private static final Map<Class<? extends Animal>, Integer> CHANCE_TO_EAT =
            Map.of(Fox.class, 15, Rabbit.class, 20, Mouse.class, 40, Duck.class, 10);

    @Override
    public Map<Class<? extends Animal>, Integer> getChanceToEat() {
        return CHANCE_TO_EAT;
    }

    @Override
    public String toString() {
        return "Boa";
    }
}
