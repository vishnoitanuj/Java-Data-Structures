package CN;

import java.util.HashMap;
import java.util.Set;

public class MapUse {
	
	public static void main(String []args) {
		HashMap<String,Integer> map = new HashMap<>();
		
		//insert
		map.put("abc", 1);
		map.put("def",2);
		map.put("abc",3);
		map.put("abc1",2);
		
		//print size
		System.out.println("size: "+map.size());
		
		//check Presence
		if(map.containsKey("abc")) {
			System.out.println("Has abc");
		}
		
		//check Value: Complexity here is O(n)
		if(map.containsValue(2))
			System.out.println("Has 2 as value");
		
		//get Value
		int v=-1;
		if(map.containsKey("abc"))
			v=map.get("abc");
		System.out.println(v);
		
		//remove
		int s = map.remove("def");
		System.out.println("Removed key" + s);
		
		
		//iterate
		Set<String> keys = map.keySet();
		for(String str : keys)
			System.out.println(str);
	}

}
