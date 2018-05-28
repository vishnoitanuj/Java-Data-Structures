package Practise;

public class FractionalKnapsack {
	
	public static void main(String[] args) {
		int[] weights = {10,20,30};
		int[] values = {60,100,120};
		int maxWeight = 50;
		System.out.println(knapsack(weights,values,maxWeight));
	}
	public static int knapsack(int[] weights, int[] values, int maxWeight) {
		double[] ratio = new double[weights.length];
		for(int i=0;i<weights.length;i++)
			ratio[i] = values[i]/weights[i];
		return knapsack(weights, values, maxWeight, ratio);
	}

	private static int knapsack(int[] weights, int[] values, int maxWeight,double ratio[]) {
		
		double currWeight = 0.0;
		int value = 0;
		for(int i=0;i<ratio.length;i++) {
			int index = getMaxRatioIndex(ratio);
			if(currWeight + weights[index] <= maxWeight) {
				currWeight+=(double)weights[index];
				value+=values[index];
			}
			else {
				value += values[index] * ((maxWeight - currWeight)/weights[index]); 
				break;
			}
		}
		return value;
	}

	private static int getMaxRatioIndex(double[] ratio) {
		int index = -1;
		double maxRatio = 0.0;
		for(int i=0;i<ratio.length;i++) {
			if(ratio[i]>maxRatio) {
				maxRatio = ratio[i];
				index = i;
			}
		}
		ratio[index] = 0;
		return index;
				
	}

}