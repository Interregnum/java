package minimumDepthOfBinaryTree;

import common.TreeNode;

/**
 * Given a binary tree, find its minimum depth.
 * The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
 * @author Mengchao Zhong
 */
public class MinimumDepthOfBinaryTree {

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
    public int minDepth(TreeNode root) {
    	if(root == null) {
    		return 0;
    	}
    	return levelTraverse(root, 1);
    }
    
    public int levelTraverse(TreeNode root, int depth) {
    	if(root.left == null && root.right == null) {
    		return depth;
    	}
    	return Math.min(
    			root.left != null ? levelTraverse(root.left, depth + 1) : Integer.MAX_VALUE, 
    			root.right != null ? levelTraverse(root.right, depth + 1) : Integer.MAX_VALUE);
    }
}
