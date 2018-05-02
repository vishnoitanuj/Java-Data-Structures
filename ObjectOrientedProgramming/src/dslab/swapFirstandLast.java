package dslab;

import java.util.Scanner;

public class swapFirstandLast {
	
	public static Node first=null,last=null,current;
	
	public static void main(String[] args) {
		Scanner d= new Scanner(System.in);
		for(int i=0;i<10;i++){
			int a=d.nextInt();
			insert(a);
		}
		swap();
		print();
	}
	public static void insert(int a){
		current=new Node(a,null);
		if(first==null){
			first=current;
			last=current;
		}
		else{
			last.next=current;
			last=current;
		}
	}
	public static void swap(){
		int k=first.n;
		first.n=last.n;
		last.n=k;
		
	}
	public static void print(){
		current=first;
		while(current!=null){
			System.out.println(current.n);
			current=current.next;
		}
	}

}