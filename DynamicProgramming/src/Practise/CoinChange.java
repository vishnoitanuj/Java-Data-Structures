package Practise;

public class CoinChange {
	
	public static void main(String args[]) {
		int a[]= {1,2,3};
		System.out.println(calculate(a,4));
	}
	
	public static int calculate(int a[],int n) {
		int table[]=new int[n+1];
		table[0]=1;
		for(int i=0;i<a.length;i++) {
			for(int j=a[i];j<=n;j++) {
					table[j]+=table[j-a[i]];
			}
		}
		return table[n];
	}

}
