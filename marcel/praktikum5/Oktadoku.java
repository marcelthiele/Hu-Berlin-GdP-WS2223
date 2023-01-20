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
        this.v = var;
    }

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
        writeSpecific(puzzle);
    }

    private void writeSpecific(char[][] currentPuzzle) {
        System.out.print("Oktadoku");
        if(v == Variante.mitDiagonalen) System.out.print(" mit Diagonalen");
        System.out.print("\n");
        for (int y = 0; y < currentPuzzle[0].length; y++) {
            if (y % NUMOFCELLSPERROWBLOCK == 0) {
                System.out.println("+-----+-----+-----+-----+");
            }
            for (int x = 0; x < currentPuzzle.length; x++) {
                if (x % NUMOFCELLSPERCOLBLOCK == 0) {
                    System.out.print("| ");
                }
                System.out.print(currentPuzzle[x][y] + " ");

            }
            System.out.print("|\n");
        }
        System.out.println("+-----+-----+-----+-----+");
    }

    public boolean check() {
        return checkSpecificPuzzle(puzzle);
    }

    public void solve() {
        puzzle = solveRecursive(puzzle.clone());
        if (puzzle == null)
            System.out.println("Nicht loesbar :-(");
        else
            writeSpecific(puzzle);
    }

    // -----------------------------------------
    public char[][] solveRecursive(char[][] currentPuzzle) {
        if (!checkSpecificPuzzle(currentPuzzle)) {
            // System.out.println("War nicht erfolgreich");
            return null;
        }
        int[] emptyCell = getFirstEmptyCell(currentPuzzle);
        int emptyCellCol = emptyCell[0];
        int emptyCellRow = emptyCell[1];
        if (emptyCellCol == -1 && emptyCellRow == -1)
            return currentPuzzle;

        // System.out.println("found empty cell");
        for (int currentNumberToCheck = 1; currentNumberToCheck < 9; currentNumberToCheck++) {
            char[][] clonedPuzzle = copyArray(currentPuzzle);
            clonedPuzzle[emptyCellCol][emptyCellRow] = (char) (currentNumberToCheck + 48);
            // writeSpecific(clonedPuzzle);
            char[][] solvedPuzzle = solveRecursive(clonedPuzzle);
            if (solvedPuzzle != null)
                return solvedPuzzle;

        }

        return null;
    }

    public int[] getFirstEmptyCell(char[][] currentPuzzle) {
        for (int row = 0; row < currentPuzzle[0].length; row++) {
            for (int col = 0; col < currentPuzzle.length; col++) {
                if (currentPuzzle[col][row] == ' ') {
                    return new int[] { col, row };
                }
            }
        }

        return new int[] { -1, -1 };
    }

    public char[][] copyArray(char[][] arrayToCopy) {
        char[][] retArray = new char[arrayToCopy.length][arrayToCopy[0].length];

        for (int i = 0; i < retArray.length; i++) {
            for (int j = 0; j < retArray[0].length; j++) {
                retArray[i][j] = arrayToCopy[i][j];
            }
        }

        return retArray;
    }

    public boolean checkSpecificPuzzle(char[][] currentPuzzle) {
        boolean retCheck = checkRows(currentPuzzle) && checkColumns(currentPuzzle) && checkBlocks(currentPuzzle);
        if (this.v == Variante.mitDiagonalen)
            retCheck = retCheck && checkDiagonals(currentPuzzle);
        return retCheck;
    }

    public boolean checkRows(char[][] currentPuzzle) {
        for (int row = 0; row < currentPuzzle[0].length; row++) {
            BitSet numberWasInRow = new BitSet(); // TODO hier einen besseren namen
            for (int col = 0; col < currentPuzzle.length; col++) {
                int currentNumber = currentPuzzle[col][row] != ' ' ? Integer.parseInt(currentPuzzle[col][row] + "") : 0;
                if (numberWasInRow.get(currentNumber) == true && currentNumber != 0)
                    return false;
                numberWasInRow.set(currentNumber, true);
            }
        }
        return true;
    }

    public boolean checkColumns(char[][] currentPuzzle) {
        for (int col = 0; col < currentPuzzle.length; col++) {
            BitSet numberWasInCol = new BitSet(); // TODO hier einen besseren namen
            for (int row = 0; row < currentPuzzle[0].length; row++) {
                int currentNumber = currentPuzzle[col][row] != ' ' ? Integer.parseInt(currentPuzzle[col][row] + "") : 0;
                if (numberWasInCol.get(currentNumber) == true && currentNumber != 0)
                    return false;
                numberWasInCol.set(currentNumber, true);
            }
        }
        return true;
    }

    public boolean checkBlocks(char[][] currentPuzzle) {
        for (int rowBlockIndex = 0; rowBlockIndex < currentPuzzle[0].length / NUMOFCELLSPERROWBLOCK; rowBlockIndex++) {
            for (int colBlockIndex = 0; colBlockIndex < currentPuzzle.length / NUMOFCELLSPERCOLBLOCK; colBlockIndex++) {
                if (!checkBlock(currentPuzzle, rowBlockIndex, colBlockIndex))
                    return false;
            }
        }
        return true;
    }

    public boolean checkBlock(char[][] currentPuzzle, int rowBlockIndex, int colBlockIndex) {
        BitSet numberWasInBlock = new BitSet(); // TODO hier einen besseren namen
        for (int rowInBlockIndex = 0; rowInBlockIndex < NUMOFCELLSPERROWBLOCK; rowInBlockIndex++) {
            for (int colInBlockIndex = 0; colInBlockIndex < NUMOFCELLSPERCOLBLOCK; colInBlockIndex++) {
                int col = colBlockIndex * NUMOFCELLSPERCOLBLOCK + colInBlockIndex;
                int row = rowBlockIndex * NUMOFCELLSPERROWBLOCK + rowInBlockIndex;

                int currentNumber = currentPuzzle[col][row] != ' ' ? Integer.parseInt(currentPuzzle[col][row] + "") : 0;
                if (numberWasInBlock.get(currentNumber) == true && currentNumber != 0)
                    return false;
                numberWasInBlock.set(currentNumber, true);
            }
        }
        return true;
    }

    private boolean checkDiagonals(char[][] currentPuzzle) {
        return false;
    }

}
