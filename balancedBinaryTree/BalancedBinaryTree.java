package balancedBinaryTree;

import common.TreeNode;

/**
 * Given a binary tree, determine if it is height-balanced.
 * For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.
 * @author Mengchao Zhong
 */
public class BalancedBinaryTree {

	/**
	 * Test case.
	 * @param args
	 */
	public static void main(String[] args) {
		// No valid testing data available
	}

	private static boolean flag;
	
	/**
	 * Solution.
	 * @param root
	 * @return
	 */
    public static boolean isBalanced(TreeNode root) {
        flag = true;
        getDepth(root);
        return flag;
    }
    
    public static int getDepth(TreeNode node) {
    	if(null == node) {
    		return 0;
    	}
    	int left = getDepth(node.left);
    	int right = getDepth(node.right);
    	if(left - right > 1 || right - left > 1) {
    		flag = false;
    	}
    	return Math.max(left, right) + 1;
    }
}