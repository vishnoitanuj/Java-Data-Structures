package classes_and_objects;

public class pairStarRecursive {

	public static String addStars(String s) {
		return addStars(s,0);
	}
	private static String addStars(String na,int k){
		if(k>=na.length()-1)
			return na;
		if(na.charAt(k)==na.charAt(k+1)){
			String t=na.substring(0, k+1)+"*"+na.substring(k+1, na.length());
			return addStars(t,k+2);
		}
		return addStars(na,k+1);
	}
	
	public static void main(String[] args) {
		System.out.println(addStars("helllo"));

	}

}
