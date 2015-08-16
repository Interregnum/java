package deleteNodeInALinkedList;

import common.ListNode;

/**
 * Write a function to delete a node (except the tail) in a singly linked list, given only access to that node.
 * Supposed the linked list is 1 -> 2 -> 3 -> 4 and you are given the third node with value 3, the linked list should become 1 -> 2 -> 4 after calling your function.
 * @author Mengchao Zhong
 */
public class DeleteNodeInALinkedList {

	/**
	 * Test cases.
	 * @param args
	 */
	public static void main(String[] args) {
		ListNode node1 = new ListNode(1);
		ListNode node2 = new ListNode(2);
		ListNode node3 = new ListNode(3);
		ListNode node4 = new ListNode(4);
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		deleteNode(node3);
	}

	/**
	 * Solution.
	 * @param node
	 */
	public static void deleteNode(ListNode node) {
        if(node == null) {
        	return;
        }
        
		while(node.next != null) {
			node.val = node.next.val;
			if(node.next.next == null) {
				node.next = null;
			}
			else {
				node = node.next;
			}
		}
    }
}