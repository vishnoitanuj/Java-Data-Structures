package CodingNinja;

import java.util.Scanner;

public class DoublyLL {
	
	public static Node2<Integer> input(){
		Node2<Integer> head=null,tail=null;
		Scanner sc = new Scanner(System.in);
		int data;
		data = sc.nextInt();
		while(data!=-1){
			Node2<Integer> newNode = new Node2<>(data);
			if(head == null){
				head = newNode;
				tail = newNode;
			}
			else{
				newNode.prev = tail;
				tail.next = newNode;
				tail = newNode;
			}
			data = sc.nextInt();
		}
		return head;
	}

	private static void print(Node2<Integer> head) {
		Node2<Integer> temp = head;
		while(temp!=null){
			System.out.print(temp.data+" ");
			temp = temp.next;
		}
		System.out.println();
//		head = head.next;
//		System.out.println(head.data);
//		System.out.println(head.prev.data);
	}

	public static void main(String[] args) {
		System.out.println("Enter Number, input -1 to exit");
		Node2<Integer> head = input();
		System.out.println("Printing");
		print(head);
	}

}
