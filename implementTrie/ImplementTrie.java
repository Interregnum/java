package implementTrie;

/**
 * Implement a trie with insert, search, and startsWith methods.
 * @author Mengchao Zhong
 */
public class ImplementTrie {

	/**
	 * Test case.
	 * @param args
	 */
	public static void main(String[] args) {
		Trie trie = new Trie();
		trie.insert("dota");
		trie.insert("basketball");
		trie.insert("music");
		System.out.println(trie.search("dota"));
		System.out.println(trie.search("a"));
		System.out.println(trie.search("d"));
		System.out.println(trie.startsWith("basket"));
		System.out.println(trie.startsWith("do"));
		System.out.println(trie.startsWith("ms"));
	}
}
