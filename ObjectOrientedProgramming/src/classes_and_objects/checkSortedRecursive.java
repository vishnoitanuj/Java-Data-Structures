package classes_and_objects;

public class checkSortedRecursive {

	public static boolean check(int[] input){
		if(input.length <=1)
			return true;
		
		int[] smallAns = new int[input.length-1];
		for(int i=1;i<input.length;i++)
			smallAns[i-1]=input[i];
		boolean ans = check(smallAns);
		if(!ans)
			return false;
		if(input[0] <= input[1])
			return true;
		else
			return false;
	}
	public static boolean check_2(int[] input){
		if(input.length <=1)
			return true;
		if(input[0]>= input[1])
			return true;
		
		int[] smallAns = new int[input.length-1];
		for(int i=1;i<input.length;i++)
			smallAns[i-1]=input[i];
		boolean ans = check(smallAns);
		return ans;
	}
	private static boolean checkBetter(int[] input,int startIndex){
		if(startIndex>=input.length-1)
			return true;
		if(input[startIndex]>input[startIndex+1])
			return false;
		boolean ans = checkBetter(input, startIndex+1);
		return ans;
	}
	public static boolean checkBetter(int[] input){
		return checkBetter(input,0);
	}
	public static void main(String[] args) {
		int input[] = {1,2,3,4};
		System.out.println(checkBetter(input));

	}

}
