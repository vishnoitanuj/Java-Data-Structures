package CN;

public class PrintinRange {
	
	private static BSTNode root;
	public static void printK(int k1,int k2) {
		printK(root,k1,k2);
	}
	private static void printK(BSTNode node,int k1,int k2) {
		if(node==null)
			return;
		if(node.data>=k1)
			printK(node.left,k1,k2);
		if(node.data>=k1 && node.data<=k2)
			System.out.print(node.data+" ");
		if(node.data<=k2)
			printK(node.right,k1,k2);
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
		insert(1);
		insert(6);
		insert(8);
		printK(3,5);
	}

}
