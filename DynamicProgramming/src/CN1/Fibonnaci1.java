package CN1;

import java.util.Scanner;

public class Fibonnaci1 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		System.out.println(fibM(n));
		sc.close();
	}

	private static int fibM(int n) {
		int storage[] = new int[n+1];
		for(int i=0;i<storage.length;i++)
			storage[i] = -1;
		return fibM(n,storage);
	}
	
	//Time Complexity: O(n)
	//Memoization
	private static int fibM(int n, int[] storage) {
		
		if(n==0 || n==1) {
			storage[n] = n;
			return storage[n];
		}
		
		if(storage[n]!=-1)
			return storage[n];
		storage[n] = fibM(n-1,storage) + fibM(n-2,storage);
		return storage[n];
	}

}
