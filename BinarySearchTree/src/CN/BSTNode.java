package CN;

class BSTNode {
	
	public int data;
	public BSTNode left;
	public BSTNode right;
	
	
	public BSTNode() {
		left=right=null;
		data=0;
	}
	
	public BSTNode(int data) {
		left=null;
		right=null;
		this.data = data;
	}
	
	public void setLeft(BSTNode n) {
		left=n;
	}
	
	public void setRight(BSTNode n) {
		right=n;
	}
	
	public BSTNode getLeft() {
		return left;
	}
	
	public BSTNode getRight() {
		return right;
	}
	
	public void setData(int n) {
		data=n;
	}
	
	public int getData() {
		return data;
	}

}
