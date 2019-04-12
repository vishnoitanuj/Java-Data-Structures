package CodingNinja;

import java.util.Scanner;

public class MergeSort {
	
	public static void main(String[] args) {
		System.out.println("Enter Number, input -1 to exit");
		Node<Integer> head = input();
		Node<Integer> answer = mergeSort(head);
		print(answer);
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

	private static Node<Integer> mergeSort(Node<Integer> head) {
		if(head==null || head.next==null)
			return head;
		Node <Integer> mid = findMid(head);
		Node<Integer> head1 = head;
		Node<Integer> head2 = mid.next;
		mid.next = null;
		head1 = mergeSort(head1);
		head2 = mergeSort(head2);
		return merge(head1,head2);
	}


	private static Node<Integer> merge(Node<Integer> head1, Node<Integer> head2) {
		if(head1==null)
			return head2;
		if(head2==null)
			return head1;
		Node<Integer> head3=null,tail3=null;
		if(head1.data<head2.data) {
			head3 = head1;
			tail3 = head1;
			head1 = head1.next;
		}
		else {
			head3 = head2;
			tail3 = head2;
			head2=head2.next;
		}
		while(head1!=null && head2!=null) {
			if(head1.data<head2.data) {
				tail3.next = head1;
				tail3 = head1;
				head1 = head1.next;
			}
			else {
				tail3.next = head2;
				tail3 = head2;
				head2=head2.next;
			}
		}
		if(head1!=null)
			tail3.next = head1;
		else
			tail3.next = head2;
		return head3;
	}

	private static Node<Integer> findMid(Node<Integer> head) {
		if(head==null)
			return head;
		Node <Integer> fast=head.next,slow=head;
		while(fast.next!=null && fast.next.next!=null){
			slow = slow.next;
			fast = fast.next.next;
		}
		return slow;
	}

}
