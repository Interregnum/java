package convertSortedListToBinarySearchTree;

import common.ListNode;
import common.TreeNode;

/**
 * Given a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.
 * @author Mengchao Zhong
 *
 */
public class ConvertSortedListToBinarySearchTree {

	/**
	 * Test case.
	 * @param args
	 */
	public static void main(String[] args) {
		ListNode one = new ListNode(1);
		ListNode three = new ListNode(3);
		one.next = three;
		sortedListToBST(one);
	}

	/**
	 * Solution.
	 * @param head
	 * @return
	 */
    public static TreeNode sortedListToBST(ListNode head) {
    	if(head != null) {
    		return convert(head, null);
    	}
    	return null;
    }	
    
    public static TreeNode convert(ListNode head, ListNode tail) {
    	if(head == tail) {
    		return null;
    	}
        ListNode slow = head;
        ListNode fast = head;
        while(fast != tail && fast.next != tail) {
        	slow = slow.next;
        	fast = fast.next.next;
        }
        TreeNode node = new TreeNode(slow.val);
        node.left = convert(head, slow);
        node.right = convert(slow.next, tail);
        return node;
    }
}
