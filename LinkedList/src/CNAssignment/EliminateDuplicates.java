package CNAssignment;
//Linked List is sorted

import java.util.Scanner;

import CodingNinja.Node;

public class EliminateDuplicates {
	
	public static void main(String args[]) {
		System.out.println("Enter Number, input -1 to exit");
		Node<Integer> head = input();
		System.out.println("---------------------------------------------");
		System.out.println("Reversed List");
		Node<Integer> newHead = eliminate(head);
		print(newHead);
	}
	

	private static Node<Integer> eliminate(Node<Integer> head) {
		if(head ==null)
			return head;
		Node<Integer> current = head;
		while(current.next!=null) {
			if(current.data == current.next.data)
				current.next = current.next.next;
			else
				current = current.next;
		}
			
		return head;
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
