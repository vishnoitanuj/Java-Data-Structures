package CN2;

import java.util.Scanner;

public class MinCostPath {
	
	//Recursive Method
	public static int findMinPathR(int input[][]) {
		return findMinPathR(input,0,0);
	}

	private static int findMinPathR(int[][] input, int i, int j) {
		if(i>=input.length || j>=input[0].length)
			return Integer.MAX_VALUE;
		if(i==input.length-1 && j==input[0].length-1)
			return input[i][j];
		return Math.min(findMinPathR(input,i+1,j), Math.min(findMinPathR(input,i,j+1),findMinPathR(input,i+1,j+1)))+input[i][j];
	}
	
	//Memoization
	public static int findMinPathM(int input[][]) {
		int[][] storage = new int[input.length][input[0].length];
		for(int i=0;i<input.length;i++) {
			for(int j=0;j<input[0].length;j++)
				storage[i][j] = -1;
		}
		return findMinPathM(input,0,0,storage);
	}

	private static int findMinPathM(int[][] input, int i, int j,int[][] storage) {
		int m = input.length;
		int n = input[0].length;
		if(i>=m || j>=n)
			return Integer.MAX_VALUE;
		if(i==m-1 || j==n-1) {
			storage[i][j] = input[i][j];
			return storage[i][j];
		}
		
		if(storage[i][j]!=-1)
			return storage[i][j];
		
		storage[i][j] = Math.min(findMinPathR(input,i+1,j), Math.min(findMinPathR(input,i,j+1),findMinPathR(input,i+1,j+1)))+input[i][j];
		return storage[i][j];
	}

	//DP Solution
	public static int findMinPathDP(int[][] input) {
		int m = input.length;
		int n = input[0].length;
		int storage[][] = new int[m][n];
		storage[m-1][n-1] = input[m-1][n-1];
		int i,j;
		for(j=n-2;j>=0;j--)
			storage[m-1][j] = storage[m-1][j+1] + input[m-1][j];
		for(i=m-2;i>=0;i--)
			storage[i][n-1] = storage[i+1][n-1] + input[i][n-1];
		
		for(i=m-2;i>=0;i--) {
			for(j=n-2;j>=0;j--) {
				storage[i][j] = Math.min(storage[i][j+1],Math.min(storage[i+1][j+1], storage[i+1][j])) + input[i][j];
			}
		}
		return storage[0][0];
	}
	
	private static int findMinPathDP2(int[][] input) {
		int m=input.length;
		int n=input[0].length;
		int storage[][]=new int[m][n];
		storage[0][0]=input[0][0];
		for(int i=1;i<m;i++)
			storage[i][0]=storage[i-1][0]+input[i][0];
		for(int j=1;j<n;j++)
			storage[0][j]=storage[0][j-1]+input[0][j];
		for(int i=1;i<m;i++) {
			for(int j=1;j<n;j++) {
				storage[i][j]=Math.min(storage[i-1][j], Math.min(storage[i-1][j-1], storage[i][j-1]))+input[i][j];
			}
		}
		return storage[m-1][n-1];
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int r = sc.nextInt();
		int c = sc.nextInt();
		int input[][] = new int[r][c];
		for(int i=0;i<r;i++) {
			for(int j=0;j<c;j++)
				input[i][j]=sc.nextInt();
		}
		System.out.println(findMinPathDP2(input));
		//System.out.println(findMinPathM(input));
		//System.out.println(findMinPathR(input));
		sc.close();
	}

}
