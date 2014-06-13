package linkedListCycle;

import common.ListNode;

/**
 * Given a linked list, determine if it has a cycle in it.
 * @author Mengchao Zhong
 */
public class LinkedListCycle {

	/**
	 * Test case.
	 * @param args
	 */
	public static void main(String[] args) {
		// No valid testing data available
	}

	/**
	 * Solution.
	 * @param head
	 * @return
	 */
    public boolean hasCycle(ListNode head) {
        if(null == head || null == head.next) {
        	return false;
        }
    	
    	ListNode slow = head;
        ListNode fast = head;
    	
    	while(null != fast.next && null != fast.next.next) {
        	slow = slow.next;
        	fast = fast.next.next;
        	
        	if(slow == fast) {
        		return true;
        	}
        }
    	
    	return false;
    }
}