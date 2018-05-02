package CodingNinja;

import java.util.Scanner;

public class MergeSorted {

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
		//sc.close();
		return head;
	}

	private static void print(Node<Integer> head) {
		while(head!=null){
			System.out.print(head.data+" ");
			head = head.next;
		}
		System.out.println();
		
	}

	public static void main(String[] args) {
		System.out.println("Enter Number, input -1 to exit");
		Node<Integer> head1 = input();
		Node<Integer> head2 = input();
		Node<Integer> head3 = merge(head1, head2);
		print(head3);
	}

	private static Node<Integer> merge(Node<Integer> head1, Node<Integer> head2) {
		if(head1 == null)
			return head2;
		if(head2 == null)
			return head1;
		Node<Integer> head3 =null,tail3 = null,t1 = head1,t2 = head2;
		if(t1.data <= t2.data){
			head3 = t1;
			tail3 = t1;
			t1 = t1.next;
		}else{
			head3 = t2;
			tail3 = t2;
			t2 = t2.next;
		}
		while(t1!=null && t2!=null){
			if(t1.data <= t2.data){
				tail3.next = t1;
				tail3 = t1;
				t1 = t1.next;
			}else{
				tail3.next = t2;
				tail3 = t2;
				t2 = t2.next;
			}
		}
		if(t1!=null)
			tail3.next = t1;
		else
			tail3.next = t2;
		return head3;
	}
}
