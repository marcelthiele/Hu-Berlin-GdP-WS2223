import java.util.BitSet;

import gdp.stdlib.StdIn;

public class Oktadoku {
    public enum Variante {
        normal, mitDiagonalen
    };

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
            if (y % 4 == 0) {
                System.out.println("+-----+-----+-----+-----+");
            }
            for (int x = 0; x < puzzle.length; x++) {
                if (x % 2 == 0) {
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
        return true;
    }

}
