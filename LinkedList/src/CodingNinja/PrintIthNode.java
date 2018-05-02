package CodingNinja;

import java.util.Scanner;

public class PrintIthNode {

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

	public static void print(Node<Integer> head, int i) {
		int c=0;
	      if(head==null)
	        return;
	      while(head!=null && c<i){
	        c++;
	        head = head.next;
	      }
	      if(head!=null)
	      System.out.println(head.data);
		}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Number, input anything other than integer to exit");
		Node<Integer> head = input();
		System.out.println("Enter position");
		int i = sc.nextInt();
		print(head,i);
		sc.close();
	}
}
