package GFG;

//Kadane's Algorithm
public class MaxContigousSubarray {
	
	public static void main(String args[]) {
		int [] a = {-2, -3, 4, -1, -2, 1, 5, -3};
		System.out.println("Maximum contiguous sum is " +
									calculate(a));
	}
	
	public static int calculate(int a[]) {
		int max=Integer.MIN_VALUE;
		int max_till_here=a[0];
		for(int i=1;i<a.length;i++) {
			max_till_here+=a[i];
			if(max_till_here>max)
				max=max_till_here;
			if(max_till_here<0)
				max_till_here=0;
		}
		return max;
	}

}
