package CodingNinja;

public class ConstructTreefromPostOrderAndInorder {

	public static BinaryTreeNode<Integer> getTreefromPostorderAndInoder(int[] post,int[] in){
		return getTreefromPostorderAndInoder(post, in,0,post.length-1,0,in.length-1);
	}

	private static BinaryTreeNode<Integer> getTreefromPostorderAndInoder(int[] post, int[] in, int postS, int postE, int inS,
			int inE) {
		
		if(inS>inE) {
			return null;
		}
		
		int rootData = post[postE];
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
		
		int leftPostStart = postS;
		int leftLength = leftInEnd - leftInStart + 1;
		int rightPostEnd = postE - 1;
		int leftPostEnd = leftPostStart + leftLength - 1;
		int rightPostStart = leftPostEnd + 1;
		root.left = getTreefromPostorderAndInoder(post, in, leftPostStart, leftPostEnd, leftInStart, leftInEnd);
		root.right = getTreefromPostorderAndInoder(post, in, rightPostStart, rightPostEnd, rightInStart, rightInEnd);
				
		return root;
	}

	public static void main(String[] args) {
		int post[] = {8, 4, 5, 2, 6, 7, 3, 1};
		int in[] = {4, 8, 2, 5, 1, 6, 3, 7};
		BinaryTreeNode<Integer> root = getTreefromPostorderAndInoder(post, in);
		BinaryTreeUse.printLevelWise(root);

	}
}
