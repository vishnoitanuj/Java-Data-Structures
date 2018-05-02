package CodingNinja;

import java.util.Scanner;

public class MidPoint {

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
	
	public static int findMid(Node<Integer> head){
		Node<Integer> slow=head,fast=head;
		while(fast.next!=null && fast.next.next!=null){
			slow = slow.next;
			fast = fast.next.next;
		}
		return slow.data;
	}

	public static void main(String[] args) {
		System.out.println("Enter Number, input -1 to exit");
		Node<Integer> head = input();
		System.out.println("---------------------------------------------");
		System.out.println(findMid(head));
	}

}
