package intersectionOfTwoLinkedLists;

import common.ListNode;

/**
 * Write a program to find the node at which the intersection of two singly linked lists begins.
 * @author Mengchao Zhong
 */
public class IntersectionOfTwoLinkedList {

	/**
	 * Test case.
	 * @param args
	 */
	public static void main(String[] args) {
		// No valid testing data available
	}

	/**
	 * Solution.
	 * @param headA
	 * @param headB
	 * @return
	 */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lenA = 0;
        int lenB = 0;
        ListNode nodeA = headA;
        ListNode nodeB = headB;
        
        while(nodeA != null && nodeB != null) {
        	nodeA = nodeA.next;
        	nodeB = nodeB.next;
        	lenA++;
        	lenB++;
        }
        
        while(nodeA != null) {
        	nodeA = nodeA.next;
        	lenA++;
        }
        
        while(nodeB != null) {
        	nodeB = nodeB.next;
        	lenB++;
        }
        
        nodeA = headA;
        nodeB = headB;
        
        for(int i = 0; i < Math.abs(lenA - lenB); ++i) {
        	if(lenA > lenB) {
        		nodeA = nodeA.next;
        	}
        	else {
        		nodeB = nodeB.next;
        	}
        }
        
        while(nodeA != null && nodeB != null) {
        	if(nodeA == nodeB) {
        		return nodeA;
        	}
        	else{
        		nodeA = nodeA.next;
        		nodeB = nodeB.next;
        	}
        }
        
        return null;
    }
    
	/**
	 * Solution: Nicer.
	 * @param headA
	 * @param headB
	 * @return
	 */
    public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        ListNode nodeA = headA;
        ListNode nodeB = headB;
        
        while(nodeA != null && nodeB != null) {
        	if(nodeA == nodeB) {
        		return nodeA;
        	}
        	
        	nodeA = nodeA.next;
        	nodeB = nodeB.next;
        	
        	if(nodeA == null && nodeB == null) {
        	    return null;
        	}
        	
        	if(nodeA == null) {
            	nodeA = headB;
            }
        	
            if(nodeB == null) {
            	nodeB = headA;
            }
        }
        
        return null;
    }
}