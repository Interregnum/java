package populatingNextRightPointersInEachNode;

import common.TreeLinkNode;

/**
 * Given a binary tree
 *
 * struct TreeLinkNode {
 * 	TreeLinkNode *left;
 * 	TreeLinkNode *right;
 * 	TreeLinkNode *next;
 * }
 * 
 * Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.
 * Initially, all next pointers are set to NULL.
 * @author Mengchao Zhong
 */
public class PopulatingNextRightPointersInEachNode {

	/**
	 * Test case.
	 * @param args
	 */
	public static void main(String[] args) {

	}

	/**
	 * Solution.
	 * @param root
	 */
    public void connect(TreeLinkNode root) {
    	if(null == root) {
    		return;
    	}
    	TreeLinkNode node = root;
    	while(null != node.left) {
    	    TreeLinkNode firstNodeInLevel = node;
    		while(true) {
    			node.left.next = node.right;
    			if(null == node.next) {
    				break;
    			}
    			node.right.next = node.next.left;
    			node = node.next;
    		}
    		node = firstNodeInLevel.left;
    	}
    }
}
