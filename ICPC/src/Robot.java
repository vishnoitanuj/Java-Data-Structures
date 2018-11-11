import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Robot {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int t=Integer.parseInt(br.readLine());
		for(int ct=1;ct<=t;ct++)
		{
		String na=br.readLine();
		int c=0;
		int a[]=new int[na.length()];
		for(int i=0;i<na.length();i++) {
			char ch=na.charAt(i);
			if(ch!='.')
				a[c++]=i;
		}
		if(check(na,a, c))
			System.out.println("safe");
		else
			System.out.println("unsafe");
		}
	}

	private static boolean check(String na,int[] a,int c) {
		int i;
		for(i=0;i<c-1;i++) {
			int p=(int)na.charAt(a[i]) -48;
			int q=(int)na.charAt(a[i+1])-48;
			int d = a[i+1]-a[i]-1;
			int sum=p+q;
//			System.out.println(p+" "+q+" "+d);
			if(sum>d)
				return false;
		}
		
		return true;
	}


}
