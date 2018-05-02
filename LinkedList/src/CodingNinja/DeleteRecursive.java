package CodingNinja;

import java.util.Scanner;

public class DeleteRecursive {
	
	private static Node<Integer> deletion(Node<Integer> head,int pos){
		if(head==null || pos<1)		//This condition has to come first for empty list
			return head;
		
		if(pos==1)
			return head.next;
		
		head.next = deletion(head.next, pos-1);
		return head;
	}
	
	public static void main(String args[]) {
		System.out.println("Enter Number, input -1 to exit");
		Node<Integer> head = input();
		System.out.println("---------------------------------------------");
		System.out.println("Reversed List");
		Node<Integer> newHead = deletion(head, 4);
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
