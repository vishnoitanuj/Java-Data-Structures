package RecursionAssignment2;

public class printSubsets {
	
	public static void main(String[] args) {
		int input[] = {1,2,3};
		subsets(input);
	}
	
	public static void subsets(int []input) {
		for(int i=input.length;i>=0;i--)
			subsets(input,i);
	}
	
	public static void subsets(int []input,int startIndex) {
		if(input.length==startIndex) {
			System.out.println(" ");
			return;
		}
		else {
			
		}
	}
}
