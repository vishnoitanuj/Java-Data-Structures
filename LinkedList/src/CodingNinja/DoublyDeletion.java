package CodingNinja;

import java.util.Scanner;

public class DoublyDeletion {
	
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

	public static Node2<Integer> deleteNode(Node2<Integer> head,int pos){
		if(pos==1)
			return head.next;
		Node2<Integer> temp = head;
		int i=1;
		while(i<pos-1 && temp!=null){
			temp = temp.next;
			i++;
		}
		if(temp==null || head==null || pos<1 || temp.next==null)
			return head;
		else if(temp.next.next==null)
			temp.next = null;
		else {
			temp.next = temp.next.next;
			temp.next.prev = temp;
		}
		return head;
	}
	public static void main(String[] args) {
		Node2<Integer> head = input();
		print(head);
		head = deleteNode(head, 4);
		print(head);
	}

}
