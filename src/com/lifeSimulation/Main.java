package com.lifeSimulation;

import environment.Cell;
import environment.CellType;
import environment.FlatWorld;
import environment.Food;
import individuals.Person;
import individuals.PersonImpl;
import individuals.Sex;
import utils.Coordinates;
import utils.StrengthGenerator;

import java.util.Arrays;
import java.util.Random;

public class Main {

    public static void main(String[] args) {

        System.out.println("Hello");



        FlatWorld world = new FlatWorld(10,10);

        PersonImpl perImpl = new PersonImpl(1, world);


        world.initializeWorld();

        world.generateFood(10,50,true,false);

        world.showWorldStatistics();

        world.depictWorld();


        Coordinates coordinates = new Coordinates(3, 3);
        Person person1 = new Person(1, Sex.MALE, coordinates);
        world.addCreature(person1, coordinates);

        world.depictWorld();

        perImpl.doRandomStep(person1);

        world.depictWorld();




        // StrengthGenerator sg = new StrengthGenerator(100);

        // sg.generateStatistics(1000, true, true);

    }
}
