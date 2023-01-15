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

	public static boolean solve(int[][] maze, int row, int col) {
		//int rowT,colT=0;
		//boolean T=false;
		if(maze[row][col]==3) {
			
			return true;
		}
		if(col-1 < 0) return false;
		if(row+1 > maze.length) return false;

		if(maze[row][col-1]==1&&maze[row+1][col]!=1) {
			col+=1;
			while(maze[row][col-1]==1&&maze[row+1][col]!=1){
				maze[row][col]=2;
				draw(maze);
				solve(maze,row,col++);
				
			}
		}
		
		/*if(maze[row][col+1]==1&&col+1<=4) {
			rowT=row;
			colT=col+1;
		}
		*/
		if(maze[row+1][col]==1&&maze[row][col-1]!=1) {
			row+=1;
			while(maze[row+1][col]==1&&maze[row][col-1]!=1) {
				maze[row][col]=2;
				draw(maze);
				solve(maze,row++,col);
			}
		}
		/*if(!T&&colT!=0) {
			row=rowT;
			col=colT;
			solve(maze,row,col++);
			}
		*/	
			
			
		
		return false;
		/*
		Hier ist Platz für Ihre Lösung des Labyrinths :-)
		*/
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
	
	public static void initDraw(int[][] maze) {
        StdDraw.setXscale(0, maze.length);
        StdDraw.setYscale(0, maze[0].length);
    }

	/*
	Hier können Sie bei Bedarf weitere Methoden oder Konstanten
	unterbringen ...
	*/
}