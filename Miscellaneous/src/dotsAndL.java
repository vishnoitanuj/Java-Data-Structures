import java.util.Scanner;

public class dotsAndL {
	
	public static void main(String args[]) {
		Scanner d=new Scanner(System.in);
		int m=d.nextInt();
		int n=d.nextInt();
		char a[][]=new char[m][n];
		for(int i=0;i<m;i++) {
			for(int j=0;j<n;j++)
				a[i][j]=d.next().charAt(0);
		}
		System.out.println(calculate(a, m, n));
		
	}
	
	public static int calculate(char a[][],int m,int n) {
		int k=0,f=0,max_k=0;
		for(int j=0;j<m;j++) {
			for(int i=0;i<n;i++) {
				
				if(a[i][j]=='.')
					k++;
				if(i+1<n) {
					if(a[i][j]=='.' && a[i+1][j]!='.' && k>=1) {
						for(int l=j+1;l<=(j+1+k);l++) {
							if(a[i][l]!='.') {
								f=-1;
								break;
							}
						}
						if(f!=-1) {
							if(k>max_k)
								max_k=(k+1)*2;
						}
					}
				}
				else if(i+1==n) {
					if(a[i][j]=='.' && k>=1) {
						for(int l=j+1;l<=(j+1+k);l++) {
							if(a[i][l]!='.') {
								f=-1;
								break;
							}
						}
						if(f!=-1) {
							if(k>max_k)
								max_k=(k+1)*2;
						}
					}
				}
				else {
					k=0;
					break;
				}
			}
		}
		return max_k;
		
	}

}
