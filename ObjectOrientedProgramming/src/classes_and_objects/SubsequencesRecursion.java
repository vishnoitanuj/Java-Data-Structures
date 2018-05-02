package classes_and_objects;

public class SubsequencesRecursion {

	public static String[] findSubSequence(String na){
		if(na.length()==0){
			String ans[] = {""};
			return ans;
		}
		String smallAns[] = findSubSequence(na.substring(1));
		String ans[] = new String[2*smallAns.length];
		for(int i=0;i<smallAns.length;i++)
			ans[i] = smallAns[i];
		for(int i=0;i<smallAns.length;i++)
			ans[i + smallAns.length] = na.charAt(0)+smallAns[i];
		return ans;
	}
	public static void main(String[] args) {
		String na[] = findSubSequence("xyz");
		for(int i=0;i<na.length;i++)
			System.out.println(na[i]);

	}

}
