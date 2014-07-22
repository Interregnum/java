package pathSum;

import common.TreeNode;

/**
 * Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that adding up all the values along the path equals the given sum.
 * @author Mengchao Zhong
 */
public class PathSum {

	/**
	 * Test case.
	 * @param args
	 */
	public static void main(String[] args) {
		// No valid testing data available
	}

	private boolean flag = false;
	
	/**
	 * Solution.
	 * @param root
	 * @param sum
	 * @return
	 */
    public boolean hasPathSum(TreeNode root, int sum) {
    	traverse(root, sum);
    	return flag;
    }
    
    public void traverse(TreeNode root, int sum) {
    	if(null == root) {
    		return;
    	}
    	if(root.val == sum && root.left == null && root.right == null) {
    		flag = true;
    		return;
    	}
    	traverse(root.left, sum - root.val);
    	traverse(root.right, sum - root.val);
    }
    
	/**
	 * Solution: Optimized Recursion.
	 * @param root
	 * @param sum
	 * @return
	 */
    public boolean hasPathSum2(TreeNode root, int sum) {
    	if(null == root) {
    		return false;
    	}
    	if(null == root.left && null == root.right) {
    		return root.val == sum;
    	}
    	return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
    }
}
