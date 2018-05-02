package CN;

public class QueueUsingLL<T> {
	
	private Node<T> front,rear;
	private int size;
	
	public QueueUsingLL() {
		front = null;
		rear = null;
		size = 0;
	}
	
	int size() {
		return size;
	}
	
	T front() throws QueueEmptyException {
		if(isEmpty()) {
			QueueEmptyException e = new QueueEmptyException();
			throw e;
		}
		return front.data;
		
	}
	
	boolean isEmpty() {
		return (size()==0);
		
	}
	void enqueue(T element) {
		Node<T> newNode = new Node(element);
		if(isEmpty()) {
			front = rear = newNode;
		}
		else {
			rear.next = newNode;
			rear = newNode;
		}
		size++;
	}
	
	T dequeue() throws QueueEmptyException {
		if(isEmpty()) {
			QueueEmptyException e = new QueueEmptyException();
			throw e;
		}
		T temp = front.data;
		front = front.next;
		size--;
		return temp;
		
	}
	
}
