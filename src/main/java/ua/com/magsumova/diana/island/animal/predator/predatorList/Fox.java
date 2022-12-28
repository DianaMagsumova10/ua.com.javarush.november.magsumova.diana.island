package ua.com.magsumova.diana.island.animal.predator.predatorList;

import ua.com.magsumova.diana.island.animal.Animal;
import ua.com.magsumova.diana.island.animal.Characteristic;
import ua.com.magsumova.diana.island.animal.herbivore.herbivoreList.Caterpillar;
import ua.com.magsumova.diana.island.animal.herbivore.herbivoreList.Duck;
import ua.com.magsumova.diana.island.animal.herbivore.herbivoreList.Mouse;
import ua.com.magsumova.diana.island.animal.herbivore.herbivoreList.Rabbit;
import ua.com.magsumova.diana.island.animal.predator.Predator;

import java.util.Map;


@Characteristic(weight = 8, maxSatiety = 2, maxOnOneLocation = 30, possibleDistance = 2)
public class Fox extends Predator {
    private static final Map<Class<? extends Animal>, Integer> CHANCE_TO_EAT =
            Map.of(Rabbit.class, 70, Mouse.class, 90, Duck.class, 60, Caterpillar.class, 40);

    @Override
    public Map<Class<? extends Animal>, Integer> getChanceToEat() {
        return CHANCE_TO_EAT;
    }

    @Override
    public String toString() {
        return "Fox";
    }


}
