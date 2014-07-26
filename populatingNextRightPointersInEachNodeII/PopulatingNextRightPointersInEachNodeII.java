package populatingNextRightPointersInEachNodeII;

import common.TreeLinkNode;

/**
 * Follow up for problem "Populating Next Right Pointers in Each Node".
 * What if the given tree could be any binary tree? Would your previous solution still work?
 * @author Mengchao Zhong
 */
public class PopulatingNextRightPointersInEachNodeII {

	/**
	 * Test case.
	 * @param args
	 */
	public static void main(String[] args) {
		// No valid testing data available
	}

	/**
	 * Solution.
	 * @param root
	 */
    public void connect(TreeLinkNode root) {
    	if(root == null) {
    		return;
    	}
    	root.next = null;
    	traverse(root);
    }
    
    public void traverse(TreeLinkNode node) {
    	int i;
    	TreeLinkNode current = null;
    	TreeLinkNode next = null;
    	TreeLinkNode first = findFirstNode(node);
    	if(first == null) {
    	    return;
    	}
    	TreeLinkNode parent = first;
    	if(first.left == null) {
    		i = 1;
    		current = parent.right;
    	}
    	else {
    		i = 0;
    		current = parent.left;
    	}
    	while(true) {
    	    while(next == null) {
        		if(i == 0) {
        			next = parent.right;
        			i = 1;
        		}
        		else {
        		    parent = parent.next;
        			if(parent == null) {
        				break;
        			}
        			next = parent.left;
        			i = 0;
        		}
    	    }
    		current.next = next;
    		if(next == null) {
    		    break;
    		}
    		else {
    		    current = current.next;
    		    next = null;
    		}
    	}
    	traverse(first.left == null ? first.right : first.left);
    }
    
    public TreeLinkNode findFirstNode(TreeLinkNode node) {
    	while(node.left == null && node.right == null) {
    		if(node.next != null) {
    			node = node.next;
    		}
    		else {
    			return null;
    		}
    	}
    	return node;
    }
}
