package Practise;

public class FractionalKnapsack {
	
	public static void main(String[] args) {
		int[] weights = {20, 120, 30};
		int[] values = {60, 10, 100};
		int maxWeight = 50;
		System.out.println(knapsack(weights,values,maxWeight));
	}
	public static double knapsack(int[] weights, int[] values, int maxWeight) {
		double[] ratio = new double[weights.length];
		for(int i=0;i<weights.length;i++)
			ratio[i] = (double)values[i]/weights[i];
		return knapsack(weights, values, maxWeight, ratio);
	}

	private static double knapsack(int[] weights, int[] values, int maxWeight,double ratio[]) {
		
		double currWeight = 0.0;
		double value = 0.0;
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
		double maxRatio = Integer.MIN_VALUE;
		for(int i=0;i<ratio.length;i++) {
			if(ratio[i]>maxRatio) {
				maxRatio = ratio[i];
				index = i;
			}
		}
		ratio[index] = Integer.MIN_VALUE;
		return index;
				
	}

}
