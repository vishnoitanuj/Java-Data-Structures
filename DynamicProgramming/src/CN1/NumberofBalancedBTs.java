package CN1;

import java.util.Scanner;

public class NumberofBalancedBTs {
	
	public static void main(String[] args) {
		Scanner d = new Scanner(System.in);
		System.out.println("Enter height");
		int h = d.nextInt();
		System.out.println(countBalancedBTs(h));
	}

	public static int countBalancedBTs(int h) {
		
		int mod = (int)Math.pow(10,9) + 7;
		return countBalancedBTs(h,mod);
	}

	private static int countBalancedBTs(int h, int mod) {
		if(h==0 || h==1)
			return h;
		long x = countBalancedBTs(h-1);
		long y = countBalancedBTs(h-2);
		long res1 = x*x;
		long res2 = 2*x*y;
		int value1 = (int)(res1%mod);
		int value2 = (int)(res2%mod);
		
		return (value1+value2);
	}

}
