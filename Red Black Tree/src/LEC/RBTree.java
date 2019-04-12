package LEC;

public class RBTree {
	
	private RedBlackNode current,parent,grand,great,header;
	private static RedBlackNode nullNode;
	
	/*static initializer for nullNode*/
	static {
		nullNode = new RedBlackNode(0);
		nullNode.left= nullNode;
		nullNode.right = nullNode;
	}
	
	/*Black = 1, Red = 0*/
	
	static final int black = 1;
	static final int red = 0;
	
	public RBTree(int negInf) {
		header = new RedBlackNode(negInf);
		header.left = nullNode;
		header.right = nullNode;
	}
	
	public boolean isEmpty() {
		return header.right == nullNode;
	}
	
	/*Make the tree logically empty*/
	public void makeEmpty() {
		header.right = nullNode;
	}
	
	/*Function to insert item*/
	public void insert(int item) {
		current = parent = grand = header;
		nullNode.element = item;
		while(current.element != item) {
			great = grand;
			grand = parent;
			parent = current;
			current = item < current.element ? current.left : current.right;
			// Check if two red children and fix if so
			if(current.left.color == red && current.right.color==red)
				handleReorient(item);
		}
		
		//Insertion fails if already present
		if(current!=nullNode)
			return;
		current = new RedBlackNode(item);
		
		//Attach to parent
		if(item<parent.element)
			parent.left = current;
		else
			parent.right = current;
		handleReorient(item);
	}
	
	private void handleReorient(int item) {
		// Do the color flip
		current.color = red;
		current.left.color = black;
		current.right.color = black;
		
		if(parent.color == red) {
			//Have to rotate
			grand.color = red;
			if(item<grand.element != item<parent.element)
				parent = rotate(item,grand); //Start double rotation
			current = rotate(item, great);
			current.color = black;
		}
		
		//Make root black
		header.right.color = black;
	}
	
	private RedBlackNode rotate(int item, RedBlackNode parent)
    {
        if(item < parent.element)
            return parent.left = item < parent.left.element ? rotateWithLeftChild(parent.left) : rotateWithRightChild(parent.left) ;  
        else
            return parent.right = item < parent.right.element ? rotateWithLeftChild(parent.right) : rotateWithRightChild(parent.right);  
    }
    /* Rotate binary tree node with left child */
    private RedBlackNode rotateWithLeftChild(RedBlackNode k2)
    {
        RedBlackNode k1 = k2.left;
        k2.left = k1.right;
        k1.right = k2;
        return k1;
    }
    /* Rotate binary tree node with right child */
    private RedBlackNode rotateWithRightChild(RedBlackNode k1)
    {
        RedBlackNode k2 = k1.right;
        k1.right = k2.left;
        k2.left = k1;
        return k2;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
