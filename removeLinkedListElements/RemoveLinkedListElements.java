package removeLinkedListElements;

import common.ListNode;

/**
 * Remove all elements from a linked list of integers that have value val.
 * @author Mengchao Zhong
 */
public class RemoveLinkedListElements {

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
	 * @param val
	 * @return
	 */
    public ListNode removeElements(ListNode head, int val) {
        ListNode fakeHead = new ListNode(0);
        fakeHead.next = head;
        ListNode node = fakeHead;
        
        while(node.next != null) {
        	if(node.next.val == val) {
        		node.next = node.next.next;
        	}
        	else {
        		node = node.next;
        	}
        }
        
        return fakeHead.next;
    }
}