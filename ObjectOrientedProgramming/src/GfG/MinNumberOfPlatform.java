package GfG;

import java.util.Arrays;

public class MinNumberOfPlatform {
	
	public static void main(String args[]) {
		int arr[] = {900, 940, 950, 1100, 1500, 1800};
	    int dep[] = {910, 1200, 1120, 1130, 1900, 2000};
	    int n = arr.length;
	    System.out.println("Minimum Number of Platforms Required = "
	                        + findPlatform(arr, dep, n));
	}

	public static int findPlatform(int[] arr, int[] dep, int n) {
		Arrays.sort(arr);
		Arrays.sort(dep);
		int result=1,plt=1,i=1,j=0;
		while(i<n && j<n) {
			if(arr[i]<dep[j]) {
				plt++;
				i++;
				if(plt>result)
					result=plt;
			}
			else {
				plt--;
				j++;
			}
		}
		return result;
	}
}
