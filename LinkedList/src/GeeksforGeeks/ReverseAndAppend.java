/*Given a linked list, reverse alternate nodes and append at the end
 * https://practice.geeksforgeeks.org/problems/given-a-linked-list-reverse-alternate-nodes-and-append-at-the-end/1*/

package GeeksforGeeks;

import java.util.Scanner;

import CodingNinja.Node;

public class ReverseAndAppend {
	public static void main(String args[]) {
		Node<Integer> head = input();
		head = rearrange(head);
		print(head);
	}
	
	public static Node<Integer> rearrange(Node<Integer> odd){
		if(odd==null || odd.next==null || odd.next.next==null)
			return odd;
		Node<Integer> curr=odd,temp=null,even=null,head=odd;
		int i=1;
		while(curr!=null && curr.next!=null) {
			if(i%2==0) {
				temp=new Node<Integer>(curr.data);
				odd.next=odd.next.next;
				temp.next=even;
				even=temp;
				odd=odd.next;
			}
			i++;
			curr=curr.next;
		}
		curr.next=even;
		return head;
				
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
