package individuals;

import utils.Coordinates;

public class Animal implements Creature {


    private Coordinates coordinates;

    private final Species kind = Species.ANIMAL;

    private double strength;



    @Override
    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    @Override
    public Coordinates getCoordinates() {
        return null;
    }


    @Override
    public Species getKind() {
        return null;
    }

    @Override
    public void setStrength(double strength) {
        this.strength = strength;
    }

    @Override
    public double getStrength() {
        return 0;
    }
}
