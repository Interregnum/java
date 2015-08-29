package implementTrie;

import common.TrieNode;

/**
 * Solution.
 * @author Mengchao Zhong
 */
public class Trie {
    
	private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    // Inserts a word into the trie.
    public void insert(String word) {
    	TrieNode node = root;
    	for(int i = 0; i < word.length(); ++i) {
    		int index = word.charAt(i) - 'a';
    		if(node.next[index] == null) {
    			node.next[index] = new TrieNode();
    		}
    		node = node.next[index];
    		node.count++;
    	}
    }

    // Returns if the word is in the trie.
    public boolean search(String word) {
    	TrieNode node = root;
    	for(int i = 0; i < word.length(); ++i) {
        	int index = word.charAt(i) - 'a';
        	if(node.next[index] == null) {
        		return false;
        	}
        	else {
        		node = node.next[index];
        	}
        }
        
    	int nextPathCount = 0;
    	for(int i = 0; i < node.next.length; ++i) {
    		if(node.next[i] != null) {
    			nextPathCount += node.next[i].count;
    		}
    	}
        return node.count - nextPathCount > 0;
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
    	TrieNode node = root;
        for(int i = 0; i < prefix.length(); ++i) {
        	int index = prefix.charAt(i) - 'a';
        	if(node.next[index] == null) {
        		return false;
        	}
        	else {
        		node = node.next[index];
        	}
        }
        return true;
    }
}