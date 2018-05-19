//This is a Minimum heap
package CN;

import java.util.ArrayList;

public class Priority_Queue {
	
	private ArrayList<Integer> heap;
	
	public Priority_Queue() {
		heap = new ArrayList<>();
	}

	boolean isEmpty() {
		return heap.size()==0;
	}
	
	int size() {
		return heap.size();
	}
	
	int getMin() throws PriorityQueueException {
		if(isEmpty()) {
			//Throw an Exception
			throw new PriorityQueueException();
		}
		
		return heap.get(0);
	}
	
	void insert(int element) {
		heap.add(element);
		int childIndex = heap.size()-1;
		int parentIndex = (childIndex-1)/2;
		
		while(childIndex > 0) {
			if(heap.get(childIndex) < heap.get(parentIndex)) {
				int temp = heap.get(childIndex);
				heap.set(childIndex, heap.get(parentIndex));
				heap.set(parentIndex, temp);
			}
			else
				return;
			childIndex = parentIndex;
			parentIndex = (childIndex-1)/2;
		}
	}
	
	int removeMin() throws PriorityQueueException {
		
		if(isEmpty())
			throw new PriorityQueueException();
		int min = heap.get(0);
		heap.set(0, heap.get(heap.size()-1));
		heap.remove(heap.size()-1);
		int temp;
		int index = 0;
		int minIndex = index;
		int leftchildIndex = 1;
		int rightchildIndex = 2;
		
		while(leftchildIndex < heap.size()) {
			if(heap.get(leftchildIndex) < heap.get(minIndex))
				minIndex = leftchildIndex;
			if(rightchildIndex < heap.size() && heap.get(rightchildIndex)< heap.get(minIndex))
				minIndex = rightchildIndex;
			if(minIndex == index)
				break;
			else {
				temp = heap.get(minIndex);
				heap.set(minIndex,heap.get(index));
				heap.set(index, temp);
				index = minIndex;
				leftchildIndex = 2 * minIndex + 1;
				rightchildIndex = 2 * minIndex + 2;
			}
		}
		return min;
	}
	
	

}
