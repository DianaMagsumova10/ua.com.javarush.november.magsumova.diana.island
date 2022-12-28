package ua.com.magsumova.diana.island.island;

import lombok.Getter;
import ua.com.magsumova.diana.island.animal.Animal;
import ua.com.magsumova.diana.island.animal.AnimalFactory;
import ua.com.magsumova.diana.island.animal.AnimalTypes;
import ua.com.magsumova.diana.island.animal.Characteristic;
import ua.com.magsumova.diana.island.animal.herbivore.Herbivore;
import ua.com.magsumova.diana.island.animal.herbivore.HerbivoreFactory;
import ua.com.magsumova.diana.island.animal.predator.Predator;
import ua.com.magsumova.diana.island.animal.predator.PredatorFactory;
import ua.com.magsumova.diana.island.exception.AnnotationException;
import ua.com.magsumova.diana.island.plant.Plant;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


@Getter
public class Location {
    private final Coordinate coordinates;
    private final List<Predator> predators;
    private final List<Herbivore> herbivores;
    private final List<Plant> plants;
    private final Lock lock = new ReentrantLock(true);

    public Location(Coordinate coordinates) {
        this.coordinates = coordinates;
        predators = (List<Predator>) createAnimals(new PredatorFactory());
        herbivores = (List<Herbivore>) createAnimals(new HerbivoreFactory());
        plants = createPlants();
        Collections.shuffle(predators);
        Collections.shuffle(herbivores);
    }

    public void eating() {
        for (int i = 0; i < predators.size(); i++) {
            predators.get(i).eat(herbivores, this);
        }
        for (int i = 0; i < predators.size(); i++) {
            predators.get(i).eat(predators, this);
        }
        for (int i = 0; i < herbivores.size(); i++) {
            herbivores.get(i).eat(plants, this);
        }
    }

    public void moving(Location[][] locations) {
        predators.removeIf(predator -> predator.move(this, locations));
        herbivores.removeIf(herbivore -> herbivore.move(this, locations));
    }

    public void breeding() {
        for (int i = 0; i < predators.size(); i++) {
            if (predators.get(i).breed(this)) {
                predators.add(predators.get(i));
            }
        }
        for (int i = 0; i < herbivores.size(); i++) {
            if (herbivores.get(i).breed(this)) {
                herbivores.add(herbivores.get(i));
            }
        }
        getPredators().forEach(predator -> predator.setBreed(false));
        getHerbivores().forEach(herbivore -> herbivore.setBreed(false));
    }

    public void dying() {
        predators.removeIf(predator -> predator.die(this));
        herbivores.removeIf(herbivore -> herbivore.die(this));
    }

    public void addAnimal(Animal animal) {
        if (animal instanceof Herbivore herbivore) {
            herbivores.add(herbivore);
        } else if (animal instanceof Predator predator) {
            predators.add(predator);
        }
    }

    public int getMaxOnOneLocation(Class<?> o) {
        if (!o.isAnnotationPresent(Characteristic.class)){
            throw new AnnotationException("Missing annotation " + Characteristic.class +" for " + o.getName());
        }
        Characteristic characteristics = o.getAnnotation(Characteristic.class);
        return characteristics.maxOnOneLocation();
    }

    public int getRandomCount(int maxOnOneLocation) {
        return ThreadLocalRandom.current().nextInt(maxOnOneLocation);
    }

    private List<? extends Animal> createAnimals(AnimalFactory factory) {
        List<Animal> animalList = new ArrayList<>();
        AnimalTypes[] animalTypes = AnimalTypes.values();
        for (AnimalTypes animalType: animalTypes) {
            Animal animal = factory.createAnimal(animalType);
            if (animal == null) {
                continue;
            }
            int animalCount = getRandomCount(getMaxOnOneLocation(animal.getClass()));
            for (int i = 0; i < animalCount; i++) {
                animalList.add(factory.createAnimal(animalType));
            }
        }
        return animalList;
    }

    private List<Plant> createPlants() {
        List<Plant> plantList = new ArrayList<>();
        int plantCount = getRandomCount(getMaxOnOneLocation(Plant.class));
        for (int i = 0; i < plantCount; i++) {
            plantList.add(new Plant());
        }
        return plantList;
    }
}
