package CN;

public class BSTUse {
	
	private BSTNode root;
	public BSTUse() {
		root=null;
	}
	
	public boolean isEmpty() {
		return root==null	;
	}

	public void insert(int data) {
		root=insert(root,data);
	}

	private BSTNode insert(BSTNode node, int data) {
		
		if(node==null) {
			BSTNode newNode=new BSTNode(data);
			return newNode;
		}
			if(data<node.getData())
				node.left = insert(node.left,data);
			else
				node.right = insert(node.right,data);
		return node;
	}
	
	public boolean search(int s) {
		return search(root,s);
	}

	private boolean search(BSTNode root, int s) {
		if(root==null)
			return false;
		if(root.getData()==s)
			return true;
		if(s<root.getData())
			search(root.left,s);
		else
			search(root.right,s);
		return false;
	}
	
	public BSTNode delete(int data) {
		return delete(root,data);
	}
	
	private BSTNode delete(BSTNode node,int data) {
		if(node==null)
			return null;
		if(data<node.getData())
			delete(node.left,data);
		else if(data>node.getData())
			delete(node.right,data);
		else {
			if(node.left==null)
				return node.right;
			else if(node.right==null)
				return node.left;
			else {
				//node with two children.Get inorder successor(smallest in right subtree)
				BSTNode temp=node.right;
				int newRoot=temp.data;
				while(temp.left!=null) {
					newRoot=temp.data;
					temp=temp.left;
				}
				node.data=newRoot;
				node.right=delete(node.right, node.data);
			}
		}
		return node;
	}
	
	public void inorder() {
		inorder(root);
	}
	
	public void inorder(BSTNode root) {
		if(root==null)
			return;
		inorder(root.left);
		System.out.println(root.data);
		inorder(root.right);
	}
	
	public static void main(String args[]) {
		BSTUse obj=new BSTUse();
		obj.insert(5);
		obj.insert(3);
		obj.insert(7);
		obj.insert(2);
		obj.insert(1);
		obj.insert(6);
		obj.insert(8);
		obj.root = obj.delete(7);
		obj.root = obj.delete(5);
		obj.inorder();
	}

	
}
