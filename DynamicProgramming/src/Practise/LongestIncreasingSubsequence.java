package Practise;

import java.util.Scanner;

public class LongestIncreasingSubsequence {
	public static void main(String args[]) {
		Scanner d=new Scanner(System.in);
		int n=d.nextInt();
		int a[]=new int[n];
		for(int i=0;i<n;i++)
			a[i]=d.nextInt();
		System.out.println(calculate(a,n));
		d.close();
	}

	private static int calculate(int[] a, int n) {
		int storage[]=new int[n];
		for(int i=n-2;i>=0;i--) {
			if(a[i]<a[i+1])
				storage[i]=1+storage[i+1];
			else
				storage[i]=storage[i+1];
		}
		return 1+storage[0];
	}
}
