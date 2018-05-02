package classes_and_objects;


public class ReplaceCharRecursive {

	public static String replaceCharacter(String input, char c1, char c2) {
		if(input.isEmpty())
          return input;
      String ans=new String();
      if(input.charAt(0)==c1)
        ans+=c2;
      else
    	  ans+=input.charAt(0);
      String smallAns=replaceCharacter(input.substring(1),c1,c2);
      return ans+smallAns;
	}
	
	public static void main(String[] args){
		System.out.println(replaceCharacter("abacd", 'a', 'x'));
	}
}

