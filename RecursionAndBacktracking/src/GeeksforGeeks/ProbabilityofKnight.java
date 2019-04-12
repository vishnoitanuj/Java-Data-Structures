package GeeksforGeeks;

import java.util.Scanner;

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
		    System.out.format("%6f",ans);
		    System.out.println();
		}
	}
	public static boolean inside(int n,int x,int y){
	    if(x>=0 && y>=0 && x<n && y<n)
	        return true;
	    return false;
	}
	public static double calculate(int n,int x,int y,int k,int dx[],int dy[]){
	    double ans=0.0;
		if(!(inside(n,x,y)))
	        return 0.0;
	    if(k==0)
	        return 1.0;
	    for(int i=0;i<8;i++){
	        ans += calculate(n,x+dx[i],y+dy[i],k-1,dx,dy)/8.0;
	    }
	    return ans;
	}
}
