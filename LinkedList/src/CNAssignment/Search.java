package CNAssignment;

import java.util.Scanner;

import CodingNinja.Node;

public class Search {

	public static Node<Integer> input(){
		Node<Integer> head=null,tail=null;
		Scanner sc = new Scanner(System.in);
		int data;
		data = sc.nextInt();
		while(data!=-1){
			Node<Integer> newNode = new Node<>(data);
			if(head == null){
				head = newNode;
				tail = newNode;
			}
			else{
				tail.next = newNode;
				tail = newNode;
			}
			data = sc.nextInt();
		}
		return head;
	}

	public static void print(Node<Integer> head, int n) {
		int c=1;
	      if(head==null)
	        return;
	      while(head!=null && head.data!=n){
	        c++;
	        head = head.next;
	      }
	      System.out.println(n+" is present at position "+c);
		}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Number, input -1 to exit");
		Node<Integer> head = input();
		System.out.println("Enter position");
		int i = sc.nextInt();
		print(head,i);
		sc.close();
	}
}
