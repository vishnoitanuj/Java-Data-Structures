package RecursionAssignment2;

public class checkAB {
	
	public static boolean checkAB(String input) {
		if(input.length()==0)
			return true;
		if(input.charAt(0)=='a') {
			if(input.length()==1)
				return true;
			else if(input.charAt(1)=='a')
				return checkAB(input.substring(1));
			else if(input.length()>=3 && input.charAt(1)=='b' && input.charAt(2)=='b')
				return checkAB(input.substring(3));
			else
				return false;
		}
		else 
			return false;
	}
	
	public static void main(String args[]) {
		System.out.println(checkAB("abb"));
	}
}
