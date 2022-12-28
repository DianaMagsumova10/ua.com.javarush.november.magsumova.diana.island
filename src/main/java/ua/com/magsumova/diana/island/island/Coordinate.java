package ua.com.magsumova.diana.island.island;

import lombok.Getter;

@Getter
public class Coordinate {
    private final int x;
    private final int y;

    public Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
