package CN;

public class CheckBST {
	
	private static BSTNode root;
	
	public static boolean check() {
		return check(root,Integer.MIN_VALUE,Integer.MAX_VALUE);
	}
	private static boolean check(BSTNode root,int min,int max) {
		if(root==null)
			return true;
		if(root.data>min && root.data<=max) {
			boolean ans1,ans2;
			ans1=check(root.left,min,root.data-1);
			ans2=check(root.right,root.data,max);
			return ans1&&ans2;
		}
		else
			return false;
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
		for(int i=2;i<=8;i++)
			insert(i);
		System.out.print(check());
	}
}
