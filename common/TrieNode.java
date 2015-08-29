package common;

/**
 * Definition for trie.
 * @author Mengchao Zhong
 */
public class TrieNode {

	public int count;
	public TrieNode[] next;
	
    public TrieNode() {
    	this.count = 0;
    	this.next = new TrieNode[26];
    }
}