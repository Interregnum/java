package lowestCommonAncestorOfABinarySearchTree;

import common.TreeNode;

/**
 * Given a binary search tree (BST), find the lowest common ancestor (LCA) of two given nodes in the BST.
 * @author Mengchao Zhong
 */
public class LowestCommonAncestorOfABinarySearchTree {

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
	 * @param p
	 * @param q
	 * @return
	 */
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return recursion(root, p, q);
    }
	
	public TreeNode recursion(TreeNode root, TreeNode p, TreeNode q) {
		if(p.val > q.val) {
			return recursion(root, q, p);
		}
		else if(p.val == q.val) {
			return p;
		}
		else {
			if(p.val == root.val || q.val == root.val) {
				return root;
			}
			else if(p.val < root.val && q.val > root.val) {
				return root;
			}
			else if(p.val < root.val && q.val < root.val) {
				return recursion(root.left, p, q);
			}
			else {
				return recursion(root.right, p, q);
			}
		}
	}
}