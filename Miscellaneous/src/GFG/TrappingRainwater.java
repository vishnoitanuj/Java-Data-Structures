package GFG;
/*https://www.geeksforgeeks.org/trapping-rain-water/*/

public class TrappingRainwater {
	public static void main(String args[]) {
		int a[]= {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
		System.out.println(calculate(a));
	}
	public static int calculate(int a[]) {
		int n=a.length;
		int left[]=new int[n];
		int right[]=new int[n];
		left[0]=a[0];
		right[n-1]=a[n-1];
		for(int i=1;i<n;i++) {
			left[i]=Math.max(a[i], left[i-1]);
					
		}
		for(int i=n-2;i>=0;i--) {
			right[i]=Math.max(a[i],right[i+1]);
		}
		int sum=0;
		for(int i=0;i<n;i++) {
			sum+=Math.min(left[i], right[i])-a[i];
		}
		return sum;
	}
}
