import java.util.Scanner;

class OrderTeam {
	
	public static void main(String args[])
	{
	Scanner sc=new Scanner(System.in);
	int t=sc.nextInt();
	for(int ct=1;ct<=t;ct++)
	{
	int a[]=new int[3];
	int b[]=new int[3];
	int c[]=new int[3];
	for(int i=0;i<3;i++)a[i]=sc.nextInt();
	for(int i=0;i<3;i++)b[i]=sc.nextInt();
	for(int i=0;i<3;i++)c[i]=sc.nextInt();
	if(equality(a,b)||equality(b,c)||equality(a,c))
	System.out.println("no");
	else 
	System.out.println("yes");
	}
	}
	public static boolean equality(int a[],int b[])
	{
	boolean flag=true;
	for(int i=0;i<3;i++)
	if(a[i]!=b[i])flag=false;
	if(flag)return true;
	boolean flagp=false;boolean flagn=false;
	for(int i=0;i<3;i++)
	{if(a[i]-b[i]>0)flagp=true;
	if(a[i]-b[i]<0)flagn=true;
	if(flagp&&flagn)return true;
	}
	return false;
	}
}
