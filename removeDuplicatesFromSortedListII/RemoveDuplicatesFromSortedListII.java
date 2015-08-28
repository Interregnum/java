package removeDuplicatesFromSortedListII;

import common.ListNode;

/**
 * Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list.
 * @author Mengchao Zhong
 */
public class RemoveDuplicatesFromSortedListII {

	/**
	 * Test case.
	 * @param args
	 */
	public static void main(String[] args) {
		ListNode one = new ListNode(1);
		ListNode two = new ListNode(1);
		ListNode three = new ListNode(2);
		ListNode four = new ListNode(3);
		ListNode five = new ListNode(4);
		ListNode six = new ListNode(4);
		ListNode seven = new ListNode(5);
		one.next = two;
		two.next = three;
		three.next = four;
		four.next = five;
		five.next = six;
		six.next = seven;
		deleteDuplicates(one);
	}

	/**
	 * Solution.
	 * @param head
	 * @return
	 */
    public static ListNode deleteDuplicates(ListNode head) {
    	if(head == null) {
            return null;
        }
    	
        ListNode fakeHead = new ListNode(0);
        fakeHead.next = head;
        ListNode prev = fakeHead;
        ListNode node = fakeHead.next;
        
        while(node != null) {
        	if(node.next == null || node.next.val != node.val) {
        		node = node.next;
        		prev = prev.next;
        	}
        	else {
        		int value = node.val;
        		while(node.next != null && node.next.val == value) {
        			node = node.next;
        		}
        		prev.next = node.next;
        		node = prev.next;
        	}
        }
        
        return fakeHead.next;
    }
}
