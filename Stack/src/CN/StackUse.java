package CN;

public class StackUse {

	public static void main(String[] args) throws Exception{
		StackUsingLL stack = new StackUsingLL();
		for(int i=1;i<=5;i++)
			stack.push(i);
		while(!stack.isEmpty())
			System.out.println(stack.pop());

	}

}
