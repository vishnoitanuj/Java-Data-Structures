package CN1;

public class MinStepsTo1 {
	
	public static void main(String[] args) {
		System.out.println(countStepsDP(500));
		System.out.println(countStepsM(500));
		System.out.println(countStepsR(500));
	}

	public static int countStepsR(int n) {
		if(n==1)
			return 0;
		int option1,option2,option3;
		option1 = option2 = option3 =Integer.MAX_VALUE;
		option1 = countStepsR(n-1);
		if(n%2 == 0)
			option2 = countStepsR(n/2);
		if(n%3==0)
			option3 = countStepsR(n/3);
		return 1 + Math.min(option1, Math.min(option2,option3));
	}
	
	//Memoization
	public static int countStepsM(int n) {
		int[] storage = new int[n+1];
		for(int i=0;i<=n;i++)
			storage[i]=-1;
		return countStepsM(n,storage);
	}

	private static int countStepsM(int n, int[] storage) {
		if(n==1 || n==2) {
			storage[n] = n-1;
		}
		if(storage[n]!=-1)
			return storage[n];
		int option1,option2,option3;
		option1 = option2 = option3 =Integer.MAX_VALUE;
		option1 = countStepsM(n-1,storage);
		if(n%2 == 0)
			option2 = countStepsM(n/2,storage);
		if(n%3==0)
			option3 = countStepsM(n/3,storage);
		storage[n] =  1 + Math.min(option1, Math.min(option2,option3));
		return storage[n];
	}
	
	public static int countStepsDP(int n) {
		int storage[] = new int[n+1];
		for(int i=2;i<=n;i++) {
			int min = storage[i-1];
			if(i%3==0) {
				if(storage[i/3]<min)
					min=storage[i/3];
			}
			if(i%2==0) {
				if(storage[i/2]<min)
					min=storage[i/2];
			}
			storage[i] = 1+min;
		}
		return storage[n];
	}
}
