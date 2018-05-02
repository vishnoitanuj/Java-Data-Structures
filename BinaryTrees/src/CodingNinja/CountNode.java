package CodingNinja;

import java.util.Scanner;

public class CountNode {
	
	public static void main(String args[]) {
		Scanner s = new Scanner(System.in);
		BinaryTreeNode<Integer> root = takeInput(s);
		print(root);
		System.out.println("Number of Nodes = "+countNodes(root));
	}

	private static void print(BinaryTreeNode<Integer> root) {
		if(root==null)
			return;
		String toBePrinted = root.data + " ";
		if(root.left!=null)
			toBePrinted += "L:" + root.left.data + ",";
		if(root.right!=null)
			toBePrinted += "R:" + root.right.data;
		System.out.println(toBePrinted);
		print(root.left);
		print(root.right);
	}

	private static int countNodes(BinaryTreeNode<Integer> root) {
		if(root == null)
			return 0;
		int ans = 1;
		ans += countNodes(root.left);
		ans += countNodes(root.right);
		return ans;
	}

	private static BinaryTreeNode<Integer> takeInput(Scanner s) {
		System.out.println("Enter data");
		int rootData = s.nextInt();
		if(rootData==-1)
			return null;
		BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(rootData);
		root.left = takeInput(s);
		root.right = takeInput(s);
		return root;
	}

}
