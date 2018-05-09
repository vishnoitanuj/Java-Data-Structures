/*Given a linked list and an integer n, append the last n elements of the LL to front.
 * Sample Input 1 :

1 2 3 4 5 -1
3

Sample Output 1 :

3 4 5 1 2


 * */

package CNAssignment;

import java.util.Scanner;

import CodingNinja.Node;

public class AppendLastNToFirst {

	public static Node<Integer> input(){
		Node<Integer> head=null,tail=null;
		Scanner sc = new Scanner(System.in);
		int data;
		data = sc.nextInt();
		while(data!=-1){
			Node<Integer> newNode = new Node<Integer>(data);
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
	
	private static Node<Integer> shift(Node<Integer> head,int n){
		if(head==null)
			return head;
		Node<Integer> temp = head;
		int i=0;
		while(temp.next!=null){
			temp = temp.next;
			i++;
		}
		temp.next = head;
		temp = head;
		//System.out.println(i);
		i=i-n;
		while(i>0){
			temp = temp.next;
			i--;
		}
		head = temp.next;
		temp.next = null;
		return head;
	}

	public static void main(String[] args) {
		System.out.println("Enter Number, input anything other than integer to exit");
		Node<Integer> head = input();
		head = shift(head, 3);
		print(head);
	}

}
