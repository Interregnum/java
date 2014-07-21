package linkedListCycleII;

import common.ListNode;

/**
 * Given a linked list, return the node where the cycle begins. If there is no cycle, return null.
 * @author Mengchao Zhong
 */
public class LinkedListCycleII {

	/**
	 * Test case.
	 * @param args
	 */
	public static void main(String[] args) {

	}

	/**
	 * Solution.
	 * @param head
	 * @return
	 */
    public ListNode detectCycle(ListNode head) {
    	if(null == head) {
            return null;
        }
        ListNode slow = head;
        ListNode fast = head;
        while(null != fast.next && null != fast.next.next) {
        	slow = slow.next;
        	fast = fast.next.next;
        	if(slow == fast) {
        		fast = head;
        		while(slow != fast) {
        			slow = slow.next;
        			fast = fast.next;
        		}
        		return slow;
        	}
        }
        return null;
    }
}
