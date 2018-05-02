package CodingNinja;

import java.util.Scanner;

public class MirrorTree {
	
	public static void main(String args[]) {
		BinaryTreeNode<Integer> root = takeInputLevelWise();
		print(root);
		System.out.println("Mirrored Tree: ");
		mirrorTree(root);
		print(root);
	}

//	private static BinaryTreeNode<Integer> mirrorTree(BinaryTreeNode<Integer> root) {
//		if(root==null)
//			return root;
//		BinaryTreeNode<Integer> left = mirrorTree(root.left);
//		BinaryTreeNode<Integer> right = mirrorTree(root.right);
//		BinaryTreeNode<Integer> temp = left;
//		root.left = right;
//		root.right = temp;
//		return root;	
//	}
	
	private static void mirrorTree(BinaryTreeNode<Integer> root) {
		if(root==null)
			return;
		mirrorTree(root.left);
		mirrorTree(root.right);
		BinaryTreeNode<Integer> temp = root.left;
		root.left = root.right;
		root.right = temp;	
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


}
