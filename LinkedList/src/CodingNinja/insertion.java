//Position starts from 1
package CodingNinja;

import java.util.Scanner;

public class insertion {
	
	public static Node<Integer> input(){
		Scanner sc = new Scanner(System.in);
		Node<Integer> head=null,tail=null;
		int data = sc.nextInt();
		while(data!=-1){
			Node<Integer> temp = new Node<>(data);
			if(head==null){
				head=temp;
				tail=temp;
			}
			else{
				tail.next=temp;
				tail=temp;
			}
			data = sc.nextInt();
		}
		sc.close();
		return head;
	}
	
	public static void print(Node<Integer> head){
		while(head!=null){
			System.out.print(head.data+" ");
			head = head.next;
		}
		System.out.println();
	}

	public static Node<Integer> insertNode(Node<Integer> head,int data,int pos){
		Node<Integer> newNode = new Node<>(data);
		if(pos==1){
			newNode.next = head;
			return newNode;
		}
		Node<Integer> temp = head;
		int i=1;
		while(i<pos-1){
			temp = temp.next;
			i++;
		}
		newNode.next = temp.next;
		temp.next = newNode;
		return head;
	}
	public static void main(String[] args) {
		Node<Integer> head = input();
		print(head);
		head = insertNode(head, 80, 3);
		print(head);

	}

}
