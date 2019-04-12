package JPMorgan;

public class FindMatches {
	
	public static void calculate(String na[],String q[]) {
		for(int i=0;i<q.length;i++) {
			String a[]=q[i].trim().split(" ");
			for(int j=0;j<na.length;j++) {
				String sen[]=na[j].trim().split(" ");
				int count=0;
				for(int k=0;k<a.length;k++) {
					for(int h=0;h<sen.length;h++) {
						if(sen[h].equals(a[k]))
							count++;
					}
				}
				if(count==a.length)
					System.out.print(j+" ");
			}
			System.out.println();
		}
	}
	
	public static void main(String args[]) {
		String sentences[]= {"Bob And Alice Like","Harry Like Bob","Wonder Land"};
		String query[]= {"Bob Like","Harry","Land"};
		calculate(sentences, query);
	}

}
