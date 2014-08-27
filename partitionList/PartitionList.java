package partitionList;

import common.ListNode;

/**
 * Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.
 * You should preserve the original relative order of the nodes in each of the two partitions.
 * @author Mengchao Zhong
 *
 */
public class PartitionList {

	/**
	 * Test case.
	 * @param args
	 */
	public static void main(String[] args) {
		// No valid testing data available
		ListNode one = new ListNode(1);
		ListNode two = new ListNode(2);
		two.next = one;
		partition(two, 2);
	}

	/**
	 * Solution.
	 * @param head
	 * @param x
	 * @return
	 */
    public static ListNode partition(ListNode head, int x) {
        ListNode node1 = new ListNode(-1);
        ListNode node2 = new ListNode(-1);
        ListNode head1 = node1;
        ListNode head2 = node2;
        while(head != null) {
        	if(head.val < x) {
        		node1.next = new ListNode(head.val);
        		node1 = node1.next;
        	}
        	else {
        		node2.next = new ListNode(head.val);
        		node2 = node2.next;
        	}
        	head = head.next;
        }
        node1.next = head2.next;
        return head1.next;
    }
}
