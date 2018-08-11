package JPMorgan;

import java.util.*;

public class StockBuyCases {
	
	public static void main(String args[]) {
		List<Integer> prices=new ArrayList<Integer>();
		Scanner d=new Scanner(System.in);
		for(int i=0;i<5;i++)
			prices.add(d.nextInt());
		System.out.println(calculate(prices));
		d.close();
	}

	private static List<Integer> calculate(List<Integer> prices) {
		int n=prices.size(),s1=0,b1=0;
		int maxDiff=prices.get(1)-prices.get(0);
		int minElement=prices.get(0),max=0,min=0;
		for(int i=1;i<n;i++) {
			if(prices.get(i)-minElement>maxDiff) {
				maxDiff=prices.get(i)-minElement;
				s1=i;
			}
			if(prices.get(i)<minElement) {
				minElement=prices.get(i);
				b1=i;
			}
//			if(prices.get(i)>prices.get(max))
//				max=i;
//			if(prices.get(i)<prices.get(min))
//				min=i;
		}
		List<Integer> l=new ArrayList<>();
		System.out.println(maxDiff);
		l.add(b1);
		l.add(s1);
		if(min<max) {
			l.add(min);
			l.add(max);
		}
		else {
		l.add(max);
		l.add(min);
		}
		return l;
	}

}
