package ComplexityProblems;

public class DuplicateArray {
	
	public static int check(int[] a) {
		int sum1 = 0,sum2=0;
		int n = a.length;
		sum1 = (n-2)*(n-1)/2;
		for(int i=0;i<a.length;i++)
			sum2+=a[i];
		return sum2-sum1;
	}
	public static void main(String[] args) {
		int input[] = {0, 7, 2, 5, 4, 7, 1, 3, 6};
		System.out.println(check(input));
	}

}

