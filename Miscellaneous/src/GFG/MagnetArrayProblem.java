package GFG;

public class MagnetArrayProblem {
	
	public static void main(String args[]) {
		int a[]= {0, 10, 20, 30};
		calculate(a);
	}
	
	public static void calculate(int a[]) {
		int n=a.length;
		for(int i=0;i<n-1;i++) {
			double sum=1;
			double start=a[i];
			double end=a[i+1];
			double mid=0;
			while(Math.abs(sum)>0.0000000000001) {
				sum=0;
				mid=(start+end)/2;
				for(int j=0;j<n;j++) {
					sum+=1/(mid-a[j]);
				}
				if(sum<0)
					end=mid;
				else
					start=mid;
			}
			System.out.printf("%.2f ",mid);
		}
		
	}

}
