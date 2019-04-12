package CN;

import java.util.LinkedList;
import java.util.ListIterator;

public class BSTtoSortedLL {
	
	private static BSTNode root;
	
	public static void SortedLL() {
		LinkedList<Integer> ll = SortedLL(root);
		ListIterator<Integer> lt = ll.listIterator();
		while(lt.hasNext())
			System.out.print(lt.next()+" ");
		
	}
	private static LinkedList<Integer> SortedLL(BSTNode root) {
		if(root==null)
			return null;
		LinkedList<Integer> ll = new LinkedList<>();
		if(root.left!=null)
			ll=SortedLL(root.left);
		ll.add(root.data);
		if(root.right!=null)
			ll.addAll(SortedLL(root.right));
		return ll;
	}
	public static void insert(int data) {
		root=insert(root,data);
	}

	private static BSTNode insert(BSTNode node, int data) {
		
		if(node==null)
			node=new BSTNode(data);
		else {
			if(data<=node.getData())
				node.left = insert(node.left,data);
			else
				node.right = insert(node.right,data);
		}
		return node;
	}
	
	public static void main(String args[]) {
		insert(5);
		insert(3);
		insert(7);
		insert(2);
		insert(4);
		insert(6);
		insert(8);
		SortedLL();
	}
}
