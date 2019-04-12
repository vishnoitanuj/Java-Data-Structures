package LEC;

public class Insertion {
	
	Node root;
	
	//Return height of tree
	public int height(Node n) {
		if(n==null)
			return 0;
		return n.height;
	}
	
	public Node RightRotate(Node n) {
		Node x = n.left;
		Node t = x.right;
		
		//Perform rotation
		x.right = n;
		n.left = t;
		
		//update heights
		n.height = Math.max(height(n.left), height(n.right)) + 1;
		x.height = Math.max(height(x.left), height(x.right)) + 1;
		
		return x;
	}
	
	public Node LeftRotate(Node n) {
		Node x = n.right;
		Node t = x.left;
		
		//Perform Rotation
		x.left = n;
		n.right = t;
		
		//Update heights
		n.height = Math.max(height(n.left), height(n.right)) + 1;
		x.height = Math.max(height(x.left), height(x.right)) + 1;
		
		return x;		
	}
	
	//Get Balance factor
	public int getBalance(Node n) {
		if(n==null)
			return 0;
		return height(n.left)-height(n.right);
	}
	
	public Node insert(Node node,int key) {
		//1. Perform normal BST Insertion
		if(node==null)
			return (new Node(key));
		if(key<node.key)
			node.left = insert(node.left,key);
		else if(key>node.key)
			node.right = insert(node.right,key);
		
		//2.Update height of ancestor node
		node.height = 1 + Math.max(height(node.left), height(node.right));
		
		//Get the Balance factor
		int balance = getBalance(node);
		
		//4 cases
		
		//Left Left Case
		if(balance>1 && key<node.left.key)
			return RightRotate(node);
		
		// Right Right Case
		if(balance<-1 && key > node.right.key)
			return LeftRotate(node);
		
		// Left Right Case
		if(balance>1 && key>node.left.key) {
			node.left = LeftRotate(node.left);
			return RightRotate(node);
		}
		
		// Right Left Case
		if(balance<-1 && key<node.right.key) {
			node.right = RightRotate(node.right);
			return LeftRotate(node);
		}
		
		return node;
		
	}
	
	public void preOrder(Node node) {
		if (node != null) {
            System.out.print(node.key + " ");
            preOrder(node.left);
            preOrder(node.right);
        }
	}
	
	public static void main(String[] args) {
		Insertion tree = new Insertion();
 
        /* Constructing tree given in the above figure */
        tree.root = tree.insert(tree.root, 10);
        tree.root = tree.insert(tree.root, 20);
        tree.root = tree.insert(tree.root, 30);
        tree.root = tree.insert(tree.root, 40);
        tree.root = tree.insert(tree.root, 50);
        tree.root = tree.insert(tree.root, 25);
 
        /* The constructed AVL Tree would be
             30
            /  \
          20   40
         /  \     \
        10  25    50
        */
        System.out.println("Preorder traversal" +
                        " of constructed tree is : ");
        tree.preOrder(tree.root);
    }
}