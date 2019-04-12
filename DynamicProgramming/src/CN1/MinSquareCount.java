package CN1;

public class MinSquareCount {
	
	public static int minCount(int n) {
		int[] storage = new int[n+1];
		storage[0] = 0;
		storage[1] = 1;
		storage[2] = 2;
		storage[3] = 3;
		for(int i=4;i<=n;i++) {
			int ans=i;
			for(int j=1;j<=i/2;j++) {
				int k = i - (j*j);
				if(k>=0) {
					ans = Math.min(ans, storage[k]+1);
				}
			}
			storage[i] = ans;
		}
		return storage[n];
	}

	public static void main(String[] args) {
		System.out.println(minCount(4));

	}

}
