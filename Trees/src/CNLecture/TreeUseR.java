package CNLecture;

import java.util.Scanner;

public class TreeUseR {
	
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		TreeNode<Integer> root = takeInput(sc);
		print(root);
	}

	private static TreeNode<Integer> takeInput(Scanner sc) {
		int n;
		System.out.println("Enter next node");
		n = sc.nextInt();
		TreeNode<Integer> root = new TreeNode<>(n);
		System.out.println("Enter number of children");
		int childCount = sc.nextInt();
		for(int i=0;i<childCount;i++) {
			TreeNode<Integer> child = takeInput(sc);
			root.children.add(child);
		}
		return root;
	}

	private static void print(TreeNode<Integer> root) {
		String s = root.data + ":";
		for(int i=0;i<root.children.size();i++)
			s += root.children.get(i).data + ","; 
		System.out.println(s);
		for(int i=0;i<root.children.size();i++)
			print(root.children.get(i));
	}
}
