package RecursionAssignment2;

public class returnSubsetofArray {
	
	public static void main(String[] args) {
		int input[] = {1,2,3};
		int output[][]= subsets(input);
		for(int i=0;i<output.length;i++) {
			for(int j=0;j<output[i].length;j++)
				System.out.print(output[i][j]);
			System.out.println();
		}
			
		
	}
	
	public static int[][] subsets(int input[]){
		return subsets(input, 0);
	}
	
	public static int[][] subsets(int input[], int startIndex){
		if(input.length==startIndex) {
			int out[][]=new int[1][0];
			return out;
		}
		int smallOut[][] = subsets(input,startIndex+1);
		int out[][] = new int[2*smallOut.length][];
		int k=0;
		for(int i=0;i<smallOut.length;i++) {
			out[k] = new int[smallOut[i].length];
			for(int j=0;j<smallOut[i].length;j++)
				out[k][j] = smallOut[i][j];
			k++;
		}
		for(int i=0;i<smallOut.length;i++) {
			out[k] = new int[smallOut[i].length+1];
			out[k][0] = input[startIndex];
			for(int j=1;j<=smallOut[i].length;j++)
				out[k][j] = smallOut[i][j-1];
			k++;
		}
		return out;
	}

}
