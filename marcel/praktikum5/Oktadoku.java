import java.util.BitSet;

import gdp.stdlib.StdIn;

public class Oktadoku {
    public enum Variante {
        normal, mitDiagonalen
    }

    private static final int NUMOFCELLSPERROWBLOCK = 4;
    private static final int NUMOFCELLSPERCOLBLOCK = 2;

    private Variante v;
    // was sonst noch noetig ist …
    char[][] puzzle;

    public Oktadoku(Variante var) {
        /* TODO */ }

    public void read() {
        puzzle = new char[8][8];
        for (int y = 0; y < puzzle[0].length; y++) {
            for (int x = 0; x < puzzle.length; x++) {
                char ch = StdIn.readChar();
                puzzle[x][y] = ch != '0' && ch != '.' ? ch : ' ';
            }
            StdIn.readChar();
        }
    }

    public void write() {
        for (int y = 0; y < puzzle[0].length; y++) {
            if (y % NUMOFCELLSPERROWBLOCK == 0) {
                System.out.println("+-----+-----+-----+-----+");
            }
            for (int x = 0; x < puzzle.length; x++) {
                if (x % NUMOFCELLSPERCOLBLOCK == 0) {
                    System.out.print("| ");
                }
                System.out.print(puzzle[x][y] + " ");

            }
            System.out.print("|\n");
        }
        System.out.println("+-----+-----+-----+-----+");
    }

    public boolean check() {
        return checkRows() && checkColumns() && checkBlocks();
    }

    public void solve() {
        /* TODO */ }

    // -----------------------------------------
    public boolean checkRows() {
        for (int row = 0; row < puzzle[0].length; row++) {
            BitSet numberWasInRow = new BitSet(); // TODO hier einen besseren namen
            for (int col = 0; col < puzzle.length; col++) {
                int currentNumber = puzzle[col][row] != ' ' ? Integer.parseInt(puzzle[col][row] + "") : 0;
                if (numberWasInRow.get(currentNumber) == true && currentNumber != 0)
                    return false;
                numberWasInRow.set(currentNumber, true);
            }
        }
        return true;
    }

    public boolean checkColumns() {
        for (int col = 0; col < puzzle.length; col++) {
            BitSet numberWasInCol = new BitSet(); // TODO hier einen besseren namen
            for (int row = 0; row < puzzle[0].length; row++) {
                int currentNumber = puzzle[col][row] != ' ' ? Integer.parseInt(puzzle[col][row] + "") : 0;
                if (numberWasInCol.get(currentNumber) == true && currentNumber != 0)
                    return false;
                numberWasInCol.set(currentNumber, true);
            }
        }
        return true;
    }

    public boolean checkBlocks() {
        for (int rowBlockIndex = 0; rowBlockIndex < puzzle[0].length / NUMOFCELLSPERROWBLOCK; rowBlockIndex++) {
            for (int colBlockIndex = 0; colBlockIndex < puzzle.length / NUMOFCELLSPERCOLBLOCK; colBlockIndex++) {
                if (!checkBlock(rowBlockIndex, colBlockIndex))
                    return false;
            }
        }
        return true;
    }

    public boolean checkBlock(int rowBlockIndex, int colBlockIndex) {
        BitSet numberWasInBlock = new BitSet(); // TODO hier einen besseren namen
        for (int rowInBlockIndex = 0; rowInBlockIndex < NUMOFCELLSPERROWBLOCK; rowInBlockIndex++) {
            for (int colInBlockIndex = 0; colInBlockIndex < NUMOFCELLSPERCOLBLOCK; colInBlockIndex++) {
                int col = colBlockIndex * NUMOFCELLSPERCOLBLOCK + colInBlockIndex;
                int row = rowBlockIndex * NUMOFCELLSPERROWBLOCK + rowInBlockIndex;

                int currentNumber = puzzle[col][row] != ' ' ? Integer.parseInt(puzzle[col][row] + "") : 0;
                if (numberWasInBlock.get(currentNumber) == true && currentNumber != 0)
                    return false;
                numberWasInBlock.set(currentNumber, true);
            }
        }
        return true;
    }

}
