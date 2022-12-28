package ua.com.magsumova.diana.island.plant;


import ua.com.magsumova.diana.island.animal.Characteristic;
import ua.com.magsumova.diana.island.exception.AnnotationException;

import java.util.Objects;
import java.util.stream.Collector;
@Characteristic(weight = 50, maxSatiety = 0, maxOnOneLocation = 200)
public class Plant {
    public Plant create() {
        return new Plant();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        return o != null && getClass() == o.getClass();
    }

    @Override
    public int hashCode() {
        return Objects.hash();
    }

    @Override
    public String toString() {
        return "Plant";
    }

    public double getWeight() {
        return this.getCharacteristics().weight();
    }

    private Characteristic getCharacteristics() {
        if (!this.getClass().isAnnotationPresent(Characteristic.class)){
            throw new AnnotationException("Missing annotation " + Collector.Characteristics.class +" for " + this.getClass().getName());
        }
        return this.getClass().getAnnotation(Characteristic.class);
    }
}
