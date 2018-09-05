
public class LargestSubsquareX {
	
	public static void main(String args[]) {
		int mat[][] = {{'X', 'O', 'X', 'X', 'X', 'X'},
                {'X', 'O', 'X', 'X', 'O', 'X'},
                {'X', 'X', 'X', 'O', 'O', 'X'},
                {'O', 'X', 'X', 'X', 'X', 'X'},
                  {'X', 'X', 'X', 'O', 'X', 'O'},
                {'O', 'O', 'X', 'O', 'O', 'O'}};
     System.out.println(findSubSquare(mat));
}
    
    private static int findSubSquare(int mat[][])
    {
    int max = 1; 
    int N=mat.length;
 
    int hor[][] = new int[N][N];
    int ver[][] = new int[N][N];
    for(int i=0;i<N;i++){
        for(int j=0;j<N;j++){
            if(mat[i][j]=='O')
               ver[i][j]=hor[i][j]=0;
            else{
                hor[i][j]=(j==0) ? 1: (hor[i][j-1]+1);
                ver[i][j]=(i==0) ? 1: (ver[i-1][j]+1);
            }
        }
    }
        
  
    for (int i = N - 1; i >0; i--)
    {
        for (int j = N - 1; j >0; j--)
        {
            
            int small = Math.min(hor[i][j], ver[i][j]);
 
            while (small > max)
            {
                if (ver[i][j - small + 1] >= small && hor[i - small + 1][j] >= small)
                    max = small;
                small--;
            }
        }
    }
    return max;
    }
}

