package classes_and_objects;
import java.util.Scanner;

public class monk {
	public static long compute(long p){
		int ans=0;
		while(p!=0){
			if(p%2==1)
				ans+=1;
			p/=2;
		}
		return ans;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner d=new Scanner(System.in);
		int t=d.nextInt();
		long[] a=new long[t];
		for(int i=0;i<t;i++){
			a[i]=d.nextLong();
		}
		for(int i=0;i<t;i++)
			System.out.println((int)compute(a[i]));
	}

}
