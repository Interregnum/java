package amazonPractice;

import common.ListNode;

/**
 * Amazon Interview Practice.
 * @author Mengchao Zhong
 */
public class RemoveAlternateNodes {

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
		ListNode six = new ListNode(6);
		one.next = two;
		two.next = three;
		three.next = four;
		four.next = five;
		five.next = six;
		ListNode head = one;
		while(head != null) {
			System.out.print(head.val);
			head = head.next;
		}
		removeAlternate(one);
		head = one;
		while(head != null) {
			System.out.print(head.val);
			head = head.next;
		}
	}

	/**
	 * Solution.
	 * @param head
	 * @return
	 */
	public static ListNode removeAlternate(ListNode head) {
		ListNode slow = head;
		ListNode fast = head;
		while(slow != null && slow.next != null) {
			fast = slow.next.next;
			slow.next = fast;
			slow = slow.next;
		}
		return head;
	}
}
