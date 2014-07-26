package removeNthNodeFromEndOfList;

import common.ListNode;

/**
 * Given a linked list, remove the nth node from the end of list and return its head.
 * @author Mengchao Zhong
 */
public class RemoveNthNodeFromEndOfList {

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
	 * @param n
	 * @return
	 */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode fast = head;
    	ListNode slow = head;
    	while(n-- > 0) {
    		fast = fast.next;
    	}
    	if(null == fast) {
    		return slow.next;
    	}
    	while(null != fast.next) {
    		fast = fast.next;
    		slow = slow.next;
    	}
    	slow.next = slow.next.next;
    	return head;
    }
}
