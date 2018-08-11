package GFG;

import java.util.Scanner;

public class SpiralTriversal {
	
	public static void main (String[] args)
	 {
	 Scanner d=new Scanner(System.in);
	     int t=d.nextInt();
	     while(t-->0) {
	    	 int a[][]=new int[4][4];
	     for(int i=0;i<4;i++){
	         for(int j=0;j<4;j++)
	         a[i][j]=d.nextInt();
	     }
	     printSpiral(a);
	     }
	     d.close();
	 }
	 
	 public static void printSpiral(int a[][]){
	     int p=0, s=0,e=4,i=s,j;;
	     do{
	     for(j=s;j<e;j++)
	     System.out.print(a[i][j]+" ");
	     j--;
	     for(i=s+1;i<e;i++)
	     System.out.print(a[i][j]+" ");
	     i--;
	     for(j=e-2;j>=s;j--)
	     System.out.print(a[i][j]+" ");
	     j++;
	     for(i=e-2;i>s;i--)
	     System.out.print(a[i][j]+" ");
	     i++;
	     s++;
	     e--;
	     p++;
	     }while(p<2);
   }

}
