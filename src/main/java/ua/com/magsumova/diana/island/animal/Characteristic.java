package ua.com.magsumova.diana.island.animal;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface Characteristic {
    double weight();
    double maxSatiety();
    int maxOnOneLocation();
    int possibleDistance() default 0;

}
