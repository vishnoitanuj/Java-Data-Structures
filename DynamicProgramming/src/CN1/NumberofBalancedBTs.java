package CN1;

import java.util.Scanner;

public class NumberofBalancedBTs {
	
	public static void main(String[] args) {
		Scanner d = new Scanner(System.in);
		System.out.println("Enter height");
		int h = d.nextInt();
		System.out.println(countBalancedBTsDP(h));
		System.out.println(countBalancedBTs(h));
	}

	private static int countBalancedBTsDP(int h) {
		
		if(h==0)
			return 1;
		int[] storage = new int[h+1];
		storage[0] = storage[1] = 1;
		int mod = (int)Math.pow(10, 9) + 7;
		for(int i=2;i<=h;i++) {
			long temp1 = (long)(storage[i-1])*storage[i-1];
			int val1 = (int)(temp1%mod); 
			long temp2 = 2*(long)(storage[i-1])*storage[i-2];
			int val2 = (int)(temp2%mod); 
			
			storage[i] = (int)(val1+val2)%mod;
		}
		return storage[h];
	}

	public static int countBalancedBTs(int h) {
		
		int mod = (int)Math.pow(10,9) + 7;
		return countBalancedBTs(h,mod);
	}

	private static int countBalancedBTs(int h, int mod) {
		if(h == 0 || h == 1){
			return 1;
		}
		
		int x = countBalancedBTs( h - 1);
		int y = countBalancedBTs(h - 2);
		long res1 = (long)x * x;
		long res2 = (long)x * y * 2; 
		int value1 = (int)(res1 % mod);
		int value2 = (int)(res2 % mod);
		return  (value1 + value2) % mod;
	}

}
