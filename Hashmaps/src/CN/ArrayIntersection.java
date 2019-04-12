package CN;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

public class ArrayIntersection {
	
	public static void intersection(int a[],int b[]) {
		
		HashMap<Integer,Boolean> check = new HashMap<>();
		for(int i:a) {
			if(check.containsKey(i))
				continue;
			check.put(i, false);
		}
		for(int i:b) {
			if(check.containsKey(i))
				check.put(i, true);
		}
		
		Set<Integer> keys = check.keySet();
		for(int i:keys) {
			if(check.get(i))
				System.out.println(i);
				
		}
	}

	public static void main(String[] args) {
//		int a[] = {2, 6, 8, 5, 4, 3};
//		int b[] = {2, 3, 4, 7 };
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int a[] = new int[n];
		for(int i=0;i<n;i++)
			a[i] = sc.nextInt();
		int n2 = sc.nextInt();
		int b[] = new int[n2];
		for(int i=0;i<n2;i++)
			b[i] = sc.nextInt();
		intersection(a, b);
		sc.close();
	}

}
