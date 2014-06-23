package mergeTwoSortedLists;

import common.ListNode;

/**
 * Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together the nodes of the first two lists.
 * @author Mengchao Zhong
 */
public class MergeTwoSortedLists {

	/**
	 * Test case.
	 * @param args
	 */
	public static void main(String[] args) {

	}

	/**
	 * Solution.
	 * @param l1
	 * @param l2
	 * @return
	 */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    	ListNode thisOne = l1;
    	ListNode thisTwo = l2;
    	ListNode prevOne = l1;
    	ListNode prevTwo = l2;
    	ListNode head = null;
    	
    	if(null == thisOne) {
    		return thisTwo;
    	}
    	if(null == thisTwo) {
    		return thisOne;
    	}
    	if(thisOne.val <= thisTwo.val) {
    		head = l1;
    	}
    	else {
    		head = l2;
    	}
        
    	while(null != thisOne && null != thisTwo) {
    		if(thisOne.val <= thisTwo.val) {
    			prevOne = thisOne;
    			thisOne = thisOne.next;
    			if(null == thisOne) {
    			    break;
    			}
    			if(thisOne.val > thisTwo.val) {
    				prevOne.next = thisTwo;
    			}
    		}
    		else {
    			prevTwo = thisTwo;
    			thisTwo = thisTwo.next;
    			if(null == thisTwo) {
    			    break;
    			}
    			if(thisOne.val <= thisTwo.val) {
    	    		prevTwo.next = thisOne;
    			}
    		}
    	}
    	
    	if(null == thisOne) {
    		prevOne.next = thisTwo;
    	}
    	else {
    		prevTwo.next = thisOne;
    	}
    	
        return head;
    }
}
