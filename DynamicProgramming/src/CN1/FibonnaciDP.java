package CN1;

import java.util.Scanner;

public class FibonnaciDP {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		System.out.println(fibDP(n));
		sc.close();
	}
	public static int fibDP(int n) {
		int[] storage = new int[n+1];
		storage[0] = 0;
		storage[1] = 1;
		for(int i=2;i<=n;i++)
			storage[i] = storage[i-1] + storage[i-2];
		return storage[n];
	}

}
