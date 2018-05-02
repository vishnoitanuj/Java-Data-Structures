package classes_and_objects;

public class RemoveConsecutiveDuplicatesRecursion {

	public static String removeConsecutiveDuplicates(String s) {
		if(s.length()==1)
			return s;
		String ans=new String();
		if(s.charAt(0)!=s.charAt(1))
			ans+=s.charAt(0);
		String smallAns = removeConsecutiveDuplicates(s.substring(1));
		return ans+smallAns;

	}
	public static void main(String[] args) {
		System.out.println(removeConsecutiveDuplicates("aabccba"));

	}

}
