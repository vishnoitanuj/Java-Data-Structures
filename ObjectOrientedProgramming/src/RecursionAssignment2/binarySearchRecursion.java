package RecursionAssignment2;

public class binarySearchRecursion {
	
	public static int binarySearch(int input[], int element) {
		// Write your code here
      return binarySearch(input,0,input.length-1,element);
      
	}

	private static int binarySearch(int[] input, int r, int l, int element) {
		// TODO Auto-generated method stub
		if(r>=l)
			return -1;
		int mid = (l-r)/2 + r;
		if(input[mid] == element)
			return mid;
		if(element>input[mid])
			return binarySearch(input,mid+1,l, element);
		if(element<input[mid])
			return binarySearch(input,r,mid-1, element);
		return -1;
	}
	
	public static void main(String args[]) {
		int input[] = {1,2,3,4,5,6,7,8};
		System.out.println(binarySearch(input,10));
	}

}
