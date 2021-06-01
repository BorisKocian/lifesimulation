package environment;

import individuals.Animal;
import individuals.Creature;
import individuals.Person;

import java.util.ArrayList;

public class Cell {


    private CellType type = CellType.UNDEFINED;

    private Food food;
    private Creature creature;


    public CellType getType() {
        return type;
    }

    public void setType(CellType type) {
        this.type = type;
    }

    public Food getFood() {
        return food;
    }

    public void setFood(Food food) {
        this.food = food;
    }

    public Creature getCreature() {
        return creature;
    }

    public void setCreature(Creature creature) {
        this.creature = creature;
    }
}
