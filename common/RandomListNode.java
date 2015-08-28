package common;

/**
 * Definition for singly-linked list with a random pointer.
 * @author Mengchao Zhong
 */
public class RandomListNode {
	
	public int label;
	public RandomListNode next;
	public RandomListNode random;

	public RandomListNode(int x) {
		this.label = x;
	}
}
