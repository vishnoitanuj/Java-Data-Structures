package CodingNinja;

import java.util.Scanner;

public class OrderTraversal {

	public static void main(String args[]) {
		Scanner s = new Scanner(System.in);
		BinaryTreeNode<Integer> root = takeInput(s);
		inorder(root);
	}

	public static void inorder(BinaryTreeNode<Integer> root) {
		if(root==null)
			return;
		inorder(root.left);
		System.out.println(root.data);
		inorder(root.right);
	}
	
	public static void preorder(BinaryTreeNode<Integer> root) {
		if(root==null)
			return;
		System.out.println(root.data);
		preorder(root.left);
		preorder(root.right);
	}
	
	public static void postorder(BinaryTreeNode<Integer> root) {
		if(root==null)
			return;
		postorder(root.left);
		postorder(root.right);
	}

	public static BinaryTreeNode<Integer> takeInput(Scanner s) {
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
