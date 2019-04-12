package CN;

public class FindPath {
	private static BSTNode root;
	
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
	
	public static void path(int k) {
		path(root,k);
	}
	
	private static void path(BSTNode node,int k) {
		if(node==null)
			return;
		if(node.data==k)
			System.out.println(k);
		else if(k<node.data) {
			path(node.left,k);
			System.out.println(node.data);
		}
		else if(k>node.data) {
			path(node.right,k);
			System.out.println(node.data);
		}
	}
	
	public static void main(String args[]) {
		insert(5);
		insert(3);
		insert(7);
		insert(2);
		insert(1);
		insert(6);
		insert(8);
		path(6);
	}

}
