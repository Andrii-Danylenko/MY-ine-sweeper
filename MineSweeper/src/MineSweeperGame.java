import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import java.util.Stack;

public class MineSweeperGame implements MineSweeper {
    private final int x;
    private final int y;
    private int minesCount;
    private final int mineGenerationProbability;
    private Cell[][] emptyField;
    private Cell[][] filledField;

    public MineSweeperGame(int x, int y, Difficulties difficulty) {
        this.x = x;
        this.y = y;
        this.mineGenerationProbability = difficulty.getMineGenerationProbability();
        createEmptyField();
    }

    public void createEmptyField() {
        emptyField = new Cell[x][y];
        for (int height = 0; height < x; height++) {
            for (int width = 0; width < y; width++) {
                emptyField[height][width] = new Cell(height, width);
            }
        }
    }

    public void displayField(Cell[][] field) {
        System.out.println("   1 2 3 4 5 6 7 8 9 10\n _______________________");
        for (int height = 0; height < x; height++) {
            System.out.print(" | ");
            for (int width = 0; width < y; width++) {
                System.out.print(field[height][width] + " ");
            }
            System.out.print("| " + (height + 1));
            System.out.println();
        }
        System.out.println(" -----------------------");
    }

    public void generateFilledField(int inputX, int inputY) {
        filledField = new Cell[x][y];
        Random random = new Random();
        for (int height = 0; height < x; height++) {
            for (int width = 0; width < y; width++) {
                int randInt = random.ints(0, 100).findFirst().getAsInt();
                if (randInt < mineGenerationProbability && !(height == inputX && width == inputY)) {
                    filledField[height][width] = new Cell(height, width, true);
                    minesCount++;
                }
                else {
                    filledField[height][width] = new Cell(height, width);
                }
            }
        }
    }

    @Override
    public void reveal(int x, int y) {
        emptyField[x][y].setIdentity(filledField[x][y].getIdentity());
    }

    public void fillFieldWithNums() {
        for (int height = 0; height < x; height++) {
            for (int width = 0; width < y; width++) {
                int nearbyMines = getNearByMines(height, width);
                if (nearbyMines != -1) {
                    filledField[height][width].setIdentity((char) (nearbyMines + '0'));
                }
            }
        }
    }

    private int getNearByMines(int x, int y) {
        if (isMine(x, y)) return -1;
        int mineCount = 0;
        for (int height = x - 1; height <= x + 1; height++) {
            for (int width = y - 1; width <= y + 1; width++) {
                if (height >= 0 && height < filledField.length && width >= 0 && width < filledField[0].length) {
                    if (filledField[height][width].getIdentity() == '*') mineCount++;
                }
            }
        }
        return mineCount;
    }

    private boolean isMine(int x, int y) {
        return filledField[x][y].getIdentity() == '*';
    }

    private void gameEnd(boolean hasWon) {
        if (!hasWon) {
            System.out.println("Boom! You are dead!");
        } else {
            System.out.println("Congratulations! You have won!");
        }
        System.exit(0);
    }

    public void revealArea(int x, int y) {
        Stack<Cell> cells = new Stack<>();
        Set<Cell> visited = new HashSet<>();
        cells.push(filledField[x][y]);
        do {
            Cell cell = cells.pop();
            if (!visited.contains(cell)) {
                revealAreaHelper(cell, cells, visited);
            }
        } while (!cells.isEmpty());
    }

    private void revealAreaHelper(Cell cell, Stack<Cell> cells, Set<Cell> visited) {
        visited.add(cell);
        reveal(cell.getCoordX(), cell.getCoordY());
        int x = cell.getCoordX();
        int y = cell.getCoordY();
        for (int height = x - 1; height <= x + 1; height++) {
            for (int width = y - 1; width <= y + 1; width++) {
                if (height >= 0 && height < filledField.length &&
                        width >= 0 && width < filledField[0].length) {
                    Cell cell1 = filledField[height][width];
                    if (cell1.getIdentity() == '0' && !visited.contains(cell1)) {
                        cells.push(cell1);
                    }
                    else if (!cell1.isBomb()) {
                        reveal(cell1.getCoordX(), cell1.getCoordY());
                    }
                }
            }
        }
    }

    public Cell[][] getEmptyField() {
        return emptyField;
    }

    public Cell[][] getFilledField() {
        return filledField;
    }
}
