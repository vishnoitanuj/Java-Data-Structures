package classes_and_objects;

public class ReturnKeypad {

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
	public static String[] keypad(int n){
		if(n==0){
			String ans[] = {""};
			return ans;
		}
		String smallAns[] = keypad(n/10);
		char ch[] = helper(n%10);
		int t=0;
		String ans[] = new String[smallAns.length * ch.length];
		for(int i=0;i<ch.length;i++){
			for(int j=0;j<smallAns.length;j++){
				ans[t++] = smallAns[j]+ch[i];
			}
		}
		return ans;
	}
	public static void main(String[] args) {
		String ans[] = keypad(2345);
		for(int i=0;i<ans.length;i++)
			System.out.println(ans[i]);
		System.out.println(ans.length);
	}

}
