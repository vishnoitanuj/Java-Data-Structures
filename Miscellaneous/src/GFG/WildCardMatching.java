package GFG;

public class WildCardMatching {
	
	public static int wildCard(String pattern, String str)
    {
        int n=str.length();
        int m=pattern.length();
        int a[][]=new int[n+1][m+1];
        a[0][0]=1;
        for(int j=1;j<=m;j++){
            if(pattern.charAt(j-1)=='*')
                a[0][j]=a[0][j-1];
        }
        
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                if(pattern.charAt(j-1)=='*'){
                    a[i][j]=Math.max(a[i][j-1],a[i-1][j]);
                }
                else if(pattern.charAt(j-1)=='?' || str.charAt(i-1)==pattern.charAt(j-1))
                    a[i][j]=a[i-1][j-1];
                else
                    a[i][j]=0;
                    
            }
        }
        return a[n][m];
    }

}
