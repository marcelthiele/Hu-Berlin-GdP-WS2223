package marcel.uebungsblatt3;

import gdp.stdlib.StdDraw;
import gdp.stdlib.StdIn;
import gdp.stdlib.StdOut;

public class GameOfLife{

    public static void main(String[] args){
        int x_length = StdIn.readInt();
        int y_length = StdIn.readInt();
        int numOfLivingCells = StdIn.readInt();

        boolean[][] mapOfCells = initMapOfCells(x_length, y_length, numOfLivingCells);
        initDraw(x_length, y_length);


        while(true){
            draw(mapOfCells);
            mapOfCells = calculateNextStep(mapOfCells);
        }
    }

    private static void initDraw(int x_length, int y_length) {
        StdDraw.setXscale(0, x_length);
        StdDraw.setYscale(0, y_length);
    }

    private static boolean[][] initMapOfCells(int x_length, int y_length, int numOfLivingCells) {
        StdOut.println("Initializing Map...");
        boolean[][] mapOfCells = new boolean[x_length][y_length];
        for(int i = 0; i < numOfLivingCells; i++){
            int x_read = StdIn.readInt();
            int y_read = StdIn.readInt();
            int x_pos = wrapX(x_read, mapOfCells);
            int y_pos = wrapY(y_read, mapOfCells);

            mapOfCells[x_pos][y_pos] = true;
        }
        StdOut.println("DONE - map initialized!");
        return mapOfCells;
    }

    private static boolean[][] calculateNextStep(boolean[][] mapOfCells) {
        StdOut.println("Calculating next step");

        int x_length = mapOfCells.length;
        int y_length = mapOfCells[0].length;
        boolean[][] newMapOfCells = new boolean[x_length][y_length];

        for(int x = 0; x < x_length; x++){
            for(int y = 0; y < y_length; y++){
                int numOfNeighbours = getNumOfNeighbours(x, y, mapOfCells);
                if(mapOfCells[x][y] == false && numOfNeighbours == 3) newMapOfCells[x][y] = true;
                else if(mapOfCells[x][y] == true && (numOfNeighbours == 3 || numOfNeighbours == 2)) newMapOfCells[x][y] = true;
                else newMapOfCells[x][y] = false;
            }
        }
        return newMapOfCells;
    }

    private static void draw(boolean[][] mapOfCells) {
        StdOut.println("drawing next iteration");
        StdDraw.clear();

        for(int x = 0; x < mapOfCells.length; x++){
            for(int y = 0; y < mapOfCells[0].length; y++){
                if(mapOfCells[x][y]) StdDraw.setPenColor(StdDraw.GREEN);
                else if(!mapOfCells[x][y]) StdDraw.setPenColor(StdDraw.WHITE);
                StdDraw.filledSquare(x, y, 1);
            }
        }

        // //Draw Lines
        StdDraw.setPenColor(StdDraw.BLUE);
        StdDraw.square(0, 0, mapOfCells.length);
        for(int x = 0; x < mapOfCells.length; x++){
            //Vertical lines
            StdDraw.line(x, -1, x, mapOfCells[0].length);
        }
        for(int y = 0; y < mapOfCells[0].length; y++){
            //Horizontal lines
            StdDraw.line(-1, y, mapOfCells.length, y);
        }


        StdDraw.show(100);
    }

    private static int getNumOfNeighbours(int x_pos, int y_pos, boolean[][] mapOfCells) {
        int sumOfNeighbours = 0;
        for(int x_delta = -1; x_delta <= 1; x_delta++){
            for(int y_delta = -1; y_delta <= 1; y_delta++){
                int x = wrapX(x_pos+x_delta, mapOfCells);
                int y = wrapY(y_pos+y_delta, mapOfCells);
                // int x = x_pos+x_delta;
                // int y = y_pos+y_delta;

                if(mapOfCells[x][y]) sumOfNeighbours++;
            }
        }

        if(mapOfCells[x_pos][y_pos]) sumOfNeighbours--;

        return sumOfNeighbours;
    }

    private static int wrapX(int x_pos, boolean[][] mapOfCells) {
        if(x_pos < 0) return mapOfCells.length+x_pos;
        if(x_pos >= mapOfCells.length) return x_pos - mapOfCells.length;
        return x_pos;
    }

    private static int wrapY(int y_pos, boolean[][] mapOfCells) {
        if(y_pos < 0) return mapOfCells[0].length+y_pos;
        if(y_pos >= mapOfCells[0].length) return y_pos - mapOfCells[0].length;
        return y_pos;
    }
    
}