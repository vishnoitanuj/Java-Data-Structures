package CodingNinja;

import java.util.Scanner;

public class BinaryTreeUse {
	
	public static void main(String args[]) {
		Scanner s = new Scanner(System.in);
		BinaryTreeNode<Integer> root = takeInputLevelWise();
		printLevelWise(root);
	}

	public static void printLevelWise(BinaryTreeNode<Integer> root) {
		QueueUsingLL<BinaryTreeNode<Integer>> q = new QueueUsingLL<>();
		q.enqueue(root);
		BinaryTreeNode<Integer> current = null;
		while(!q.isEmpty()) {
			try {
				current = q.dequeue();
			} catch (QueueEmptyException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			String toBePrinted = current.data + ":";
			if(current.left!=null) {
				toBePrinted += "L:" + current.left.data + ",";
				q.enqueue(current.left);
			}
			else
				toBePrinted += "L:-1";
			if(current.right!=null) {
				toBePrinted += "R:" + current.right.data;
				q.enqueue(current.right);
			}
			else
				toBePrinted += "R:-1";
			System.out.println(toBePrinted);
		}
		
	}
	
	
	public static void print(BinaryTreeNode<Integer> root) {
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
