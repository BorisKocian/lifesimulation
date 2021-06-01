package individuals;

import environment.Cell;
import environment.FlatWorld;
import utils.Coordinates;
import utils.RandomStuffGenerator;

import javax.swing.*;
import java.util.Random;

public class PersonImpl {

    int maxPersonNum;

    FlatWorld world;

    public PersonImpl(int maxPersonNum, FlatWorld world) {

        this.maxPersonNum = maxPersonNum;
        this.world = world;
    }

    public boolean canHaveSex(Person person) {

        return person.getEnergyBar() >= person.getMaxEnergyBar() && person.getHealthBar() >= person.getMaxHealthBar();
    }

    public void eatFood(Person person, Cell cellWithFood) {

        person.addHungerBar(cellWithFood.getFood().getCalories());
        cellWithFood.setFood(null);
    }

    public void drinkWater(Person person) {

        person.addHydrationBar(person.getMaxHydrationBar());
    }

    private double averageStrength(Person person1, Person person2) {

        return (person1.getStrength() + person2.getStrength()) / 2;
    }

    private double averageIntelligence(Person person1, Person person2) {

        return (person1.getIntelligence() + person2.getIntelligence()) / 2;
    }

    public Person haveSex(Person person1, Person person2) {
        person1.subtractEnergyBar(person1.getEnergyBar() / 2);
        person2.subtractEnergyBar(person2.getEnergyBar() / 2);

        RandomStuffGenerator randomStuffGenerator = new RandomStuffGenerator();

        Person person = new Person(maxPersonNum + 1, randomStuffGenerator.randomSexGenerator(), new Coordinates(0, 0), this.averageStrength(person1, person2), this.averageIntelligence(person1, person2));
        maxPersonNum++;
        return person;
    }

    private Coordinates nearestFood(Person person) {

        Coordinates coordinates = person.getCoordinates();
        int sight = person.getSight();

        int personX = coordinates.getX();
        int personY = coordinates.getY();

        int xSize = world.getXSize();
        int ySize = world.getYSize();

        int x = personX - sight;
        if (x < 0) {
            x = 0;
        }
        int y = personY - sight;
        if (y < 0) {
            y = 0;
        }
        int maxX = personX + sight;
        if (maxX >= xSize) {
            maxX = xSize;
        }
        int maxY = personY + sight;
        if (maxY >= ySize) {
            maxY = ySize;
        }

        for (int x1 = x; x < maxX; x1++) {
            for (int y1 = y; y < maxY; y1++) {
                break;
            }
        }
        return person.getCoordinates();
    }

    public void doRandomStep(Person person) {

        Random random = new Random();
        double rnd = random.nextDouble();

        Coordinates coordinates = person.getCoordinates();
        int x = coordinates.getX();
        int y = coordinates.getY();

        this.world.getWorld()[x][y].setCreature(null);

        if (rnd < 1.0 * 1 / 9) {
            person.getCoordinates().stepNorth();
            this.world.getWorld()[x][y-1].setCreature(person);
        } else if (rnd < 1.0 * 2 / 9) {
            person.getCoordinates().stepNorthEast();
            this.world.getWorld()[x+1][y-1].setCreature(person);
        } else if (rnd < 1.0 * 3 / 9) {
            person.getCoordinates().stepEast();
            this.world.getWorld()[x+1][y].setCreature(person);
        } else if (rnd < 1.0 * 4 / 9) {
            person.getCoordinates().stepSouthEast();
            this.world.getWorld()[x+1][y+1].setCreature(person);
        } else if (rnd < 1.0 * 5 / 9) {
            person.getCoordinates().stepSouth();
            this.world.getWorld()[x][y+1].setCreature(person);
        } else if (rnd < 1.0 * 6 / 9) {
            person.getCoordinates().stepSouthWest();
            this.world.getWorld()[x-1][y+1].setCreature(person);
        } else if (rnd < 1.0 * 7 / 9) {
            person.getCoordinates().stepWest();
            this.world.getWorld()[x-1][y].setCreature(person);
        } else if (rnd < 1.0 * 8 / 9) {
            person.getCoordinates().stepNorthWest();
            this.world.getWorld()[x-1][y-1].setCreature(person);
        } else {
            this.world.getWorld()[x][y].setCreature(person);
        }

    }

    public void makeMove(Person person) {

    }
}
