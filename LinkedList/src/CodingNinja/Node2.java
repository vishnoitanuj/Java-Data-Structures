package CodingNinja;

public class Node2<T> {
	T data;
	Node2<T> prev;
	Node2<T> next;    //T signifies that this node refers to same T type of data only. We can remove T to make it more general
	Node2(T data){
		this.data = data;
		next = null;
		prev = null;
	}
}
