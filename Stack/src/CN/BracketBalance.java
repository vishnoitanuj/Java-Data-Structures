package CN;

import java.util.Scanner;

public class BracketBalance {
	
	public static void main(String args[])throws Exception{
		Scanner sc = new Scanner(System.in);
		StackUsingLL stack = new StackUsingLL();
		String na = sc.nextLine();
		int i,f=-1;
		for(i=0;i<na.length();i++) {
			char ch=na.charAt(i);
			if(ch=='(' || ch=='{' || ch=='[')
				stack.push(ch);
			if(ch==')' || ch=='}' || ch==']') {
				char temp = (char)stack.pop();
				if((ch==')' && temp!='(') || (ch=='}' && temp!='}') || (ch==']' && temp!='[')) {
					f=1;
					break;
				}
			}
		}
		if(f==-1)
			System.out.println("Balanced");
		else
			System.out.println("Unbalanced");
	}

}
