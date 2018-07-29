package Practise;

import java.util.Scanner;
import java.text.DecimalFormat;

public class ProbabilityofKnight {

	public static void main (String[] args) {
		Scanner d=new Scanner(System.in);
		int t=d.nextInt();
		while(t-->0){
		    int n=d.nextInt();
		    int x=d.nextInt();
		    int y=d.nextInt();
		    int k=d.nextInt();
		    int dx[] = {2,1,2,1,-2,-1,-2,-1};
		    int dy[] = {1,2,-1,-2,1,2,-1,-2};
		    double ans=calculate(n,x,y,k,dx,dy);
		    DecimalFormat df=new DecimalFormat("#.######");
		    System.out.println(df.format(ans));
		}
	}
	public static boolean inside(int n,int x,int y){
	    if(x>=0 && y>=0 && x<n && y<n)
	        return true;
	    return false;
	}
	
	public static double calculate(int n,int start_x,int start_y,int steps,int[] dx,int[] dy) {
		double dp[][][]=new double[n][n][steps+1];
		double prob=0.0;
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++)
				dp[i][j][0]=1.0;
		}
		
		for(int s=1;s<=steps;s++) {
			for(int x=0;x<n;x++) {
				for(int y=0;y<n;y++) {
					prob=0.0;
					for(int i=0;i<8;i++) {
						int nx = x+dx[i];
						int ny = y+dy[i];
						if(inside(n,nx,ny))
							prob += dp[nx][ny][s-1] /8.0;
					}
					dp[x][y][s]=prob;
				}
			}
		}
		return dp[start_x][start_y][steps];
	}
}
