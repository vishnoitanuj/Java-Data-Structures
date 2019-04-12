package CN;

import java.util.ArrayList;

public class Min_Priority_Queue {
	
	private ArrayList<Integer> heap;
	
	int getMin() throws PriorityQueueException{
		if(heap.size()==0)
			throw new PriorityQueueException();
		return heap.get(0);
	}

}
