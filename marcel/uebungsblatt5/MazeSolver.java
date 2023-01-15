package marcel.uebungsblatt5;

import gdp.stdlib.StdDraw;

public class MazeSolver {
    public static void main(String[] args) {
        int[][] maze = {
                { 0, 0, 1, 1, 1, 1, 1, 2 },
                { 0, 0, 1, 0, 1, 0, 0, 0 },
                { 0, 0, 1, 0, 1, 0, 0, 0 },
                { 0, 0, 0, 0, 1, 1, 1, 0 },
                { 1, 1, 1, 1, 1, 1, 0, 0 },
                { 1, 0, 1, 0, 1, 1, 0, 0 },
                { 0, 0, 1, 0, 0, 1, 0, 0 },
                { 3, 1, 1, 0, 0, 0, 0, 0 }
        };

        initDraw(maze);
        draw(maze);
        if (solve(maze, 0, maze.length - 1))
            drawFinish(maze);
    }

    private static void drawFinish(int[][] maze) {
        java.awt.Color[] colors = { StdDraw.BLUE, StdDraw.GREEN, StdDraw.MAGENTA, StdDraw.PINK, StdDraw.RED };
        for (int i = 0; i < 1000; i++) {
            java.awt.Color currentColor = colors[i % colors.length];
            StdDraw.setPenColor(currentColor);
            StdDraw.filledSquare(0, 0, maze.length);
            StdDraw.show(75);
            StdDraw.clear();
            StdDraw.text(maze.length / 2, maze.length / 2, "Wer das liest ist doof!!");
            StdDraw.show(50);
            // draw(maze);
        }
    }

    public static void initDraw(int[][] maze) {
        StdDraw.setXscale(0, maze.length);
        StdDraw.setYscale(0, maze[0].length);
    }

    public static boolean solve(int[][] maze, int row, int col) {
        if (col < 0)
            return false;
        if (row > maze.length)
            return false;
        if (maze[row][col] == 0)
            return false;
        if (maze[row][col] == 3) {
            return true;
        }

        maze[row][col] = 2;
        draw(maze);

        if (solve(maze, row, col - 1)) {
            return true;
        }

        if (solve(maze, row + 1, col)) {
            return true;
        }

        maze[row][col] = 1;
        draw(maze);
        return false;
    }

    public static void draw(int[][] maze) {
        StdDraw.clear();
        for (int x = 0; x < maze.length; x++) {
            for (int y = 0; y < maze[0].length; y++) {
                double drawX = (x + .5);
                double drawY = maze.length - (y + .5);
                StdDraw.setPenColor(StdDraw.BLACK);
                StdDraw.square(drawX, drawY, .5);
                if (maze[y][x] == 2) {
                    StdDraw.setPenColor(StdDraw.GREEN);
                    StdDraw.filledSquare(drawX, drawY, .5);
                }
                if (maze[y][x] == 3) {
                    StdDraw.setPenColor(StdDraw.BLUE);
                    StdDraw.filledSquare(drawX, drawY, .5);
                }
                if (maze[y][x] == 0) {
                    StdDraw.setPenColor(StdDraw.BLACK);
                    StdDraw.filledSquare(drawX, drawY, .5);
                }
            }
        }

        StdDraw.show(200);
    }
}
