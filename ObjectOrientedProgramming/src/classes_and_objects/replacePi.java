package classes_and_objects;

public class replacePi {

	public static String replace(String na){
		return replace(na,0);		
	}
	private static String replace(String na,int k){
		if(k>na.length()-2)
			return na;
		if(na.substring(k, k+2).equalsIgnoreCase("pi")){
			String t=new String();
			t=na.substring(0,k);
			t+="3.14";
			t+=na.substring(k+2,na.length());
			na=t;
			return replace(na,k+4);
		}
		return replace(na,k+1);
	}
	public static void main(String[] args) {
		String in = replace("pippiippip");
		String out = "3.14p3.14ip3.14p";
		if(in.equals(out))
			System.out.println("True");
		else
			System.out.println("False");
	}

}
