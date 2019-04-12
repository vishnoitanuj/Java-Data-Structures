package CodingNinja;

import java.util.Scanner;

public class InsertRecursive {
	
	private static Node<Integer> insertion(Node<Integer> head,int pos,int elem){
	
		if(pos==1) {
			Node<Integer> newNode = new Node<>(elem);
			newNode.next = head;
			return newNode;
		}
		
		if(head == null)
			return head;
		
		head.next = insertion(head.next, pos-1, elem);
		return head;
	}

	public static void main(String args[]) {
		System.out.println("Enter Number, input -1 to exit");
		Node<Integer> head = input();
		System.out.println("---------------------------------------------");
		System.out.println("Reversed List");
		Node<Integer> newHead = insertion(head, 2, 10);
		print(newHead);
	}

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
		sc.close();
		return head;
	}
	
	private static void print(Node<Integer> head) {
		while(head!=null){
			System.out.print(head.data+" ");
			head = head.next;
		}
		System.out.println();
		
	}

}
