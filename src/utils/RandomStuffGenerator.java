package utils;

import individuals.Sex;

import java.util.Random;

public class RandomStuffGenerator {

    Random random = new Random();

    public Sex randomSexGenerator() {

        if (random.nextDouble() <= 0.5) {
            return Sex.FEMALE;
        } else {
            return Sex.MALE;
        }
    }
}
