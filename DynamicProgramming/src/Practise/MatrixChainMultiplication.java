package Practise;

public class MatrixChainMultiplication {
	
	public static void main(String args[]) {
		int arr[] = new int[] {1, 2, 3, 4};
        int size = arr.length;
 
        System.out.println("Minimum number of multiplications is "+
                           MatrixChainOrder(arr, size));
	}

	private static int MatrixChainOrder(int[] arr, int n) {
		
		int st[][]=new int[n][n];
		for(int i=n-2;i>0;i--) {
			for(int j=1;j<n;j++) {
				if(i<j) {
					int min=Integer.MAX_VALUE;
					for(int k=i;k<j;k++) {
						int cost=st[i][k]+st[k+1][j]+arr[i-1]*arr[k]*arr[j];
						if(cost<min)
							min=cost;
					}
					st[i][j]=min;
				}
			}
		}
		return st[1][n-1];
	}
}
