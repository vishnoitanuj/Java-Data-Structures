package GFG;

public class MinimumStepsDeleteStringPalindrome {
	
	public static int calculate(String na) {
		int n=na.length();
		int dp[][]=new int[n+1][n+1];
		for(int len=1;len<=n;len++) {
			for(int i=0,j=len-1;j<n;j++,i++) {
				if(len==1)
					dp[i][j]=1;
				else {
					dp[i][j]=1+dp[i+1][j];
					if(na.charAt(i)==na.charAt(i+1))
						dp[i][j]=Math.min(1+dp[i+2][j], dp[i][j]);
					for(int k=i+2;k<=j;k++) {
						if(na.charAt(i)==na.charAt(k))
							dp[i][j]=Math.min(dp[i+1][k-1]+dp[k+1][j],dp[i][j]);
					}
				}
			}
		}
		return dp[0][n-1];
	}
	
	public static void main(String args[]) {
        String str = "2553432";
        System.out.println(calculate(str));
    }

}
