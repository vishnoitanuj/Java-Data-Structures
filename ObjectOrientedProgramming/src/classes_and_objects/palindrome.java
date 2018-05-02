package classes_and_objects;


public class palindrome {
	public static boolean isStringPalindrome(String na) {
		if(na.length()==1 || na.length()==0)
			return true;
		if(na.charAt(0)!=na.charAt(na.length()-1))
			return false;
		boolean ans = isStringPalindrome(na.substring(1,na.length()-1 ));
		return ans;
	}

	public static void main(String []args){
		System.out.println(isStringPalindrome("naman"));
	}
}
