package LEC;

public class Node {
	int key, height;
	Node left,right;
	
	Node(int key){
		this.key = key;
		left=right=null;
		height=1;
	}

}