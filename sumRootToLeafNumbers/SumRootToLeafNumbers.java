package sumRootToLeafNumbers;

import common.TreeNode;

/**
 * Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number.
 * Find the total sum of all root-to-leaf numbers.
 * @author Mengchao Zhong
 */
public class SumRootToLeafNumbers {

	/**
	 * Test case.
	 * @param args
	 */
	public static void main(String[] args) {
		// No valid testing data available
	}

	private int sum = 0;
	
	/**
	 * Solution.
	 * @param root
	 * @return
	 */
    public int sumNumbers(TreeNode root) {
        if(root != null) {
        	dfs(0, root); 
        }
    	return sum;
    }
    
    public void dfs(int num, TreeNode node) {
    	num = num * 10 + node.val;
    	if(node.left == null && node.right == null) {
    		sum += num;
    	}
    	if(node.left != null) {
    		dfs(num, node.left);
    	}
    	if(node.right != null) {
    		dfs(num, node.right);
    	}
    }
}
