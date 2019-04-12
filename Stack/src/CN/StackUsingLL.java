package CN;

public class StackUsingLL<T> {
	
	private Node<T> head;
	private int size;
	
	public StackUsingLL() {
		head = null;
		size = 0;
	}
	
	int size() {
		return size;
	}
	
	T top() throws StackEmptyException {
		if(isEmpty()) {
			StackEmptyException e = new StackEmptyException();
			throw e;
		}
		return head.data;
		
	}
	
	boolean isEmpty() {
		return (size()==0);
		
	}
	void push(T element) {
		
		Node newNode = new Node(element);
		newNode.next = head;
		head = newNode;
		size++;
	}
	
	T pop() throws StackEmptyException {
		if(isEmpty()) {
			StackEmptyException e = new StackEmptyException();
			throw e;
		}
		T temp = head.data;
		head = head.next;
		size--;
		return temp;
		
	}
	
}
