package ua.com.magsumova.diana.island.animal.herbivore.herbivoreList;

import ua.com.magsumova.diana.island.animal.Animal;
import ua.com.magsumova.diana.island.animal.Characteristic;
import ua.com.magsumova.diana.island.animal.herbivore.Herbivore;

import java.util.Map;


@Characteristic(weight = 1, maxSatiety = 0.015, maxOnOneLocation = 200, possibleDistance = 4)
public class Duck extends Herbivore {

    private static final Map<Class<? extends Animal>, Integer> CHANCE_TO_EAT =
            Map.of(Caterpillar.class, 90);

    @Override
    public Map<Class<? extends Animal>, Integer> getChanceToEat() {
        return CHANCE_TO_EAT;
    }

    @Override
    public String toString() {
        return "Duck";
    }


}
