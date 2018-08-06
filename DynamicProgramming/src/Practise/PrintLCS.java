package Practise;

public class PrintLCS {
	
	public static void main(String[] args) {
		String s = "AGGTAB";
		String t = "GXTXAYB";
		lcsDP(s, t);

	}

	private static void lcsDP(String s, String t) {
		int m=s.length();
		int n=t.length();
		int a[][]=new int[m+1][n+1];
		for(int i=1;i<=m;i++) {
			for(int j=1;j<=n;j++) {
				if(s.charAt(i-1)==t.charAt(j-1))
					a[i][j]=1+a[i-1][j-1];
				else
					a[i][j]=Math.max(a[i-1][j], a[i][j-1]);
			}
		}
		int l=a[m][n];
		int index=l-1;
		char lcs[]=new char[l];
		int i=m,j=n;
		while(i>0 && j>0) {
			if(s.charAt(i-1)==t.charAt(j-1)) {
				lcs[index]=s.charAt(i-1);
				i--;
				j--;
				index--;
			}
			else if(a[i-1][j]>a[i][j-1])
				i--;
			else
				j--;
		}
		for(int k=0;k<l;k++)
         System.out.print(lcs[k]);
		
	}

}
