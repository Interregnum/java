package convertSortedArrayToBinarySearchTree;

import common.TreeNode;

/**
 * Given an array where elements are sorted in ascending order, convert it to a height balanced BST.
 * @author Mengchao Zhong
 */
public class ConvertSortedArrayToBinarySearchTree {

	/**
	 * Test case.
	 * @param args
	 */
	public static void main(String[] args) {
		// No valid testing data available
	}

	/**
	 * Solution.
	 * @param num
	 * @return
	 */
	public static TreeNode sortedArrayToBST(int[] num) {
       if(null == num) {
    	   return null;
       }
       return binaryConvert(num, 0, num.length);
    }
	
	public static TreeNode binaryConvert(int[] num, int start, int end) {
		if(start >= end) {
			return null;
		}
		int mid = (start + end) / 2;
		TreeNode root = new TreeNode(num[mid]);
		root.left = binaryConvert(num, start, mid);
		root.right = binaryConvert(num, mid + 1, end);
		return root;
	}
}