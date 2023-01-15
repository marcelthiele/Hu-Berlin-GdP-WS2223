import gdp.stdlib.StdDraw;

public class MazeSolver {

	public static boolean solve(int[][] maze, int row, int col) {
		//int rowT,colT=0;
		//boolean T=false;
		if(maze[row][col]==3) {
			
			return true;
		}
		if(maze[row][col+1]==1&&maze[row+1][col]!=1) {
			col+=1;
			while(maze[row][col+1]==1&&maze[row+1][col]!=1){
				//maze[row][col]=2;
				solve(maze,row,col++);
				
			}
		}
		
		/*if(maze[row][col+1]==1&&col+1<=4) {
			rowT=row;
			colT=col+1;
		}
		*/
		if(maze[row+1][col]==1&&maze[row][col+1]!=1) {
			row+=1;
			while(maze[row+1][col]==1&&maze[row][col+1]!=1) {
				//maze[row][col]=2;
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
		
		StdDraw.setXscale(0, 10); 
		StdDraw.setYscale(0, 10);
		
		double x1=0,y1=0,x2=0,y2=10,x3=0,y3=0,x4=10,y4=0;
		for(int i=0;i<=maze.length+1;i++) {
			StdDraw.line(x1, y1, x2, y2);
			StdDraw.line(x3, y3, x4, y4);
			x1+=1;
			x2+=1;
			y3+=1;
			y4+=1;
		}
		
		
		/*
		Hier ist Platz für Ihre Lösung zum Anzeigen
		*/
	}
	
	/*
	Hier können Sie bei Bedarf weitere Methoden oder Konstanten
	unterbringen ...
	*/
}