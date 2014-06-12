package sameTree;

import common.TreeNode;

/**
 * Given two binary trees, write a function to check if they are equal or not.
 * @author Mengchao Zhong
 */
public class SameTree {

	/**
	 * Test case.
	 * @param args
	 */
	public static void main(String[] args) {
		// No valid testing data available
	}
	
	/**
	 * Solution.
	 * @param p
	 * @param q
	 * @return
	 */
    public boolean isSameTree(TreeNode p, TreeNode q) {
    	if(null == p && null == q) {
    		return true;
    	}
    	else if(null != p && null != q && p.val == q.val){
    		return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    	}
    	else {
    		return false;
    	}
    }
}