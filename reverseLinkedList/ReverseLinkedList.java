package reverseLinkedList;

import java.util.Stack;

import common.ListNode;

/**
 * Reverse a singly linked list.
 * @author Mengchao Zhong
 */
public class ReverseLinkedList {

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
    public ListNode reverseList(ListNode head) {
        Stack<ListNode> stack = new Stack<ListNode>();
        ListNode newHead;
        
        while(head != null) {
        	stack.push(head);
        	head = head.next;
        }
        
        if(!stack.isEmpty()) {
            newHead = stack.pop();
            ListNode node = newHead;
        	while(!stack.isEmpty()) {
            	node.next = stack.pop();
            	node = node.next;
            }
        }
        else {
        	newHead = null;
        }
        
        return newHead;
    }
    
	/**
	 * Solution: Recursive.
	 * @param head
	 * @return
	 */
    public ListNode reverseList2(ListNode head) {
    	if(head == null) {
    		return null;
    	}
    	
    	if(head.next == null) {
    		return head;
    	}
    	
    	ListNode prev = head;
    	ListNode curr = head.next;
    	prev.next = null;
    	
    	while(curr != null) {
    		ListNode next = curr.next;
    		curr.next = prev;
    		prev = curr;
    		curr = next;
    	}
    	
    	return prev;    
    }
}
