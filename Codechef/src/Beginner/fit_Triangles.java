package Beginner;

import java.util.Scanner;

public class fit_Triangles {
	
	public static int calculate(int B) {
		if(B<4)
			return 0;			
		return (int)Math.floor(B/2);
	}
	
	public static void main(String args[]) {
		Scanner d = new Scanner(System.in);
		int t=d.nextInt();
		while(t-->0) {
			int B = d.nextInt();
			System.out.println(calculate(B));
		}
	}

}
