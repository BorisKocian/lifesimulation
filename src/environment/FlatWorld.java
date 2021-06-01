package environment;


import individuals.Creature;
import individuals.Species;
import utils.Coordinates;
import utils.GenerateCellType;

import java.lang.reflect.Array;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Random;

public class FlatWorld {

    private int xSize;
    private int ySize;

    private int waterCells = 0;
    private int dangerCells = 0;
    private int landCells = 0;


    private Cell world[][];

    private boolean isInitialized = false;


    private ArrayList<Cell> cellsWithFood = new ArrayList<>();


    public FlatWorld(int xSize, int ySize) {

        this.xSize = xSize;
        this.ySize = ySize;
        world = new Cell[xSize][ySize];

        for (int x = 0; x < xSize; x++) {
            for (int y = 0; y < ySize; y++) {
                world[x][y] = new Cell();
            }
        }
    }


    public int getXSize() {
        return xSize;
    }

    public void setXSize(int xSize) {
        this.xSize = xSize;
    }

    public int getYSize() {
        return ySize;
    }

    public void setYSize(int ySize) {
        this.ySize = ySize;
    }

    public Cell[][] getWorld() {
        return world;
    }


    public void initializeWorld() {

        GenerateCellType gct = new GenerateCellType();

        for (int x = 0; x < xSize; x++) {
            for (int y = 0; y < ySize; y++) {

                Cell currCell = this.world[x][y];

                if (y == 0) {
                    if (x == 0) {
                        currCell.setType(gct.generateRandomCellType());
                    } else {
                        if (this.world[x-1][y].getType() == CellType.DANGER) {
                            currCell.setType(gct.generateNearDangerCellType());
                        } else if (this.world[x-1][y].getType() == CellType.WATER) {
                            currCell.setType(gct.generateNearWaterCellType());
                        } else {
                            currCell.setType(gct.generateRandomCellType());
                        }
                    }
                } else {
                    if (x == 0) {
                        if (this.world[x][y-1].getType() == CellType.DANGER) {
                            currCell.setType(gct.generateNearDangerCellType());
                        } else if (this.world[x][y-1].getType() == CellType.WATER) {
                            currCell.setType(gct.generateNearWaterCellType());
                        } else {
                            currCell.setType(gct.generateRandomCellType());
                        }
                    } else {
                        if (this.world[x-1][y].getType() == CellType.WATER) {
                            if (this.world[x][y-1].getType() == CellType.WATER) {
                                currCell.setType(gct.generateNearDoubleWaterCellType());
                            } else if (this.world[x][y-1].getType() == CellType.DANGER) {
                                currCell.setType(gct.generateNearWaterDangerCellType());
                            } else {
                                currCell.setType(gct.generateNearWaterCellType());
                            }
                        }
                        if (this.world[x-1][y].getType() == CellType.DANGER) {
                            if (this.world[x][y-1].getType() == CellType.DANGER) {
                                currCell.setType(gct.generateNearDoubleDangerCellType());
                            } else if (this.world[x][y-1].getType() == CellType.WATER) {
                                currCell.setType(gct.generateNearWaterDangerCellType());
                            } else {
                                currCell.setType(gct.generateNearDangerCellType());
                            }
                        }
                        if (this.world[x-1][y].getType() == CellType.LAND) {
                            if (this.world[x][y-1].getType() == CellType.WATER) {
                                currCell.setType(gct.generateNearWaterCellType());
                            } else if (this.world[x][y-1].getType() == CellType.DANGER) {
                                currCell.setType(gct.generateNearDangerCellType());
                            } else {
                                currCell.setType(gct.generateRandomCellType());
                            }
                        }
                    }
                }

                if (currCell.getType() == CellType.DANGER) {
                    dangerCells++;
                } else if (currCell.getType() == CellType.WATER) {
                    waterCells++;
                } else if (currCell.getType() == CellType.LAND) {
                    landCells++;
                }
            }
        }

        isInitialized = true;

    }

    public void showWorldStatistics() {

        if (!isInitialized) {
            try {
                throw new Exception("World is not initialized");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        int allCells = xSize * ySize;

        System.out.println("Total cells: " + (xSize*ySize));
        System.out.println("Water cells: " + waterCells + " what is cca " + (waterCells * 100) / allCells + "%");
        System.out.println("Danger cells: " + dangerCells + " what is cca " + (dangerCells * 100) / allCells + "%");
        System.out.println("Land cells: " + landCells + " what is cca " + (landCells * 100) / allCells + "%");
        System.out.println("Cells with food: " + cellsWithFood.size() + " what is cca " + (cellsWithFood.size() * 100) / allCells + "%");

    }

    public void depictWorld() {

        for (int x = 0; x < xSize; x++) {
            for (int y = 0; y < ySize; y++) {

                Cell currCell = this.getWorld()[x][y];

                if (currCell.getCreature() != null && currCell.getCreature().getKind() == Species.HUMAN) {
                    System.out.print("B ");
                    break;
                }
                if (currCell.getType() == CellType.LAND) {
                    if (currCell.getFood() != null) {
                        System.out.print("F ");
                    } else {
                        System.out.print("L ");
                    }
                } else if (currCell.getType() == CellType.WATER) {
                    System.out.print("W ");
                } else if (currCell.getType() == CellType.DANGER) {
                    System.out.print("D ");
                } else {
                    System.out.print("U ");
                }
            }
            System.out.println("");
        }
    }

    public void generateFood(int amountOfFood, int foodCalories, boolean random, boolean nearWater) {

        if (! isInitialized) {
            try {
                throw new Exception("World is not initialized");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        double amountOfFoodDouble = amountOfFood;
        int foodToShare = amountOfFood;

        while (foodToShare >= 1) {

            for (int x = 0; x < xSize; x++) {
                for (int y = 0; y < ySize; y++) {

                    Cell currCell = this.getWorld()[x][y];
                    if (currCell.getType() == CellType.LAND) {

                        Random rnd = new Random();
                        double rndDouble = rnd.nextDouble();

                        if (rndDouble <= (amountOfFoodDouble / landCells)) {
                            currCell.setFood(new Food(foodCalories));
                            cellsWithFood.add(currCell);
                            foodToShare--;
                        }
                    }
                    if (foodToShare < 1) {
                        break;
                    }
                }
                if (foodToShare < 1) {
                    break;
                }
            }
        }
    }

    public void removeAllFood() {

        Iterator<Cell> iterator = cellsWithFood.iterator();

         while (iterator.hasNext()) {
             iterator.next().setFood(null);
         }

         cellsWithFood.clear();
    }

    public void addCreature(Creature creature, Coordinates coordinates) {

        this.getWorld()[coordinates.getX()][coordinates.getY()].setCreature(creature);
    }

}
