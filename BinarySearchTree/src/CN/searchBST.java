package CN;

public class searchBST {
	
	public static BinaryTreeNode<Integer> searchInBST(BinaryTreeNode<Integer> root , int k){
		if(root == null || root.data==k)
          return root;
      BinaryTreeNode<Integer> ans;
      if(k>root.data)
        ans = searchInBST(root.right,k);
      else
        ans = searchInBST(root.left,k);
	
      return ans;
	}

}
