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
        for (int x = 0; x < puzzle.length; x++) {
            for (int y = 0; y < puzzle[0].length; y++) {
                char ch = StdIn.readChar();
                puzzle[x][y] = ch != '0' && ch != '.' ? ch : ' ';
            }
            StdIn.readChar();
        }
    }

    public void write() {
        for (int y = 0; y < puzzle[0].length; y++) {
            if (y % 2 == 0) {
                printLine();
            }
            for (int x = 0; x < puzzle.length; x++) {
                if (x % 2 == 0) {
                    System.out.print("| ");
                }
                System.out.print(puzzle[x][y] + " ");

            }
            System.out.print("|\n");
        }
        printLine();
    }

    public boolean check() {
        /* TODO */
        return true;
    }

    public void solve() {
        /* TODO */ }

    // -----------------------------------------

    private void printLine() {
        System.out.println("+-----+-----+-----+-----+");
    }
}
