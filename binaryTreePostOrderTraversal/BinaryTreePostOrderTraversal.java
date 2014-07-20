package binaryTreePostOrderTraversal;

import java.util.ArrayList;
import java.util.List;

import common.TreeNode;

/**
 * Given a binary tree, return the postorder traversal of its nodes' values.
 * @author Mengchao Zhong
 */
public class BinaryTreePostOrderTraversal {

	/**
	 * Test case.
	 * @param args
	 */
	public static void main(String[] args) {
		// No valid testing data available
	}

	private static List<Integer> output = new ArrayList<Integer>();
	
	/**
	 * Solution: Recursion.
	 * @param root
	 * @return
	 */
    public static List<Integer> postorderTraversal(TreeNode root) {
        traverse(root);
        return output;
    }
    
    public static void traverse(TreeNode node) {
    	if(null == node) {
    	    return;
    	}
    	if(null != node.left) {
    		traverse(node.left);
    	}
    	if(null != node.right) {
    		traverse(node.right);
    	}
   		output.add(node.val);
   		return;
    }
}
