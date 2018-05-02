package classes_and_objects;

public class stringtoIntRecursive {
	
	public static int convertStringToInt(String input){
		return convertStringToInt(input,0);
	}
	private static int convertStringToInt(String na,int k){
		if(k>=na.length())
			return 0;
		int t = (int)na.charAt(k) - 48;
		int ans = t*(int)Math.pow(10,na.length()-k-1);
		return ans+convertStringToInt(na, k+1);
	}
	public static void main(String[] args) {
		System.out.println(convertStringToInt("123"));
	}

}
