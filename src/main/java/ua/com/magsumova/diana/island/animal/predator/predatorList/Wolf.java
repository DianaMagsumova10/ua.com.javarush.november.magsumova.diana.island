package ua.com.magsumova.diana.island.animal.predator.predatorList;

import ua.com.magsumova.diana.island.animal.Animal;
import ua.com.magsumova.diana.island.animal.Characteristic;
import ua.com.magsumova.diana.island.animal.herbivore.herbivoreList.Boar;
import ua.com.magsumova.diana.island.animal.herbivore.herbivoreList.Buffalo;
import ua.com.magsumova.diana.island.animal.herbivore.herbivoreList.Deer;
import ua.com.magsumova.diana.island.animal.herbivore.herbivoreList.Duck;
import ua.com.magsumova.diana.island.animal.herbivore.herbivoreList.Goat;
import ua.com.magsumova.diana.island.animal.herbivore.herbivoreList.Mouse;
import ua.com.magsumova.diana.island.animal.herbivore.herbivoreList.Rabbit;
import ua.com.magsumova.diana.island.animal.herbivore.herbivoreList.Sheep;
import ua.com.magsumova.diana.island.animal.predator.Predator;

import java.util.List;
import java.util.Map;

@Characteristic(weight = 50, maxSatiety = 8, maxOnOneLocation = 30, possibleDistance = 3)
public class Wolf extends Predator {
    private static final Map<Class<? extends Animal>, Integer> CHANCE_TO_EAT =
            Map.of(Deer.class, 15, Rabbit.class, 60, Mouse.class, 80, Goat.class, 60,
                    Sheep.class, 70, Boar.class, 15, Buffalo.class, 10, Duck.class, 40);

    @Override
    public Map<Class<? extends Animal>, Integer> getChanceToEat() {
        return CHANCE_TO_EAT;
    }

    @Override
    public String toString() {
        return "Wolf";
    }


}
