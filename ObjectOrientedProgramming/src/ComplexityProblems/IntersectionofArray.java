package ComplexityProblems;

public class IntersectionofArray {
	
	public static void sort(int[] a) {
		int i=0,swap=1,j,temp,max;
		while(swap==1){
			swap=-1;
			max=a[i];
			for(j=0;j<a.length-1-i;j++){
				if(a[j]>a[j+1])
				{
					swap=1;
					temp=a[j];
					a[j]=a[j+1];
					a[j+1]=temp;
				}
			}
			++i;
	}
	}
	
	public static void intersection(int[] a,int[] b) {
		sort(a);
		sort(b);
		int i=0,j=0;
		for(i=0;i<a.length;i++)
			System.out.print(a[i]+"\t");
		System.out.println();
		while(i<a.length && j<b.length) {
			if(a[i]==b[j]) {
				System.out.println(a[i]);
				i++;
				j++;
			}
			else if(a[i]<b[j])
				i++;
		else
			j++;
	}
	}
	
	public static void main(String[] args) {
		int a[] = {2 ,6 ,8 ,5 ,4 ,3};
		int b[] = {2, 3, 4, 7};
		intersection(a, b);
	}

}
