package swapNodesInPairs;

import common.ListNode;

/**
 * Given a linked list, swap every two adjacent nodes and return its head.
 * @author Mengchao Zhong
 */
public class SwapNodesInPairs {

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
    public ListNode swapPairs(ListNode head) {
        if(null == head || null == head.next) {
        	return head;
        }
        ListNode start = head.next;
        ListNode prevNode = head.next.next;
        ListNode node = head;
        start.next = node;
        node.next = prevNode;
        prevNode = start.next;
        node = node.next;
        while(null != node && null != node.next) {
        	ListNode tmp = node.next.next;
        	node.next.next = node;
        	prevNode.next = node.next;
        	node.next = tmp;
        	prevNode = node;
        	node = tmp;
        }
        return start;
    }
}
