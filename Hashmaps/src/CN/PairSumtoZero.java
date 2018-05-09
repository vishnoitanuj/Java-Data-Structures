package CN;

import java.util.HashMap;
import java.util.Scanner;

public class PairSumtoZero {
	
	public static void main(String[] args) {
//		int a[] = {2, 6, 8, 5, 4, 3};
//		int b[] = {2, 3, 4, 7 };
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int a[] = new int[n];
		for(int i=0;i<n;i++)
			a[i] = sc.nextInt();
		pairSum(a);
		sc.close();
	}

	private static void pairSum(int[] a) {
		HashMap<Integer, Integer> map = new HashMap<>();
		for(int i:a) {
			if(map.containsKey(i)) {
				map.put(i, map.get(i)+1);
				continue;
			}
			map.put(i, 1);
		}
		for(int i:a) {
			if(map.containsKey(-i) && map.get(i)!=0) {
				int times = map.get(i) * map.get(-i);
				while(times!=0) {
					System.out.println(Math.min(i, -i)+" "+Math.max(i, -i));
					times--;
				}
				map.put(i, 0);
				map.put(-i, 0);
			}
		}
		
	}

}
