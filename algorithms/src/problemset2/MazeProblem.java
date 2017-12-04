package problemset2;

import java.util.Stack;

public class MazeProblem {

	public char[][] maze =
		   {{' ', '#', '#', '#', '#', '#', '#', '#', '#', ' '},
			{' ', ' ', ' ', ' ', '#', ' ', '#', ' ', ' ', ' '},
			{'#', ' ', ' ', ' ', '#', ' ', '#', ' ', '#', '#'},
			{'#', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '#'},
			{'#', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '#'},
			{'#', '#', '#', ' ', ' ', ' ', ' ', ' ', ' ', '#'},
			{'#', ' ', ' ', ' ', ' ', '#', '#', '#', '#', '#'},
			{'#', ' ', ' ', ' ', ' ', ' ', '#', ' ', '#', '#'},
			{'#', ' ', '#', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
			{'#', '#', '#', '#', '#', '#', '#', '#', '#', ' '},};
	int xSize=10;
	int ySize=10;
	static Stack<String> myStack= new Stack<String>();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MazeProblem obj = new MazeProblem();
		obj.checkMaze(0, 0);
		
		while (!myStack.isEmpty()){
			
			System.out.println(myStack.pop());
			
		}

}

	
	public void checkMaze(int row, int col){
		
		if(maze[row][col]!='#'){
			
			myStack.push(row+","+col);
			System.out.println("-----"+row+","+col);
			
			
			if(maze[row+1][col]=='#' && row+1<xSize){
				
				if(maze[row][col+1]=='#' && col+1<ySize){
					
					if(maze[row-1][col]=='#' && row!=0){
						
						if(maze[row][col-1]=='#' && col!=0){
							
							myStack.pop();
							maze[row][col]='#';
							
						}else{
							
							checkMaze(row-1,col);
							
						}
					}else{
						
						
						checkMaze(row-1,col);
					}
					
					
				}else{
					
					checkMaze(row,col+1);
					
				}
				
			}else{
				
				checkMaze(row+1,col);
				
			}
		}
			
		}
		
		
		
		
		
	
}