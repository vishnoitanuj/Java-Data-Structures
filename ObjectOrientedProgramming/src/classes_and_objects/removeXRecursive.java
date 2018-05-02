package classes_and_objects;

public class removeXRecursive {

	public static String removeX(String input){
		return removeX(input,0);

	}
	
    private static String removeX(String na,int k){
      if(k>=na.length())
        return na;
      if(na.charAt(k)=='x' || na.charAt(k)=='X'){
        na= na.substring(0,k)+na.substring(k+1,na.length());
        return removeX(na,k);
      }
      return removeX(na,k+1);
    }
    
	public static void main(String[] args) {
		System.out.println(removeX("pxxp"));

	}
}
