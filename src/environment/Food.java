package environment;

import utils.Coordinates;

public class Food {

    private int calories;

    private int durability;

    public Food(int calories) {
        this.calories = calories;
    }

    public Food(int calories, int durability) {
        this.calories = calories;
        this.durability = durability;
    }

    public int getCalories() {
        return calories;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }

    public int getDurability() {
        return durability;
    }

    public void setDurability(int durability) {
        this.durability = durability;
    }
}
