package classes_and_objects;

public class allIndexRecursive {
	
	public static int[] allIndexes(int[] input,int x){
		int[] output=new int[input.length];
		return allIndexes(input, x,output,0,0);
	}
	
	private static int[] allIndexes(int[] a,int x,int[] output,int startIndex,int n){
		if(startIndex>=a.length){
			int[] o=new int[n];
			for(int i=0;i<n;i++)
				o[i]=output[i];
			return o;
		}
		if(a[startIndex]==x){
			output[n++]=startIndex;
		return allIndexes(a,x,output, startIndex+1,n);
		}
		return allIndexes(a,x,output, startIndex+1,n);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a={1,0,1};
		int[] b;
		b=allIndexes(a, 1);
		for(int i=0;i<b.length;i++)
			System.out.println(b[i]);
	}

}
