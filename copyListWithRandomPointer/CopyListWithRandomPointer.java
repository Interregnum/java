package copyListWithRandomPointer;

import common.RandomListNode;

/**
 * A linked list is given such that each node contains an additional random pointer which could point to any node in the list or null.
 * Return a deep copy of the list.
 * @author Mengchao Zhong
 */
public class CopyListWithRandomPointer {

	/**
	 * Test case.
	 * @param args
	 */
	public static void main(String[] args) {
		RandomListNode one = new RandomListNode(1);
		RandomListNode two = new RandomListNode(2);
		RandomListNode three = new RandomListNode(3);
		RandomListNode four = new RandomListNode(4);
		RandomListNode five = new RandomListNode(5);
		one.next = two;
		two.next = three;
		three.next = four;
		four.next = five;
		one.random = null;
		two.random = one;
		three.random = five;
		four.random = five;
		five.random = two;
		copyRandomList2(one);
	}

	/**
	 * Solution.
	 * @param head
	 * @return
	 */
    public static RandomListNode copyRandomList(RandomListNode head) {
    	if(head == null) {
    		return null;
    	}
    	
    	RandomListNode node = head;
    	RandomListNode headCopy = new RandomListNode(head.label);
    	RandomListNode nodeCopy = headCopy;
    	
    	while(node != null) {
    		if(node.random != null) {
    			RandomListNode marker = node;
    			RandomListNode markerCopy = nodeCopy;
    			RandomListNode currentRandomNode = marker.random;
    			node = head;
    			nodeCopy = headCopy;
    			while(node != currentRandomNode && node != marker) {
    				node = node.next;
    				nodeCopy = nodeCopy.next;
    			}
    			if(node != currentRandomNode) {
    				while(node != currentRandomNode) {
    					node = node.next;
    					if(nodeCopy.next == null) {
    						nodeCopy.next = new RandomListNode(node.label);
    					}
    					nodeCopy = nodeCopy.next;
    				}
    			}
    			markerCopy.random = nodeCopy;
    			node = marker;
    			nodeCopy = markerCopy;
    		}
    		if(node.next != null && nodeCopy.next == null) {
				nodeCopy.next = new RandomListNode(node.next.label);
    		}
    		node = node.next;
    		nodeCopy = nodeCopy.next;
    	}
    	
    	return headCopy;
    }
    
    /**
     * Solution: Better.
     * @param head
     * @return
     */
    public static RandomListNode copyRandomList2(RandomListNode head) {
    	if(head == null) {
    		return null;
    	}
    	
    	RandomListNode p = head;
    	
    	while(p != null) {
    		RandomListNode next = p.next;
    		RandomListNode copy = new RandomListNode(p.label);
    		copy.next = next;
    		p.next = copy;
    		p = next;
    	}
    	
    	p = head;
    	while(p != null) {
    		RandomListNode copy = p.next;
    		copy.random = (p.random == null ? null : p.random.next);
    		p = copy.next;
    	}
    	
    	p = head;
    	RandomListNode copyHead = p.next;
    	while(p != null) {
    		RandomListNode copy = p.next;
    		p.next = p.next.next;
    		copy.next = (copy.next == null ? null : copy.next.next);
    		p = p.next;
    	}
    	
    	return copyHead;
    }
}
