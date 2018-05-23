package Practise;

//Complexity = O(n^3)
public class MatrixChainOrder {
	
	// Matrix Ai has dimension p[i-1] x p[i] for i = 1..n
	public static int MatrixChainOrderCalculate(int[] p,int n) {
		int cost[][] = new int[n][n];
		int i,j,k,l,q;
		
		//Cost zero when multiplying one matrix
		for(i=0;i<n;i++)
			cost[i][i]=0;
		
		for(l=2;l<n;l++) { //chain length
		
			for(i=1;i<n-l+1;i++) {
				j=i+l-1;
				cost[i][j] = Integer.MAX_VALUE;
				for(k=i;k<=j-1;k++) {
					q = cost[i][k]+cost[k+1][j]+p[i-1]*p[k]*p[j];
					if(q<cost[i][j]) {
						cost[i][j] = q;
					}
				}
			}
		}
	return cost[1][n-1];
	}

	public static void main(String[] args) {
		int arr[] = new int[] {1, 2, 3, 4};
        int size = arr.length;
 
        System.out.println("Minimum number of multiplications is "+
        		MatrixChainOrderCalculate(arr, size));

	}

}
