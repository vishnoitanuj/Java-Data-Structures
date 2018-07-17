package GeeksforGeeks;

import java.util.*;
class MailSystem{
	public static void main(String []args)throws Exception{
		Scanner d = new Scanner(System.in);
		int t = d.nextInt();
		while(t-->0) {
			int n = d.nextInt();
			LinkedList<Integer> lu = new LinkedList<>();
			LinkedList<Integer> lr = new LinkedList<>();
			LinkedList<Integer> lt = new LinkedList<>();
			for(int i=1;i<=n;i++)
				lu.add(i);
			int x = d.nextInt();
			for(int i=0;i<x;i++) {
				int a = d.nextInt();
				int b = d.nextInt();
				if(a==1) {
					int y = lu.indexOf(b);
					lr.add(b);
					lu.remove(y);
				}
				if(a==2) {
					int y = lr.indexOf(b);
					lt.add(b);
					lr.remove(y);
				}
				if(a==3) {
					int y = lu.indexOf(b);
					lt.add(b);
					lu.remove(y);
				}
				if(a==4) {
					int y = lt.indexOf(b);
					lr.add(b);
					lt.remove(y);
				}
			}
			if(lu.isEmpty())
				System.out.println("EMPTY");
			else {
				for(int i=0;i<lu.size();i++)
					System.out.print(lu.get(i)+" ");
				System.out.println();
			}
			if(lr.isEmpty())
				System.out.println("EMPTY");
			else {
				for(int i=0;i<lr.size();i++)
					System.out.print(lr.get(i)+" ");
				System.out.println();
			}
			if(lt.isEmpty())
				System.out.println("EMPTY");
			else {
				for(int i=0;i<lt.size();i++)
					System.out.print(lt.get(i)+" ");
				System.out.println();
			}
		}
		d.close();
	}
}