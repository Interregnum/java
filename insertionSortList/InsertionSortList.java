package insertionSortList;

import common.ListNode;

/**
 * Sort a linked list using insertion sort.
 * @author Mengchao Zhong
 */
public class InsertionSortList {

	/**
	 * Test case.
	 * @param args
	 */
	public static void main(String[] args) {
		ListNode node1 = new ListNode(1);
		ListNode node2 = new ListNode(0);
		ListNode node3 = new ListNode(2);
		ListNode node4 = new ListNode(8);
		ListNode node5 = new ListNode(5);
		ListNode node6 = new ListNode(3);
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		node5.next = node6;
		insertionSortList(node1);
	}

	/**
	 * Solution.
	 * @param head
	 * @return
	 */
    public static ListNode insertionSortList(ListNode head) {
    	if(head == null) {
            return null;
        }
    	
        ListNode prev = new ListNode(-1);
        prev.next = head;
        ListNode tail = head;
        
        while(tail.next != null) {
	    	ListNode curr = prev;
	        ListNode node = tail.next;
	        tail.next = node.next;
	        node.next = null;
	        
	        while(curr != tail) {
		        if(node.val > curr.next.val) {
		        	curr = curr.next;
		        }
		        else {
		        	node.next = curr.next;
		        	curr.next = node;
		        	head = prev.next;
		        	break;
		        }
	        }
	        
	        if(curr == tail) {
	        	node.next = tail.next;
	        	curr.next = node;
	        	tail = node;
	        }
        }
        
        return head;
    }

	/**
	 * Solution: Better.
	 * @param head
	 * @return
	 */
    public static ListNode insertionSortList2(ListNode head) {
    	ListNode marker = new ListNode(-1);
    	ListNode curr = head;
    	ListNode next = null;
    	
    	while(curr != null) {
    		next = curr.next;
    		
    		ListNode node = marker;
    		while(node.next != null && node.next.val < curr.val) {
    			node = node.next;
    		}
    		curr.next = node.next;
    		node.next = curr;
    		curr = next;
    	}
    	
    	return marker.next;
    }
}
