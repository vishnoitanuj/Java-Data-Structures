package GFG;

public class Josephus {
	
	public static void main(String args[]) {
		int n=7,k=3;
		System.out.println(calculate(n,k));
	}

	private static int calculate(int n, int k) {
		if(n==1)
			return 1;
		return (calculate(n-1, k)+k-1)%n+1;
	}
	

}
