package hackerrank_Algo;
import java.util.Scanner;

public class ThePowerSum {
	
	static int powerSum(int X, int N) {
        // Complete this function
        return powerSum(X,N,1);
    }
    private static int powerSum(int x,int n,int k){
        int t=(int)Math.pow(k,n);
        if(t<x)
            return powerSum(x,n,k+1)+powerSum(x-t,n,k+1);
        else if(t==x)
            return 1;
        else
            return 0;
    } 

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int X = in.nextInt();
        int N = in.nextInt();
        int result = powerSum(X, N);
        System.out.println(result);
        in.close();
    }

}
