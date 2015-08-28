package reverseNodesInKGroup;

import common.ListNode;

/**
 * Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.
 * If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.
 * You may not alter the values in the nodes, only nodes itself may be changed.
 * Only constant memory is allowed.
 * @author Mengchao Zhong
 */
public class ReverseNodesInKGroup {

	/**
	 * Test case.
	 * @param args
	 */
	public static void main(String[] args) {
		ListNode one = new ListNode(1);
		ListNode two = new ListNode(2);
		ListNode three = new ListNode(3);
		ListNode four = new ListNode(4);
		ListNode five = new ListNode(5);
		one.next = two;
		two.next = three;
		three.next = four;
		four.next = five;
		reverseKGroup(one, 2);
	}

	/**
	 * Solution.
	 * @param head
	 * @param k
	 * @return
	 */
    public static ListNode reverseKGroup(ListNode head, int k) {
        ListNode start = head;
        ListNode end = new ListNode(0);
        end.next = start;
        ListNode node = head;
        int count = 1;
        
        while(node != null) {
        	if(count % k != 0) {
        		node = node.next;
        	}
        	else {
        		ListNode tmp = start;
        		while(start != node) {
        			ListNode next = tmp.next;
        			tmp.next = next.next;
        			next.next = start;
        			start = next;
        		}
        		if(count == k) {
        			head = node;
        		}
        		end.next = start;
        		end = tmp;
        		start = tmp.next;
        		node = tmp.next;
        	}
    		++count;
        }
        
        return head;
    }
}