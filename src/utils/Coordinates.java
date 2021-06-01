package utils;

public class Coordinates {

    private int x;
    private int y;

    public Coordinates(int x, int y) {

        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Coordinates stepNorth() {
        this.y = y - 1;
        return this;
    }

    public Coordinates stepSouth() {
        this.y = y + 1;
        return this;
    }

    public Coordinates stepWest() {
        this.x = x - 1;
        return this;
    }

    public Coordinates stepEast() {
        this.x = x + 1;
        return this;
    }

    public Coordinates stepNorthWest() {
        this.x = x - 1;
        this.y = y - 1;
        return this;
    }

    public Coordinates stepNorthEast() {
        this.x = x + 1;
        this.y = y - 1;
        return this;
    }

    public Coordinates stepSouthWest() {
        this.x = x - 1;
        this.y = y + 1;
        return this;
    }

    public Coordinates stepSouthEast() {
        this.x = x + 1;
        this.y = y + 1;
        return this;
    }
}
