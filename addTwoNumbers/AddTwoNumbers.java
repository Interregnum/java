package addTwoNumbers;

import common.ListNode;

/**
 * You are given two linked lists representing two non-negative numbers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
 * @author Mengchao Zhong
 */
public class AddTwoNumbers {

	/**
	 * Test case.
	 * @param args
	 */
	public static void main(String[] args) {
		// No valid testing data available
	}

	/**
	 * Solution.
	 * @param l1
	 * @param l2
	 * @return
	 */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode sum = new ListNode(-1);
        ListNode head = sum;
        int carry = 0;
        int tmp = 0;
    	while(l1 != null && l2 != null) {
    		tmp = l1.val + l2.val + carry;
    		carry = tmp / 10;
    		l1 = l1.next;
    		l2 = l2.next;
    		sum.next = new ListNode(tmp % 10);
    		sum = sum.next;
    	}
    	while(l2 != null) {
    		tmp = l2.val + carry;
    		carry = tmp / 10;
    		l2 = l2.next;
    		sum.next = new ListNode(tmp % 10);
    		sum = sum.next;
    	}
    	while(l1 != null) {
    		tmp = l1.val + carry;
    		carry = tmp / 10;
    		l1 = l1.next;
    		sum.next = new ListNode(tmp % 10);
    		sum = sum.next;
    	}
    	if(carry != 0) {
    		sum.next = new ListNode(carry);
    	}
    	return head.next; 
    }
}
