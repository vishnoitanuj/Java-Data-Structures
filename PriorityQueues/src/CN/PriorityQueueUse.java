package CN;

public class PriorityQueueUse {
	
	public static void main(String[] args) throws PriorityQueueException{
		Max_Priority_Queue pq = new Max_Priority_Queue();
		int arr[] = {5,1,0,3,8,2};
		for(int i=0;i<arr.length;i++)
			pq.insert(arr[i]);
		
		while(!pq.isEmpty()) {
			System.out.print(pq.removeMax()+ " ");
		}
		System.out.println();
	}

}
