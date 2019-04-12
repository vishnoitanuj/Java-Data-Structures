package RecursionAssignment2;

public class Staircase {
	
	public static int count(int n) {
		if(n==1 || n==0)
			return 1;
		if(n==2)
			return 2;
		return count(n-1)+count(n-2)+count(n-3);
			
	}
	
	public static void main(String args[]) {
		System.out.println(count(4));
	}

}
