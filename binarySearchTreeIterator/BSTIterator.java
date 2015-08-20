package binarySearchTreeIterator;

import java.util.Stack;

import common.TreeNode;

/**
 * Implement an iterator over a binary search tree (BST). Your iterator will be initialized with the root node of a BST.
 * Calling next() will return the next smallest number in the BST.
 * @author Mengchao Zhong
 */
public class BSTIterator {

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
    Stack<TreeNode> minStack = new Stack<TreeNode>();
	
	public BSTIterator(TreeNode root) {
		TreeNode node = root;
		while(node != null) {
			minStack.push(node);
			node = node.left;
		}
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !minStack.isEmpty();
    }

    /** @return the next smallest number */
    public int next() {
    	TreeNode node = minStack.pop();
    	TreeNode right = node.right;
    	while(right != null) {
    		minStack.push(right);
    		right = right.left;
    	}
    	return node.val;
    }
    
    /**
     * Your BSTIterator will be called like this:
     * BSTIterator i = new BSTIterator(root);
     * while (i.hasNext()) v[f()] = i.next();
     */
}
