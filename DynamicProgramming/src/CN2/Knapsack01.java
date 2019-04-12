package CN2;

public class Knapsack01 {
	
	public static void main(String[] args) {
		int[] weights = {2,3,4,5};
		int[] values = {1,2,5,6};
		int maxWeight = 8;
		System.out.println(knapsackDP(weights,values,maxWeight));
	}

	public static int knapsack(int[] weights, int[] values, int maxWeight) {
		
		return knapsack(weights, values, maxWeight,0);
	}

	private static int knapsack(int[] weights, int[] values, int maxWeight, int i) {
		
		if(maxWeight==0 || i ==weights.length)
			return 0;
		
		if(weights[i]>maxWeight)
			return knapsack(weights, values, maxWeight,i+1);
		else {
			//include
			int op1 = values[i] + knapsack(weights, values, maxWeight - weights[i], i+1);
			//don't include
			int op2 = knapsack(weights, values, maxWeight,i+1);
			return Math.max(op1, op2);
		}
	}
	
	public static int knapsackDP(int[] weights,int[] values,int maxWeight) {
		int n=values.length;
		int a[][]=new int[n+1][maxWeight+1];
		for(int i=0;i<=n;i++)
			a[i][0]=0;
		for(int j=0;j<=maxWeight;j++)
			a[0][j]=0;
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=maxWeight;j++) {
				if(weights[i-1]<=j)
					a[i][j]=Math.max(values[i-1]+a[i-1][j-weights[i-1]],a[i-1][j] );
				else
					a[i][j]=a[i-1][j];
			}
		}
		int x[]=new int[n];
		int s=maxWeight,f=1,index=n-1;
		for(int i=n;i>0;i--) {
			f=1;
			for(int j=0;j<=maxWeight;j++) {
				if(a[i-1][j]==s) {
					f=0;
					break;
				}
			}
			if(f==0) {
				x[index]=0;
			}
			else {
				x[index]=1;
				s=s-weights[i-1];
			}
			index--;
		}
		for(int i=0;i<n;i++)
			System.out.print(x[i]+" ");
		System.out.println();
		return a[n][maxWeight];
		
	}

}
