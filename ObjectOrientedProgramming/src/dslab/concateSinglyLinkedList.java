package dslab;

import java.util.Scanner;

public class concateSinglyLinkedList {
	public static void main(String[] args) {
		Scanner d= new Scanner(System.in);
		Node first=null;
		Node current=null;
		Node last = null;
		Node first1 = null;
		Node current1 = null;
		Node last1 = null;
		System.out.println("Enter elements of list1");
		for(int i=0;i<10;i++){
			int k=d.nextInt();
			current = new Node(k,null);
			if(first==null){
				first = current;
				last=current;
			}
			else{
				last.next=current;
				last=current;
			}
		}
}
}

class Node1{
	protected int n;
	protected Node1 next;
	public Node1(int a,Node1 x){
		n=a;
		next=x;
	}
	public Node1(){
		n=0;
		next=null;
	}
}