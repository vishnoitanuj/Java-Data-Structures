package CN;

public class QueueUsingArray {
	private int data[];
	private int front,rear,size;
	public QueueUsingArray() {
		data = new int[10];
		front = rear = -1;
		size = 0;
	}
	public QueueUsingArray(int capacity) {
		data = new int[capacity];
		front = rear = -1;
		size = 0;
	}
	
	public int size() {
		return size;
	}
	
	public boolean isEmpty() {
		return size==0;
	}
	
	public int front() throws QueueEmptyException {
		if(size==0)
			throw new QueueEmptyException();
		return data[front];
	}
	
	public void enqueue(int element) throws QueueFullException {
		if(size==data.length)
			doubleCapacity();
		if(size==0)
			front = 0;
		rear = (rear+1) % data.length;
		data[rear] = element;
		size++;
	}
	private void doubleCapacity() {
		int temp[] = data;
		data = new int[temp.length*2];
		int index = 0,i;
		for(i=front;i<temp.length;i++)
			data[index++] = temp[i];
		for(i=0;i<front;i++)
			data[index++] = temp[i];
		front = 0;
		rear = temp.length-1;
		
	}
	public int dequeue() throws QueueEmptyException {
		if(size==0)
			throw new QueueEmptyException();
		size--;
		int temp = data[front];
		front = (front+1) % data.length;
		return temp;
	}
}
