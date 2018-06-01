package CN2;

public class LargestCommonSubsequence {

	//Recursive
	public static int lcs(String s,String t) {
		if(s.length()==0 || t.length()==0)
			return 0;
		if(s.charAt(0)==t.charAt(0))
			return 1+lcs(s.substring(1), t.substring(1));
		//if first not match
		int op1 = lcs(s, t.substring(1));
		int op2 = lcs(s.substring(1), t);
//		int op3 = lcs(s.substring(1), t.substring(1)); //this case gets covered in op1 and op2
		return Math.max(op1, op2);
	}
	
	//Memoization
	public static int lcsM(String s,String t) {
		int storage[][] = new int[s.length()+1][t.length()+1];
		for(int i=0;i<=s.length();i++) {
			for(int j=0;j<=t.length();j++)
				storage[i][j] = -1;
		}
		return lcsM(s,t,storage);
	}
	
	private static int lcsM(String s, String t, int[][] storage) {
		int m = s.length();
		int n = t.length();
		if(m==0 || n==0) {
			storage[m][n] = 0;
		}
		
		if(storage[m][n]!=-1)
			return storage[m][n];
		
		if(s.charAt(0)==t.charAt(0))
			storage[m][n] =  1+lcs(s.substring(1), t.substring(1));
		else {
		int op1 = lcsM(s, t.substring(1),storage);
		int op2 = lcsM(s.substring(1), t,storage);
//		int op3 = lcs(s.substring(1), t.substring(1)); //this case gets covered in op1 and op2
		storage[m][n] =  Math.max(op1, op2);
		}
		return storage[m][n];
	}

	//DP Solution
	public static int lcsDP(String s,String t) {
		int m=s.length();
		int n=t.length();
		int a[][] = new int[m+1][m+1];
		for(int i=0;i<=n;i++)
			a[0][i] = 0;
		for(int j=0;j<=m;j++)
			a[j][0] = 0;
		
		for(int i=1;i<=m;i++) {
			for(int j=1;j<=n;j++) {
				if(s.charAt(m-i)==t.charAt(n-j))
					a[i][j] = 1 + a[i-1][j-1];
				else
					a[i][j] = Math.max(a[i-1][j],a[i][j-1]);
			}
		}
		return a[m][n];
	}
	
	
	
	public static void main(String[] args) {
		String s = "adgeiabegiabegiabegiabegi";
		String t = "abegiabegiabegiabegi";
		System.out.println(lcsDP(s, t));
		System.out.println(lcsM(s, t));
		System.out.println(lcs(s, t));

	}

}
