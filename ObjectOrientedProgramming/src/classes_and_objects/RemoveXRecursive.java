package classes_and_objects;

public class RemoveXRecursive {
	
	public static String removeX(String na){
		if(na.isEmpty())
			return na;
		String ans=new String();
		if(na.charAt(0)!='x')
			ans+=na.charAt(0);
		String smallAns = removeX(na.substring(1));
		return ans+smallAns;
			
	}
	public static void main(String[] args) {
		System.out.println(removeX("xxaabx"));

	}

}
