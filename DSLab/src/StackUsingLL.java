
public class StackUsingLL {
	
	private Node head;
	private int size;
	public StackUsingLL() {
		head = null;
		size = 0;
	}
	
	public int size() {
		return size;
	}
	
	public boolean isEmpty() {
		return (head==null);
	}
	
	public void push(int n) {
		Node newNode = new Node(n);
		if(head!=null)
			newNode.next = head;
		head = newNode;
		++size;
			
	}
	
	public int pop() throws StackEmptyException {
		if(isEmpty()) {
			StackEmptyException e = new StackEmptyException();
			throw e;
		}
		else {
			int x = head.data;
			head = head.next;
			return x;
		}
	}
}
