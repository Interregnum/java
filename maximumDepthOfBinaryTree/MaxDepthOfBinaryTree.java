package maximumDepthOfBinaryTree;

import common.TreeNode;

/**
 * Given a binary tree, find its maximum depth.
 * @author Mengchao Zhong
 */
public class MaxDepthOfBinaryTree {

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
    public int maxDepth(TreeNode root) {
    	if(null == root) {
    		return 0;
    	}
        else {
        	return 1 + Math.max(maxDepth(root.right), maxDepth(root.left));
        }
    }
}