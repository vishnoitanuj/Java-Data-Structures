
public class QueueUse {

	public static void main(String[] args)throws Exception {
		
		QueueUsingLL stack = new QueueUsingLL();
		for(int i=1;i<=4;i++)
			stack.enqueue(i);
		while(!stack.isEmpty())
			System.out.println(stack.deenqueue());

	}

}
