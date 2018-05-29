package CodingNinja;

public class ConstructTreefromPreAndInorder {
	
	public static BinaryTreeNode<Integer> getTreefromPreorderAndInoder(int[] pre,int[] in){
		return getTreefromPreorderAndInoder(pre, in,0,pre.length-1,0,in.length-1);
	}

	private static BinaryTreeNode<Integer> getTreefromPreorderAndInoder(int[] pre, int[] in, int preS, int preE, int inS,
			int inE) {
		
		if(inS>inE) {
			return null;
		}
		
		int rootData = pre[preS];
		BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(rootData);
		int i = inS;
		while(i<inE) {
			if(in[i]==rootData)
				break;
			i++;
		}
		int leftInStart = inS;
		int leftInEnd = i-1;
		int rightInStart = i+1;
		int rightInEnd = inE;
		
		int leftPreStart = preS + 1;
		int rightPreEnd = preE;
		int leftLength = leftInEnd - leftInStart + 1;
		int leftPreEnd = leftPreStart + leftLength - 1;
		int rightPreStart = leftPreEnd + 1;
		
		root.left = getTreefromPreorderAndInoder(pre, in, leftPreStart, leftPreEnd, leftInStart, leftInEnd);
		root.right = getTreefromPreorderAndInoder(pre, in, rightPreStart, rightPreEnd, rightInStart, rightInEnd);
				
		return root;
	}

	public static void main(String[] args) {
		int pre[] = {1, 2, 3, 4, 15, 5, 6, 7, 8, 10, 9, 12};
		int in[] = {4, 15, 3, 2, 5, 1, 6, 10, 8, 7, 9, 12};
		BinaryTreeNode<Integer> root = getTreefromPreorderAndInoder(pre, in);
		BinaryTreeUse.printLevelWise(root);

	}

}
