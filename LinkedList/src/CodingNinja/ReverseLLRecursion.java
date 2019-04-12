package CodingNinja;

import java.util.Scanner;

public class ReverseLLRecursion {
	
	public static void main(String args[]) {
		System.out.println("Enter Number, input -1 to exit");
		Node<Integer> head = input();
		System.out.println("---------------------------------------------");
		System.out.println("Reversed List");
		Node<Integer> newHead = reverse(head);
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
	
	private static Node<Integer> reverse(Node<Integer> head){
		if(head==null || head.next==null)
			return head;
		
		Node<Integer> finalHead = reverse(head.next);
		head.next.next = head;
		head.next = null;
		return finalHead;
	}
}
