package individuals;

import utils.Coordinates;
import utils.StrengthGenerator;

public class Person implements Creature{

    private int personNumber;

    private int maxHungerBar = 100;
    private int maxHydrationBar = 100;
    private int maxEnergyBar = 100;
    private double maxHealthBar = 100;

    private int hungerBar = 100;
    private int hydrationBar = 100;
    private int energyBar = 100;
    private double healthBar = 100;

    private Sex sex;
    private final Species kind = Species.HUMAN;

    private double strength;
    private double intelligence;
    private int sight = 2;

    private Coordinates coordinates;

    public Person(int personNumber, Sex sex, Coordinates coordinates) {

        this.personNumber = personNumber;
        this.sex = sex;
        this.coordinates = coordinates;

        StrengthGenerator generator = new StrengthGenerator(100);

        this.strength = generator.generateStrengthWithMedian();
        this.intelligence = generator.generateStrengthWithMedian();
    }

    public Person(int personNumber, Sex sex, Coordinates coordinates, double strength, double intelligence) {

        this.personNumber = personNumber;
        this.sex = sex;
        this.coordinates = coordinates;
        this.strength = strength;
        this.intelligence = intelligence;

    }

    public int getPersonNumber() {
        return personNumber;
    }

    public void setPersonNumber(int personNumber) {
        this.personNumber = personNumber;
    }

    public int getMaxHungerBar() {
        return maxHungerBar;
    }

    public void setMaxHungerBar(int maxHungerBar) {
        this.maxHungerBar = maxHungerBar;
    }

    public int getMaxHydrationBar() {
        return maxHydrationBar;
    }

    public void setMaxHydrationBar(int maxHydrationBar) {
        this.maxHydrationBar = maxHydrationBar;
    }

    public int getMaxEnergyBar() {
        return maxEnergyBar;
    }

    public void setMaxEnergyBar(int maxEnergyBar) {
        this.maxEnergyBar = maxEnergyBar;
    }

    public double getMaxHealthBar() {
        return maxHealthBar;
    }

    public void setMaxHealthBar(double maxHealthBar) {
        this.maxHealthBar = maxHealthBar;
    }

    public int getHungerBar() {
        return hungerBar;
    }

    public void setHungerBar(int hungerBar) {
        this.hungerBar = hungerBar;
    }

    public int getHydrationBar() {
        return hydrationBar;
    }

    public void setHydrationBar(int hydrationBar) {
        this.hydrationBar = hydrationBar;
    }

    public int getEnergyBar() {
        return energyBar;
    }

    public void setEnergyBar(int energyBar) {
        this.energyBar = energyBar;
    }

    public double getHealthBar() {
        return healthBar;
    }

    public void setHealthBar(double healthBar) {
        this.healthBar = healthBar;
    }

    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    public double getIntelligence() {
        return intelligence;
    }

    public void setIntelligence(double intelligence) {
        this.intelligence = intelligence;
    }

    public int getSight() {
        return sight;
    }

    public void setSight(int sight) {
        this.sight = sight;
    }

    @Override
    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    @Override
    public Coordinates getCoordinates() {
        return this.coordinates;
    }


    @Override
    public Species getKind() {
        return this.kind;
    }

    @Override
    public void setStrength(double strength) {
        this.strength = strength;
    }

    @Override
    public double getStrength() {
        return this.strength;
    }


    public int subtractHungerBar(int subtract) {
        this.hungerBar = hungerBar - subtract;
        if (this.hungerBar < 0) {
            this.hungerBar = 0;
        }
        return this.hungerBar;
    }

    public void addHungerBar(int add) {
        this.hungerBar = hungerBar + add;
        if (this.hungerBar > maxHungerBar) {
            this.hungerBar = maxHungerBar;
        }
    }

    public int subtractHydrationBar(int subtract) {
        this.hydrationBar = hydrationBar - subtract;
        if (this.hydrationBar < 0) {
            this.hydrationBar = 0;
        }
        return this.hydrationBar;
    }

    public void addHydrationBar(int add) {
        this.hydrationBar = hydrationBar + add;
        if (this.hydrationBar > maxHungerBar) {
            this.hydrationBar = maxHydrationBar;
        }
    }

    public int subtractEnergyBar(int subtract) {
        this.energyBar = energyBar - subtract;
        if (this.energyBar < 0) {
            this.energyBar = 0;
        }
        return this.energyBar;
    }

    public void addEnergyBar(int add) {
        this.energyBar = energyBar + add;
        if (this.energyBar > maxEnergyBar) {
            this.energyBar = maxEnergyBar;
        }
    }

    public double subtractHealthBar(double subtract) {
        this.healthBar = healthBar - subtract;
        if (this.healthBar < 0) {
            this.healthBar = 0;
        }
        return this.healthBar;
    }

    public void addHealthBar(double add) {
        this.healthBar = healthBar + add;
        if (this.healthBar > maxHealthBar) {
            this.healthBar = maxHealthBar;
        }
    }

    public double subtractMaxHealthBar(double subtract) {
        this.maxHealthBar = maxEnergyBar - subtract;
        if (this.maxHealthBar < 0) {
            this.maxHealthBar = 0;
        }
        return maxHealthBar;
    }
}

