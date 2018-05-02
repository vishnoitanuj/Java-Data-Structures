package classes_and_objects;

public class PrintKeypad {
	
	public static char[] helper(int n){
		if(n<=1 || n>10)
			System.exit(0);
		if(n==2){
			char ch[] = {'a','b','c'};
			return ch;
		}
		else if(n==3){
			char ch[] = {'d','e','f'};
			return ch;
		}
		else if(n==4){
			char ch[] = {'g','h','i'};
			return ch;
		}
		else if(n==5){
			char ch[] = {'j','k','l'};
			return ch;
		}
		else if(n==6){
			char ch[] = {'m','n','o'};
			return ch;
		}
		else if(n==7){
			char ch[] = {'p','q','r','s'};
			return ch;
		}
		else if(n==8){
			char ch[] = {'t','u','v'};
			return ch;
		}
		else{
			char ch[] = {'w','x','y','z'};
			return ch;
		}
		
	}

	private static void printSub(int n,String output){
		if(n==0){
			System.out.println(output);
			return;
		}
		char ch[] = helper(n%10);
		for(int i=0;i<ch.length;i++)
			printSub(n/10, ch[i]+output);
	}
	
	public static void printSub(int n){
		printSub(n,"");
	}
	public static void main(String[] args) {
		printSub(354);

	}
}
