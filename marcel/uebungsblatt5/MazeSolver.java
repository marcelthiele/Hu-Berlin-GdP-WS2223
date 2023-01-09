package marcel.uebungsblatt5;

import gdp.stdlib.StdDraw;

public class MazeSolver {
    public static void main(String[] args) {
        int[][] maze = {
                { 1, 1, 1, 1, 2 },
                { 0, 1, 0, 0, 0 },
                { 0, 1, 1, 1, 1 },
                { 0, 1, 0, 0, 1 },
                { 3, 1, 0, 0, 1 }
        };

        initDraw(maze);
        draw(maze);
    }

    public static void initDraw(int[][] maze) {
        StdDraw.setXscale(0, maze.length);
        StdDraw.setYscale(0, maze[0].length);
    }

    public static boolean solve(int[][] maze, int row, int col) {
        return true;
    }

    public static void draw(int[][] maze) {
        for (int x = 0; x < maze.length; x++) {
            for (int y = 0; y < maze[0].length; y++) {
                double drawX = (x+.5);
                double drawY = maze.length-(y+.5);
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
                if(maze[y][x] == 0){
                    StdDraw.setPenColor(StdDraw.BLACK);
                    StdDraw.filledSquare(drawX, drawY, .5);
                }
            }
        }
    }
}
