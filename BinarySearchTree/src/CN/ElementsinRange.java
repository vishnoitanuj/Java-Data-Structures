package CN;

import java.util.Scanner;

public class ElementsinRange {
	
	public static void main(String args[]) {
		BSTNode root = takeInput();
		
	}

	private static BSTNode takeInput() {
		System.out.println("Enter data");
		Scanner s = new Scanner(System.in);
		int rootData = s.nextInt();
		if(rootData==-1)
			return null;
		BSTNode root = new BSTNode(rootData);
		
		return root;
	}

}
