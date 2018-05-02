package CodingNinja;

import java.util.Scanner;

public class NodeSearch {
	
	public static BinaryTreeNode<Integer> takeInputLevelWise() {
		Scanner sc = new Scanner(System.in);
		QueueUsingLL<BinaryTreeNode<Integer>> pendingNodes = new QueueUsingLL<>();
		int rootData = sc.nextInt();
		if(rootData == -1)
			return null;
		BinaryTreeNode<Integer> root = new BinaryTreeNode<>(rootData);
		pendingNodes.enqueue(root);
		
		while(!pendingNodes.isEmpty()) {
			BinaryTreeNode<Integer> front;
			try {
				front = pendingNodes.dequeue();
			} catch (QueueEmptyException e) {
				// TODO Auto-generated catch block
				return null;
			}
			System.out.println("Enter left child of "+front.data);
			int leftChild = sc.nextInt();
			if(leftChild!=-1) {
				BinaryTreeNode<Integer> child = new BinaryTreeNode<Integer>(leftChild);
				front.left = child;
				pendingNodes.enqueue(child);
			}
			System.out.println("Enter right child of "+front.data);
			int rightChild = sc.nextInt();
			if(rightChild!=-1) {
				BinaryTreeNode<Integer> child = new BinaryTreeNode<Integer>(rightChild);
				front.right = child;
				pendingNodes.enqueue(child);
			}
					
		}
		return root;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		BinaryTreeNode<Integer> root = takeInputLevelWise();
		System.out.println("Enter searching number");
		int x = sc.nextInt();
		System.out.println(isNodePresent(root,x));
	}

	private static boolean isNodePresent(BinaryTreeNode<Integer> root,int x) {
		if(root==null)
			return false;
		if(root.data == x)
			return true;
		boolean ans1 = isNodePresent(root.left, x);
		boolean ans2 =  isNodePresent(root.right, x);
		return (ans1 || ans2);
	}

}
