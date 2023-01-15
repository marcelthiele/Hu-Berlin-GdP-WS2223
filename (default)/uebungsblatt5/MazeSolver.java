import gdp.stdlib.StdDraw;

public class MazeSolver {
    public static void main(String[] args) {
        int[][] maze = {
            {1,1,1, 1, 1, 1, 2},
            {0,1,0, 0, 1, 0, 0},
            {0,1,0, 1, 1, 1, 1},
            {1,1,1, 1, 0, 0, 0},
            {0,0,1, 0, 1, 1, 0},
            {0,1,1, 1, 1, 1, 1},
            {3,1,0, 1, 1, 1, 1}
            };

        initDraw(maze);
        draw(maze);
        // if (solve(maze, 0, maze.length - 1))
        //     drawFinish(maze);
        solve(maze, 0, maze.length - 1);
    }

    private static void drawFinish(int[][] maze) {
        java.awt.Color[] colors = { StdDraw.BLUE, StdDraw.GREEN, StdDraw.MAGENTA, StdDraw.PINK, StdDraw.RED };
        for (int i = 0; i < 1000; i++) {
            java.awt.Color currentColor = colors[i % colors.length];
            StdDraw.setPenColor(currentColor);
            StdDraw.filledSquare(0, 0, maze.length);
            StdDraw.show(75);
            StdDraw.clear();
            StdDraw.text(maze.length / 2, maze.length / 2, "Funktioniert!");
            StdDraw.show(50);
            // draw(maze);
        }
    }

    public static void initDraw(int[][] maze) {
        StdDraw.setXscale(0, maze.length);
        StdDraw.setYscale(0, maze[0].length);
    }

    public static boolean solve(int[][] maze, int row, int col) {
        if (col < 0) // Läuft nach links aus dem Feld
            return false;
        if (row >= maze.length) // Läuft nach unten aus dem Feld
            return false;
        if (maze[row][col] == 0) // Läuft gegen eine Wand
            return false;
        
        if (maze[row][col] == 3) // Ziel erreicht
            return true;

        //Setze aktuelles Feld auf grün
        maze[row][col] = 2;
        draw(maze); // Und zeichne neu

        //Teste weg nach links (eine Rekursionsstufe tiefer)
        if (solve(maze, row, col - 1)) {
            //Falls ein Weg von der tieferen Rekursionsstufe gefunden wurde, ist auch die aktuelle Stufe auf dem "Lösungsweg"
            return true;
        }

        // Falls die aktuelle Rekursionsstufe kein "Lösungsweg war", teste noch den Weg nach unten
        if (solve(maze, row + 1, col)) {
            //Falls ein Weg nach unten gefunden wurde, ist auch diese Stufe ein "Lösungsweg"
            return true;
        }

        maze[row][col] = 1; //In allen anderen Fällen, setze das Feld wieder auf seinen Ausgangszustand zurück
        // draw(maze); // Neu Zeichnen, damit "die Schlange sich zurückzieht"
        return false; // Dieser weg ist kein "Lösungsweg"
    }

    public static void draw(int[][] maze) {
        StdDraw.clear();
        for (int x = 0; x < maze.length; x++) {
            for (int y = 0; y < maze[0].length; y++) {
                double drawX = (x + .5);
                double drawY = maze.length - (y + .5);
                if (maze[y][x] == 2) {
                    StdDraw.setPenColor(StdDraw.GREEN);
                    StdDraw.filledSquare(drawX, drawY, .5);
                }
                if (maze[y][x] == 3) {
                    StdDraw.setPenColor(StdDraw.BLUE);
                    StdDraw.filledSquare(drawX, drawY, .5);
                }
                if (maze[y][x] == 0) {
                    StdDraw.setPenColor(StdDraw.GRAY);
                    StdDraw.filledSquare(drawX, drawY, .5);
                }
                StdDraw.setPenColor(StdDraw.BLACK);
                StdDraw.square(drawX, drawY, .5);
            }
        }

        StdDraw.show(200);
    }
}
