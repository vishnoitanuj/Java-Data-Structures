package classes_and_objects;

public class PrintSubsequences {

	private static void printSub(String input,String output){
		if(input.length()==0){
			System.out.println(output);
			return;
		}
		//don not include first character
		printSub(input.substring(1),output);
		printSub(input.substring(1), output+input.charAt(0));
	}
	
	public static void printSub(String input){
		printSub(input,"");
	}
	public static void main(String[] args) {
		printSub("xyz");

	}

}
