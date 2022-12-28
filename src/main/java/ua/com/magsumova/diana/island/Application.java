package ua.com.magsumova.diana.island;

import ua.com.magsumova.diana.island.island.Island;
import ua.com.magsumova.diana.island.island.Location;
import ua.com.magsumova.diana.island.thread.Delay;
import ua.com.magsumova.diana.island.thread.LifeCycle;
import ua.com.magsumova.diana.island.thread.PlantGrowth;
import ua.com.magsumova.diana.island.thread.PropertiesReader;
import ua.com.magsumova.diana.island.thread.Statistic;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Application {
    public static void main(String[] args) {
        int length = PropertiesReader.getProperty("length");
        int width = PropertiesReader.getProperty("width");

        System.out.println("Welcome to the game");
        System.out.println("Lets play");

        System.out.println("Island size: " + length + " on " + width);

        Island island = new Island(length, width);
        island.initialize();

        ScheduledExecutorService executorStat = Executors.newScheduledThreadPool(1);
        ScheduledExecutorService executorLifeCycle = Executors.newScheduledThreadPool(1);
        ScheduledExecutorService executorPlantGrowth = Executors.newScheduledThreadPool(1);

        executorStat.scheduleWithFixedDelay(new Statistic(island), 1, 1, TimeUnit.SECONDS);

        for (int i = 0; i < island.getLocations().length; i++) {
            for (int j = 0; j < island.getLocations()[i].length; j++) {
                Location location = island.getLocations()[i][j];
                executorLifeCycle.scheduleWithFixedDelay(new LifeCycle(location, island), 2, 1, TimeUnit.SECONDS);
                executorPlantGrowth.scheduleWithFixedDelay(new PlantGrowth(location), 3, 3, TimeUnit.SECONDS);
            }
        }

        while (true) {
            Delay.sleep(3000);
            if (island.getCountAnimals() == 0) {
                break;
            }
        }
        executorLifeCycle.shutdown();
        executorStat.shutdown();
        executorPlantGrowth.shutdown();
        System.out.println("All the animals died!");
        System.out.println("**********************************");
        System.out.println("End of the game!");
    }


}
