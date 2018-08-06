/*
1) for input 1 2 3 4 -1 with pos -1 code is giving wrong answer as he
missed to write the case for this condition where position i is greater than the length of LL.
2) The student was getting runtime error for when element was not in the LL, 
need to check end of LL with head!=null
*/
package CodingNinja;

import java.util.Scanner;

public class DeletionLinkedList {

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

	public static Node<Integer> deleteNode(Node<Integer> head,int pos){
		Node<Integer> temp = head;
		int i=1;
		while(i<pos-1 && temp!=null){
			temp = temp.next;
			i++;
		}
		if(temp==null || head==null || pos<1 || temp.next==null)
			return head;
		if(pos==1)
			return head.next;
		else if(temp.next.next==null)
			temp.next = null;
		else
			temp.next = temp.next.next;
		return head;
	}
	public static void main(String[] args) {
		Node<Integer> head = input();
		//print(head);
		head = deleteNode(head, 1);
		print(head);

	}

}
