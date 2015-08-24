package lowestCommonAncestorOfABinaryTree;

import common.TreeNode;

/**
 * Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.
 * @author Mengchao Zhong
 */
public class LowestCommonAncestorOfABinaryTree {

	/**
	 * Test case.
	 * @param args
	 */
	public static void main(String[] args) {
		TreeNode one = new TreeNode(1);
		TreeNode two = new TreeNode(2);
		TreeNode three = new TreeNode(3);
		TreeNode four = new TreeNode(3);
		TreeNode five = new TreeNode(5);
		TreeNode six = new TreeNode(6);
		one.left = two;
		two.right = three;
		one.right = four;
		two.left = five;
		five.left = six;
		lowestCommonAncestor(one, new TreeNode(3), new TreeNode(6));
	}

	/**
	 * Solution.
	 * @param root
	 * @param p
	 * @param q
	 * @return
	 */
    public static TreeNode output = null;
	
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        postOrderTraverse(root, p, q);
        return output;
    }
    
    public static int postOrderTraverse(TreeNode node, TreeNode p, TreeNode q) {
    	int ret = 0;
    	if(node != null) {
            ret += postOrderTraverse(node.left, p, q) + postOrderTraverse(node.right, p, q);
    		if(node == p) {
    			ret++;
    		}
    		else if(node == q) {
    			ret++;
    		}
    		
    		if(ret == 2) {
			    output = node;
			    ret = 3;
    		}
    	}
    	return ret;
    }
}
