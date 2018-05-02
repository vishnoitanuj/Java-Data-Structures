package classes_and_objects;
import java.util.*;

public class aromaSentence {
	public static void sort(String na){
		int i,j,k=0;
		String temp=new String();
		String a[]=na.split(" ");
		for(i=0;i<a.length;i++){
			a[i]=a[i].trim();
		}
		int n=a.length;
        for (i = 0; i < n; i++) 

        {

            for (j = i + 1; j < n; j++) 

            {

                if (a[i].compareTo(a[j])>0) 

                {

                    temp = a[i];

                    a[i] = a[j];

                    a[j] = temp;

                }

            }

        }
		for(i=0;i<a.length;i++){
		System.out.print(a[i]+" ");
	}
	}

	
	public static void main(String[] args) {
		Scanner d = new Scanner(System.in);
		int i,j,f=0;
		char ch;
		String na=new String();
		String t="";
		na=d.nextLine();
		for(i=0;i<na.length();i++){
			ch=na.charAt(i);
			if(ch=='.'|| ch==',' || ch=='!' || ch=='?'){
				sort(t);
				System.out.print(ch);
				t="";
			}
			else{
			t+=ch;
	}
		}
		System.out.println();
		String a[]=na.split(" ");
		String k[]=new String[a.length];
		for(i=0;i<a.length;i++){
			if(a[i].charAt(0)=='A' || a[i].charAt(0)=='E' || a[i].charAt(0)=='I' || a[i].charAt(0)=='O' || a[i].charAt(0)=='U')
			{
				k[f]=a[i];
				f++;
		}
		}
		for(i=0;i<f;i++)		//Outer loop for Comparison		
		{
			if(k[i]!=null)
			{
			
			for(j=i+1;j<f;j++)	//Inner loop for Comparison
			{
				
			if(k[i].equals(k[j]))	//Checking for both strings are equal
				{
					k[j]=null;			//Delete the duplicate words
				}
			}
			}
		}
		for(i=0;i<f;i++){
			if(k[i]!=null)
				System.out.print(k[i]+" ");
		}
}
}
