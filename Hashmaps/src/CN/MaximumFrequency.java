package CN;
import java.util.HashMap;
import java.util.Scanner;

public class MaximumFrequency {
	
	public static int maxFreq(int a[]) {
		int max = 0,maxValue=a[0];
		HashMap<Integer,Integer> temp = new HashMap<>();
		for(int i=0;i<a.length;i++) {
			if(temp.containsKey(a[i])) {
				temp.put(a[i], temp.get(a[i])+1);
			}
			else
				temp.put(a[i], 1);
		}
		for(int i:a) {
			if(temp.get(i)>max) {
				max = temp.get(i);
				maxValue = i;
			}
		}
		
		return maxValue;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int a[] = new int[n];
		for(int i=0;i<n;i++)
			a[i] = sc.nextInt();
		System.out.println(maxFreq(a));
		sc.close();
	}

}
