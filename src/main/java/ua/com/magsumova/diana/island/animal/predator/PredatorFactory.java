package ua.com.magsumova.diana.island.animal.predator;

import ua.com.magsumova.diana.island.animal.AnimalFactory;
import ua.com.magsumova.diana.island.animal.AnimalTypes;
import ua.com.magsumova.diana.island.animal.predator.predatorList.Bear;
import ua.com.magsumova.diana.island.animal.predator.predatorList.Boa;
import ua.com.magsumova.diana.island.animal.predator.predatorList.Eagle;
import ua.com.magsumova.diana.island.animal.predator.predatorList.Fox;
import ua.com.magsumova.diana.island.animal.predator.predatorList.Wolf;

public class PredatorFactory implements AnimalFactory {
    public Predator createAnimal (AnimalTypes type) {
        Predator predator;
        switch (type) {
            case BEAR -> predator = new Bear();
            case BOA -> predator = new Boa();
            case EAGLE -> predator = new Eagle();
            case FOX -> predator = new Fox();
            case WOLF -> predator = new Wolf();
            default -> predator = null;
        }
        return predator;
    }
}
