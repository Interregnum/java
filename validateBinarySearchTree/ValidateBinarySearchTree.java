package validateBinarySearchTree;

import common.TreeNode;

/**
 * Given a binary tree, determine if it is a valid binary search tree (BST).
 * @author Mengchao Zhong
 */
public class ValidateBinarySearchTree {

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
	 * @return
	 */
    public boolean isValidBST(TreeNode root) {
        if(root == null) {
        	return true;
        }
        return search(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    
    public boolean search(TreeNode node, int min, int max) {
    	return (node.left == null ? true : node.left.val < node.val && node.left.val > min && search(node.left, min, node.val)) && (node.right == null ? true : node.right.val > node.val && node.right.val < max && search(node.right, node.val, max));
    }
}
