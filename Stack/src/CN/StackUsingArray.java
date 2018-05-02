package CN;

public class StackUsingArray {
	
	private int data[];
	private int top;
	
	public StackUsingArray() {
		data = new int[3];
		top = -1;
	}
	
	public StackUsingArray(int capacity) {
		data = new int[capacity];
		top = -1;
	}
	
	public boolean isEmpty() {
		return (top==-1);
	}
	
	public int size() {
		return top+1;
	}
	
	public int top() throws StackEmptyException {
		if(isEmpty()) {
			StackEmptyException e = new StackEmptyException();
			throw e;
		}
		return data[top];
	}
	
	private void doubleCapacity() {
		int[] temp = data;
		data = new int[2*temp.length];
		for(int i=0;i<temp.length;i++)
			data[i] = temp[i];
	}

	public void push(int n) throws StackFullException {
		if(size() == data.length) {
//			StackFullException e = new StackFullException();
//			throw e;
			doubleCapacity();
		}
		data[++top] = n;
	}
	
	public int pop() throws StackEmptyException {
		if(isEmpty()) {
			StackEmptyException e = new StackEmptyException();
			throw e;
		}
		return data[top--];
	}
}
