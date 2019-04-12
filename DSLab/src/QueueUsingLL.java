
public class QueueUsingLL {
	
	Node head;
	Node tail;
	int size;
	
	public QueueUsingLL() {
		head = null;
		tail = null;
		size = 0;
	}
	
	public int size() {
		return size;
	}
	
	public boolean isEmpty() {
		return (head==null);
	}
	
	public void enqueue(int n) {
		Node newNode = new Node(n);
		if(head==null) {
			head = newNode;
			tail = newNode;
		}
		else {
			tail.next = newNode;
			tail = newNode;
		}
			
	}
	
	public int deenqueue() throws QueueEmptyException {
		if(isEmpty()) {
			QueueEmptyException e = new QueueEmptyException();
			throw e;
		}
		else {
			int x = head.data;
			head = head.next;
			return x;
		}		
}
}
