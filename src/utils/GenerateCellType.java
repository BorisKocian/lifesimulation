package utils;

import environment.Cell;
import environment.CellType;

import java.util.Random;

public class GenerateCellType {

    private Random random = new Random();

    public CellType generateRandomCellType() {

        double rndNum = random.nextDouble();

        if (rndNum < 0.01) {
            return CellType.DANGER;
        } else if (rndNum < 0.03) {
            return CellType.WATER;
        } else {
            return CellType.LAND;
        }
    }

    public CellType generateNearWaterCellType() {

        double rndNum = random.nextDouble();

        if (rndNum < 0.01) {
            return CellType.DANGER;
        } else if (rndNum < 0.41) {
            return CellType.WATER;
        } else {
            return CellType.LAND;
        }
    }

    public CellType generateNearDangerCellType() {

        double rndNum = random.nextDouble();

        if (rndNum < 0.2) {
            return CellType.DANGER;
        } else if (rndNum < 0.22) {
            return CellType.WATER;
        } else {
            return CellType.LAND;
        }
    }

    public CellType generateNearWaterDangerCellType() {

        double rndNum = random.nextDouble();

        if (rndNum < 0.2) {
            return CellType.DANGER;
        } else if (rndNum < 0.6) {
            return CellType.WATER;
        } else {
            return CellType.LAND;
        }
    }

    public CellType generateNearDoubleWaterCellType() {

        double rndNum = random.nextDouble();

        if (rndNum < 0.01) {
            return CellType.DANGER;
        } else if (rndNum < 0.81) {
            return CellType.WATER;
        } else {
            return CellType.LAND;
        }
    }

    public CellType generateNearDoubleDangerCellType() {

        double rndNum = random.nextDouble();

        if (rndNum < 0.8) {
            return CellType.DANGER;
        } else if (rndNum < 0.82) {
            return CellType.WATER;
        } else {
            return CellType.LAND;
        }
    }
}
