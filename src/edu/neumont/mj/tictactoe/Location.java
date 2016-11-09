package edu.neumont.mj.tictactoe;

/**
 * Created by Jaden-Laptop on 11/7/2016.
 */
public class Location {

    public static final Location TOP_LEFT = new Location();
    public static final Location TOP_MIDDLE = new Location(1, 0);
    public static final Location TOP_RIGHT = new Location(2, 0);
    public static final Location MIDDLE_LEFT = new Location(0, 1);
    public static final Location MIDDLE_MIDDLE = new Location(1, 1);
    public static final Location MIDDLE_RIGHT = new Location(2, 1);
    public static final Location BOTTOM_LEFT = new Location(0, 2);
    public static final Location BOTTOM_MIDDLE = new Location(1, 2);
    public static final Location BOTTOM_RIGHT = new Location(2, 2);

    public int x = 0, y = 0;

    public Location() {

    }

    public Location(int x, int y) {
        if ((x < 0 || x >= 3) || (y < 0 || y >= 3))
            throw new IllegalArgumentException("Locations coordinates out of bounds: ("+x+", "+y+")");
        this.x = x;
        this.y = y;
    }

    public Location(Location other) {
        this.x = other.x;
        this.y = other.y;
    }

    public static Location add(Location a, Location b) {
        return new Location(a.x + b.x, a.y + b.y);
    }

    public Location add(Location b) {
        return add(this, b);
    }

    public static Location sub(Location a, Location b) {
        return new Location(a.x - b.x, a.y -b.y);
    }

    public Location sub(Location b) {
        return sub(this, b);
    }

    public static Location multiply(Location a, Location b) {
        return new Location(a.x * b.x, a.y * b.y);
    }

    public Location multiply(Location b) {
        return multiply(this, b);
    }

    public static Location divide(Location a, Location b) {
        if (b.x == 0 || b.y == 0)
            throw new IllegalArgumentException("Cannot divide by zero.");
        return new Location(a.x / b.x, a.y / b.y);
    }

    public Location divide(Location b) throws IllegalArgumentException {
        return divide(this, b);
    }

    public String toString() {
        return "Location: ("+x+", "+y+")";
    }

}
