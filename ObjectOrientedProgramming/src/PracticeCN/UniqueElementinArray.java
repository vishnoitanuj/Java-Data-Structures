package PracticeCN;

import java.util.Scanner;

public class UniqueElementinArray {
	
	private static Scanner d;

	public static void main(String args[])throws Exception{
		d = new Scanner(System.in);
		int n = d.nextInt();
		int[] a = new int[n];
		for(int i= 0 ;i< n;i++)
			a[i] = d.nextInt();
		int output = findUnique(a);
		System.out.println(output);
	}

	private static int findUnique(int[] a) {
		int output = a[0];
		for(int i=1;i<a.length;i++)
			output = output ^ a[i];
		return output;
	}

}
