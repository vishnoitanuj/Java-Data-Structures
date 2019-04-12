package CN;

public class QueueUse {
	
	public static void main(String[] args) {
		QueueUsingLL queue = new QueueUsingLL();
		for(int i=1;i<=8;i++)
				queue.enqueue(i);
		System.out.println("------------------");
		for(int i=1;i<=4;i++) {
			try {
				System.out.println(queue.dequeue());
			} catch (QueueEmptyException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		for(int i=1;i<=8;i++)
			queue.enqueue(i);
		System.out.println("------------------");
		while(!queue.isEmpty())
			try {
				System.out.println(queue.dequeue());
			} catch (QueueEmptyException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}

}
