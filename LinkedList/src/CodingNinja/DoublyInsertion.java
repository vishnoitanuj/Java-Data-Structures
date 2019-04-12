package CodingNinja;

import java.util.Scanner;

public class DoublyInsertion {

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
	}

	public static Node2<Integer> insertNode(Node2<Integer> head,int data,int pos){
		Node2<Integer> newNode = new Node2<>(data);
		if(pos==1){
			newNode.next = head;
			head.prev = newNode;
			return newNode;
		}
		Node2<Integer> temp = head;
		int i=1;
		while(i<pos-1){
			temp = temp.next;
			i++;
		}
		newNode.prev = temp;
		newNode.next = temp.next;
		temp.next = newNode;
		return head;
	}
	public static void main(String[] args) {
		Node2<Integer> head = input();
		print(head);
		head = insertNode(head, 4, 4);
		print(head);
	}
}
