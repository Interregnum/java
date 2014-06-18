package removeDuplicatesFromSortedList;

import common.ListNode;

/**
 * Given a sorted linked list, delete all duplicates such that each element appear only once.
 * @author Mengchao Zhong
 */
public class RemoveDuplicatesFromSortedList {

	/**
	 * Test Case.
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
    public ListNode deleteDuplicates(ListNode head) {
        if(null == head) {
        	return null;
        }
    	ListNode node = head;
    	while(null != node.next) {
    		if(node.val == node.next.val) {
    			node.next = node.next.next;
    		}
    		else {
    			node = node.next;
    		}
    	}
    	return head;
    }
}
