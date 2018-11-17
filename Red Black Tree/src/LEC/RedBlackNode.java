package LEC;

public class RedBlackNode {
	
	RedBlackNode left, right;
	int element;
	int color;
	
	public RedBlackNode(int element) {
		this(element, null, null);
	}

	public RedBlackNode(int element, RedBlackNode left, RedBlackNode right) {
		this.left = left;
		this.right = right;
		this.element = element;
		color = 1;
	}

}
