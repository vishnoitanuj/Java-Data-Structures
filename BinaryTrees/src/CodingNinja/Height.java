package CodingNinja;

import java.util.Scanner;

public class Height {
	
	public static void main(String args[]) {
		BinaryTreeNode<Integer> root = takeInputLevelWise();
		System.out.println(findHeight(root));
	}


	private static int findHeight(BinaryTreeNode<Integer> root) {
		if(root==null)
			return 0;
		int ldepth = findHeight(root.left);
		int rdepth = findHeight(root.right);
		return Math.max(ldepth, rdepth)+1;
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
