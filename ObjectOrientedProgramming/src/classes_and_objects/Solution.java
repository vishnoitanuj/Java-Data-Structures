package classes_and_objects;
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
import java.util.Arrays;

public class Solution {

    static int angryChildren(int k, int[] a) {
        Arrays.sort(a);
        int i,j,uf=a[a.length-1];
//        for(i=0;i<a.length;i++)
//        	System.out.print(a[i]+" ");
        int temp=a.length%k;
        for(i=0;i<a.length-temp;i+=k){
        int max=Integer.MIN_VALUE,min=Integer.MAX_VALUE;
        for(j=i;j<(i+k) && j<a.length-temp;j++){
            if(a[j]<min)
                min=a[j];
            if(a[j]>max)
                max=a[j];
        }
           int t=max-min;
           if(t<uf)
               uf=t;
        }
        return uf;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int[] arr = new int[n];
        for(int arr_i = 0; arr_i < n; arr_i++){
            arr[arr_i] = in.nextInt();
        }
        int result = angryChildren(k, arr);
        System.out.println(result);
        in.close();
    }
}
