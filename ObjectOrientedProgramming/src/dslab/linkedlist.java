package dslab;
import java.util.Scanner;

public class linkedlist {
	
	public static void main(String[] args) {
		Scanner d= new Scanner(System.in);
		Node first=null;
		Node current=null;
		Node last = null;
		for(int i=0;i<10;i++){
			System.out.println("Enter any number");
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
		System.out.println("---------------------------\nPrinting linked list");
		//Printing
		current=first;
		while(current!=null){
			System.out.println(current.n);
			current=current.next;
		}
		System.out.println("Enter number to delete");
		int del=d.nextInt();
		Node current1=null;
		if(first.n==del){
			first=first.next;
		}
		else{
			current=first;
		while(current!=null){
			if(current.n==del){
				break;
			}
			current1=current;
			current=current.next;
		}
		current1.next=current.next;
		}
		System.out.println("---------------------------\nPrinting linked list");
		//Printing
		current=first;
		while(current!=null){
			System.out.println(current.n);
			current=current.next;
		}
		System.out.println("Enter number and position to insert");
		int t=d.nextInt();
		int p=d.nextInt();
		Node temp=new Node(t,null);
		if(p==1){
			temp.next=first;
			first=temp;
		}
		else{
		current=first;
		current1=null;
		int i=0;
		while(current!=null && i<p-1){
			current1=current;
			current=current.next;
			i++;
		}
		current1.next=temp;
		temp.next=current;
		}
		System.out.println("---------------------------\nPrinting linked list");
		//Printing
		current=first;
		while(current!=null){
			System.out.println(current.n);
			current=current.next;
		}
	}
}

class Node{
	protected int n;
	protected Node next;
	public Node(int a,Node x){
		n=a;
		next=x;
	}
	public Node(){
		n=0;
		next=null;
	}
}
