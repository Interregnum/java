package recoverBinarySearchTree;

import common.TreeNode;

/**
 * Two elements of a binary search tree (BST) are swapped by mistake.
 * Recover the tree without changing its structure.
 * @author Mengchao Zhong
 */
public class RecoverBinarySearchTree {

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
	public TreeNode nodeA;
	public TreeNode nodeB;
	public int curr = Integer.MIN_VALUE;
	public boolean foundA = false;
	public boolean foundB = false;
	
    public void recoverTree(TreeNode root) {
        recursion(root);
        if(!foundB) {
        	int tmp = nodeA.val;
            nodeA.val = nodeB.val;
            nodeB.val = tmp;
        }
    }
    
    public void recursion(TreeNode node) {
    	if(node == null) {
    		return;
    	}
    	if(foundA && foundB) {
    		return;
    	}
    	recursion(node.left);
    	if(curr < node.val) {
    		curr = node.val;
    		if(!foundA) {
    			nodeA = node;
    		}
    	}
    	else {
    		if(!foundA) {
	    		foundA = true;
				curr = node.val;
				nodeB = node;
    		}
    		else {
    			foundB = true;
    			curr = nodeA.val;
    			nodeA.val = node.val;
    			node.val = curr;
    		}
    	}
    	recursion(node.right);
    }
}
