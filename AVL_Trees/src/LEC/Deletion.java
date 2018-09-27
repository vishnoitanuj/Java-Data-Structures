package LEC;

public class Deletion {
	
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
	
	/* Given a non-empty binary search tree, return the
    node with minimum key value found in that tree.
    Note that the entire tree does not need to be
    searched. */
	public Node minValueNode(Node node) {
		Node current = node;
		while(current.left!=null)
			current = current.left;
		return current;
	}
	
	public Node delete(Node root,int key) {
		
		// STEP 1: PERFORM STANDARD BST DELETE
		if(root==null)
			return root;
		if(key<root.key)
			root.left = delete(root.left,key);
		else if(key>root.key)
			root.right = delete(root.right,key);
		else {
			if((root.left==null) && (root.right!=null)) {
				root=root.right;
			}
			else if((root.left!=null) && (root.right!=null)) {
				root=root.left;
			}
			else if(root.left==null && root.right==null)
				root=null;
			else {
				Node temp = minValueNode(root.right);
				root.key = temp.key;
				root.right = delete(root.right,temp.key);
			}
		}
		
		if(root==null)
			return root;
		
		// STEP 2: UPDATE HEIGHT OF THE CURRENT NODE
		root.height = Math.max(height(root.left), height(root.right))+1;
		
		// STEP 3: GET THE BALANCE FACTOR OF THIS NODE (to check whether
        //  this node became unbalanced)
		int balance = getBalance(root);
		
		//Left Left Case
		if(balance>1 && getBalance(root.left)>=0)
			return RightRotate(root);
		if(balance>1 && getBalance(root.left)<0) {
			root.left = LeftRotate(root.left);
			return RightRotate(root);
		}
		
		if(balance<-1 && getBalance(root.right)<=0)
			return LeftRotate(root);
		if(balance<-1 && getBalance(root.right)>0) {
			root.right = RightRotate(root.right);
			return LeftRotate(root);
		}
		
		return root;
		
	}
	
	public static void main(String[] args)
    {
		Deletion tree = new Deletion();
 
        /* Constructing tree given in the above figure */
        tree.root = tree.insert(tree.root, 9);
        tree.root = tree.insert(tree.root, 5);
        tree.root = tree.insert(tree.root, 10);
        tree.root = tree.insert(tree.root, 0);
        tree.root = tree.insert(tree.root, 6);
        tree.root = tree.insert(tree.root, 11);
        tree.root = tree.insert(tree.root, -1);
        tree.root = tree.insert(tree.root, 1);
        tree.root = tree.insert(tree.root, 2);
 
        /* The constructed AVL Tree would be
           9
          /  \
         1    10
        /  \    \
        0    5    11
        /    /  \
        -1   2    6
         */
        System.out.println("Preorder traversal of "+
                            "constructed tree is : ");
        tree.preOrder(tree.root);
 
        tree.root = tree.delete(tree.root, 10);
 
        /* The AVL Tree after deletion of 10
           1
          /  \
         0    9
        /     / \
        -1    5   11
        /  \
        2    6
         */
        System.out.println("");
        System.out.println("Preorder traversal after "+
                           "deletion of 10 :");
        tree.preOrder(tree.root);
    }

}
