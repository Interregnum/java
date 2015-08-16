package invertBinaryTree;

import common.TreeNode;

/**
 * Invert a binary tree.
 * @author Mengchao Zhong
 */
public class InvertBinaryTree {

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
	public TreeNode invertTree(TreeNode root) {
        recursion(root);
        return root;
    }
	
	public void recursion(TreeNode node) {
		if(node == null) {
			return;
		}
		
		if(node.left == null && node.right == null) {
			return;
		}
		
		TreeNode temp = node.left;
		node.left = node.right;
		node.right = temp;
		
		recursion(node.left);
		recursion(node.right);
	}
}