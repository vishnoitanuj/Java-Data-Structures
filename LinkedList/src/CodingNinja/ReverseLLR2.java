package CodingNinja;

import java.util.Scanner;

public class ReverseLLR2 {
	
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
	
	public static void main(String[] args)throws Exception{
		Node<Integer> head = input();
		head = reverseLL(head);
		print(head);
		
	}

	private static Node<Integer> reverseLL(Node<Integer> head) {
		if(head == null || head.next==null) {
			return head;
		}
		Node<Integer> reversedTail = head.next;
		Node<Integer> newHead = reverseLL(head.next);
		reversedTail.next = head;
		head.next = null;
		
		return newHead;
	}

}
