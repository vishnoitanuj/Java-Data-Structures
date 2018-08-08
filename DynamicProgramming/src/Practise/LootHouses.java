package Practise;

public class LootHouses {
	
	public static void main(String args[]) {
		int a[]= {5, 5, 10, 100, 10, 5};
		System.out.println(calculate(a,a.length));
	}

	private static int calculate(int[] a, int n) {
		int dp[]=new int[n];
		dp[0]=a[0];
		dp[1] = Math.max(dp[0], a[1]);
		for(int i=2;i<n;i++) {
			int op1=a[i]+dp[i-2];
			int op2=dp[i-1];
			dp[i]=Math.max(op1, op2);
		}
		return dp[n-1];
	}
}
