package GFG;

import java.util.Scanner;

public class MaximumSubSquareMatrix {
	
	public static void printMaxSumSub(int a[][],int k) {
		int n=a.length;
		if(k>n)
			return;
		int stripSum[][]=new int[n][n];
		for(int j=0;j<n;j++) {
			int sum=0;
			for(int i=0;i<k;i++)
				sum+=a[i][j];
			stripSum[0][j]=sum;
			for(int i=1;i<n-k+1;i++) {
				sum+=(a[i+k-1][j]-a[i-1][j]);
				stripSum[i][j]=sum;
			}
			
		}
		int max_sum=Integer.MIN_VALUE,r=0,c=0;
		for(int i=0;i<n;i++) {
			int sum=0;
			for(int j=0;j<k;j++)
				sum+=stripSum[i][j];
			if(sum>max_sum) {
				max_sum=sum;
				r=i;
				c=0;
			}
			for(int j=1;j<n-k+1;j++) {
				sum+=stripSum[i][j+k-1]-stripSum[i][j-1];
				if(sum>max_sum) {
				max_sum=sum;
				r=i;
				c=j;
				}
			}
		}
		for(int i=0;i<k;i++) {
			for(int j=0;j<k;j++)
				System.out.print(a[r+i][c+j]+" ");
			System.out.println();
		}
	}
	
	public static void main(String args[]) {
		int a[][] = {{1, 1, 1, 1, 1},
		        {2, 2, 2, 2, 2},
		        {3, 8, 6, 7, 3},
		        {4, 4, 4, 4, 4},
		        {5, 5, 5, 5, 5},
		    };
		    int k = 3;
//		Scanner d=new Scanner(System.in);
//		int n=d.nextInt();
//		int a[][]=new int[n][n];
//		for(int i=0;i<n;i++) {
//			for(int j=0;j<n;j++)
//				a[i][j]=d.nextInt();
//		}
//		int k=d.nextInt();
		  
		    System.out.println("Maximum sum 3 x 3 matrix is\n");
		    printMaxSumSub(a, k);
		 
	}
}
