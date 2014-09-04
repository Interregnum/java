package reverseLinkedListII;

import common.ListNode;

/**
 * Reverse a linked list from position m to n. Do it in-place and in one-pass.
 * @author Mengchao Zhong
 */
public class ReverseLinkedListII {

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
	 * @param m
	 * @param n
	 * @return
	 */
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode mark = new ListNode(-1);
        mark.next = head;
        ListNode start = mark;
        int p1 = m;
        while(--p1 > 0) {
        	mark = mark.next;
        }
        ListNode cur = mark.next;
        while(m < n--) {
        	ListNode next = cur.next;
        	cur.next = cur.next.next;
        	next.next = mark.next;
        	mark.next = next;
        }
        return start.next;
    }	
}
