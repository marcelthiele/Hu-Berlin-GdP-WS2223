

import gdp.stdlib.StdDraw;

public class MazeCreator {
    public static void main(String[] args) {
        int length = 50;
        int[][] maze = new int[length][length];
        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze.length; j++) {
                maze[i][j] = 1;
            }
        }
        initDraw(maze);

        while (true) {
            listenForClicks(maze);
        }
    }

    public static void initDraw(int[][] maze) {
        System.out.println("Initialising");
        StdDraw.setXscale(0, maze[0].length);
        StdDraw.setYscale(0, maze[0].length);
        // StdDraw.setCanvasSize(1000, 1000);
        draw(maze);
    }

    public static void listenForClicks(int[][] maze) {
        try {
            double x = StdDraw.mouseX();
            double y = StdDraw.mouseY();
            System.out.println("Mouse Presed at " + x + ", " + y);
    
            maze[maze.length - (int) y][(int) x] = 0;
            draw(maze);
    
            printArray(maze);
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    private static void printArray(int[][] maze) {
        for(int i = 0; i < maze.length; i++){
            System.out.print("{");
            for(int j = 0; j < maze.length; j++){
                System.out.print(maze[i][j] + ", ");
            }
            System.out.println("},\n");
        }
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
