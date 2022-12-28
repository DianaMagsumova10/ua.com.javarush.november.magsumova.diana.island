package ua.com.magsumova.diana.island.animal.herbivore;

import ua.com.magsumova.diana.island.animal.AnimalFactory;
import ua.com.magsumova.diana.island.animal.AnimalTypes;
import ua.com.magsumova.diana.island.animal.herbivore.herbivoreList.Boar;
import ua.com.magsumova.diana.island.animal.herbivore.herbivoreList.Buffalo;
import ua.com.magsumova.diana.island.animal.herbivore.herbivoreList.Caterpillar;
import ua.com.magsumova.diana.island.animal.herbivore.herbivoreList.Deer;
import ua.com.magsumova.diana.island.animal.herbivore.herbivoreList.Duck;
import ua.com.magsumova.diana.island.animal.herbivore.herbivoreList.Goat;
import ua.com.magsumova.diana.island.animal.herbivore.herbivoreList.Horse;
import ua.com.magsumova.diana.island.animal.herbivore.herbivoreList.Mouse;
import ua.com.magsumova.diana.island.animal.herbivore.herbivoreList.Rabbit;
import ua.com.magsumova.diana.island.animal.herbivore.herbivoreList.Sheep;

public class HerbivoreFactory implements AnimalFactory {
    public Herbivore createAnimal (AnimalTypes type) {
        Herbivore herbivore;
        switch (type) {
            case BOAR -> herbivore = new Boar();
            case BUFFALO -> herbivore = new Buffalo();
            case CATERPILLAR -> herbivore = new Caterpillar();
            case DEER -> herbivore = new Deer();
            case DUCK -> herbivore = new Duck();
            case GOAT -> herbivore = new Goat();
            case HORSE -> herbivore = new Horse();
            case MOUSE -> herbivore = new Mouse();
            case RABBIT -> herbivore = new Rabbit();
            case SHEEP -> herbivore = new Sheep();
            default -> herbivore = null;
        }
        return herbivore;
    }
}
