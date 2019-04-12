package CN;

import java.util.ArrayList;

public class Max_Priority_Queue {
	
private ArrayList<Integer> heap;
	
	public Max_Priority_Queue() {
		heap = new ArrayList<>();
	}

	boolean isEmpty() {
		return heap.size()==0;
	}
	
	int size() {
		return heap.size();
	}
	
	int getMax() throws PriorityQueueException {
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
			if(heap.get(childIndex) > heap.get(parentIndex)) {
				int temp = heap.get(childIndex);
				heap.set(childIndex, heap.get(parentIndex));
				heap.set(parentIndex, temp);
				childIndex = parentIndex;
				parentIndex = (childIndex-1)/2;
			}
			else
				return;
		}
	}
	
	int removeMax() throws PriorityQueueException {
		
		if(isEmpty())
			throw new PriorityQueueException();
		int max = getMax();
		heap.set(0, heap.get(heap.size()-1));
		heap.remove(heap.size()-1);
		int temp;
		int index = 0;
		int maxIndex = index;
		int leftchildIndex = 1;
		int rightchildIndex = 2;
		
		while(leftchildIndex < heap.size()) {
			if(heap.get(leftchildIndex) > heap.get(maxIndex))
				maxIndex = leftchildIndex;
			if(rightchildIndex < heap.size() && heap.get(rightchildIndex) > heap.get(maxIndex))
				maxIndex = rightchildIndex;
			
			if(maxIndex == index)
				break;
			else {
				temp = heap.get(maxIndex);
				heap.set(maxIndex, heap.get(index));
				heap.set(index, temp);
				index = maxIndex;
				leftchildIndex = index * 2 + 1;
				rightchildIndex = index*2 + 2;
			}
		}
		return max;
	}

}
