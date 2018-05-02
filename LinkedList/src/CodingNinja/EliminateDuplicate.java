package CodingNinja;

import java.util.Scanner;

public class EliminateDuplicate {

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
	
	private static void removeDuplicates(Node<Integer> head) {
		Node<Integer> temp1 = head, temp2 = head;
		while(temp1!=null){
			while(temp2!=null){
				if(temp1.data == temp2.next.data){
					if(temp2.next.next==null)
						temp2.next = null;
					else
						temp2.next = temp2.next.next;					
				}
				temp2 = temp2.next;
			}
			temp1 = temp1.next;
		}	
	}
	public static void main(String[] args) {
		System.out.println("Enter Number, input -1 to exit");
		Node<Integer> head = input();
		removeDuplicates(head);
		print(head);
	}
}
