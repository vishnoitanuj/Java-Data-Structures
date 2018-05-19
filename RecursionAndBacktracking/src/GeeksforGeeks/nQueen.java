package GeeksforGeeks;

public class nQueen {
	
	final static int n=4;
	
	public static boolean isSafe(int[][] board,int row,int col) {
		int i,j;
		//check row on left
		for(i=0;i<col;i++) {
			if(board[row][i]==1)
				return false;
		}
		
		//check upper left diagonal
		for(i=row,j=col;i>=0 && j>=0;i--,j--) {
			if(board[i][j]==1)
				return false;
		}
		
		//check lower left diagonal
		for(i=row,j=col;i<n && j>=0;i++,j--) {
			if(board[i][j]==1)
				return false;
		}
		return true;
	}
	
	public static boolean solveNQUtil(int[][] board,int col) {
		
		if(col>=n)
			return true;
		
		for(int i=0;i<n;i++) {
			
			if(isSafe(board, i, col)) {
				board[i][col]=1;
			
				if(solveNQUtil(board, col+1))
					return true;
				
				//backtracking
				board[i][col]=0;
			}
		}
		return false;
	}
	
	public static boolean solveNQ() {
		int board[][] = new int[n][n];
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++)
				board[i][j]=0;
		}
		
		if(solveNQUtil(board, 0)==false) {
			System.out.println("Solution doesn't exist");
			return false;
		}
		
		printSolution(board);
		return true;
	}

	private static void printSolution(int[][] board) {
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++)
				System.out.print(" "+board[i][j]+" ");
			System.out.println();
		}
		
	}
	
	public static void main(String[] args) {
		solveNQ();
	}

}
