package utils;

import java.util.Arrays;
import java.util.Random;

public class StrengthGenerator {

    private int maxStrength;

    private Random random = new Random();

    public StrengthGenerator(int maxStrength) {

        this.maxStrength = maxStrength;
    }

    public double generateStrength() {

        int strength = random.nextInt(this.maxStrength);

        return strength;
    }

    public double generateStrengthWithMedian() {

        int firstNum = random.nextInt(this.maxStrength);

        int half = maxStrength / 2;

        double finalNumber;
        int subtract;

        if (firstNum <= half) {

            subtract = half - firstNum;
            finalNumber = (random.nextDouble() * subtract) + firstNum;

        } else {

            subtract = firstNum - half;
            finalNumber = firstNum - (random.nextDouble() * subtract);
        }

        return finalNumber;
    }

    public void generateStatistics(int numOfTries) {
        this.generateStatistics(numOfTries, true, false);
    }

    public void generateStatistics(int numOfTries, boolean median, boolean advancedStats) {

        int[] numLayout = new int[10];
        Arrays.fill(numLayout, 0);

        double worst5 = 0;
        double worst15 = 0;

        double best5 = 0;
        double best15 = 0;

        double mid10 = 0;


        double maxStrength = this.maxStrength;

        for (int i = 0; i < numOfTries; i++) {

            double finalNumber;

            if (median) {
                finalNumber = this.generateStrengthWithMedian();
            } else {
                finalNumber = this.generateStrength();
            }

            if (finalNumber < maxStrength/10) {
                numLayout[0]++;
            } else if (finalNumber >= (maxStrength/10) && finalNumber < (maxStrength*2/10)) {
                numLayout[1]++;
            } else if (finalNumber >= (maxStrength*2/10) && finalNumber < (maxStrength*3/10)) {
                numLayout[2]++;
            } else if (finalNumber >= (maxStrength*3/10) && finalNumber < (maxStrength*4/10)) {
                numLayout[3]++;
            } else if (finalNumber >= (maxStrength*4/10) && finalNumber < (maxStrength*5/10)) {
                numLayout[4]++;
            } else if (finalNumber >= (maxStrength*5/10) && finalNumber < (maxStrength*6/10)) {
                numLayout[5]++;
            } else if (finalNumber >= (maxStrength*6/10) && finalNumber < (maxStrength*7/10)) {
                numLayout[6]++;
            } else if (finalNumber >= (maxStrength*7/10) && finalNumber < (maxStrength*8/10)) {
                numLayout[7]++;
            } else if (finalNumber >= (maxStrength*8/10) && finalNumber < (maxStrength*9/10)) {
                numLayout[8]++;
            } else {
                numLayout[9]++;
            }

            if (finalNumber < maxStrength/20*3) {
                worst15++;
                if (finalNumber < maxStrength/20) {
                    worst5++;
                }
            } else if (finalNumber >= (maxStrength/20*9) && finalNumber < (maxStrength/20*11)) {
                mid10++;
            } else if (finalNumber >= (maxStrength/20*17)) {
                best15++;
                if (finalNumber >= (maxStrength/20*19)) {
                    best5++;
                }
            }

        }
        for (int i = 0; i < 10; i++) {
            System.out.println(numLayout[i]);
        }

        if (advancedStats) {

            System.out.println("Number in worst 5 = " + worst5 + " what is " + (worst5 / numOfTries * 100) + "%");
            System.out.println("Number in worst 15 = " + worst15 + " what is " + (worst15 / numOfTries * 100) + "%");
            System.out.println("Number in mid 10 = " + mid10 + " what is " + (mid10 / numOfTries * 100) + "%");
            System.out.println("Number in best 15 = " + best15 + " what is " + (best15 / numOfTries * 100) + "%");
            System.out.println("Number in best 5 = " + best5 + " what is " + (best5 / numOfTries * 100) + "%");
        }


    }

}
