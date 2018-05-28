package CN;

public class TrieUse {
	
	public static void main(String args[])throws Exception{
		Trie obj = new Trie();
		obj.add("stop");
		obj.add("andy");
		obj.add("start");
		System.out.println(obj.search("andy"));
		obj.delete("andy");
		System.out.println(obj.search("andy"));
		System.out.println(obj.countWords());
	}

}
