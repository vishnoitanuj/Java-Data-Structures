package GFG;

import java.util.ArrayList;

class Stock{
	int buy,sell;
}
public class StockBuySell {
	
	public static void MaxProfit(int a[]) {
		int n=a.length;
		if(n==1)
			return;
		int count=0,i=0;
		ArrayList<Stock> sol=new ArrayList<>();
		while(i<n-1) {
			//find local minimum
			while((i<n-1) && a[i]>=a[i+1])
				i++;
			if(i==n-1)
				break;
			Stock e=new Stock();
			e.buy=i++;
			
			while((i< n-1) && (a[i]>=a[i-1]))
				i++;
			e.sell=i-1;
			sol.add(e);
			count++;
		}
		if(count==0)
			return;
		else {
			for(int j=0;j<count;j++) {
				System.out.println("Buy "+sol.get(j).buy+"  Sell "+sol.get(j).sell);
			}
		}
	}
	
	public static void main(String args[])
	{
		int price[] = {100, 180, 260, 310, 40, 535, 695};
        MaxProfit(price);
	}

}
