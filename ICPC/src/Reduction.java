import java.util.*;
class Reduction {
	
	public static void main(String[] args) {
		
		Scanner d=new Scanner(System.in);
		int t=d.nextInt();
		for(int ct=1;ct<=t;ct++)
		{
			int n=d.nextInt();
			int k=d.nextInt();
			int a[]=new int[n];
			for(int i=0;i<n;i++)
				a[i]=d.nextInt();
			Arrays.sort(a);
			System.out.println(calculate(a,k));
		}
	}

	private static int calculate(int[] a, int k) {
		int sum=0;
		for(int i=1;i<a.length-1;i++) {
			int p=a[i];
			int q=a[i+1];
				int min=Math.min(p, q);
				if(p==a[i-1] && p!=q && i+2<a.length && q==a[i+2]) {
					if(min>k) {
						a[i]-=1;
						a[i+1]-=1;
						i--;
						Arrays.sort(a);
					}
				}
		}
		for(int i=1;i<a.length-1;i++) {
			int p=a[i];
			int q=a[i+1];
			if(p==a[i-1] && p!=q) {
				if(p*2>q && q!=a[a.length]) {
					int min=Math.min(p, q);
					if(min>k) {
						a[i]-=1;
						a[i+1]-=1;
						i--;
						Arrays.sort(a);
					}
				}
				else {
					int min=Math.min(a[i], a[i-1]);
					if(min>k) {
						a[i]-=1;
						a[i-1]-=1;
						i--;
						Arrays.sort(a);
					}
				}
				
			}
		}
		for(int i=0;i<a.length-1;i++) {
			int p=a[i];
			int q=a[i+1];
				int min=Math.min(p, q);
				if(min>k) {
					a[i]-=1;
					a[i+1]-=1;
					i--;
					Arrays.sort(a);
				}
			}
		for(int i=0;i<a.length;i++)
			sum+=a[i];
		return sum;
	}
}
