package individuals;

import utils.Coordinates;

public interface Creature {

    void setCoordinates(Coordinates coordinates);
    Coordinates getCoordinates();

    Species getKind();

    void setStrength(double strength);
    double getStrength();
}
