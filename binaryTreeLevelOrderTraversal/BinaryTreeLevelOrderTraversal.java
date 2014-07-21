package binaryTreeLevelOrderTraversal;

import java.util.ArrayList;
import java.util.List;

import common.TreeNode;

/**
 * Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).
 * @author Mengchao Zhong
 */
public class BinaryTreeLevelOrderTraversal {

	/**
	 * Test case.
	 * @param args
	 */
	public static void main(String[] args) {
		// No valid testing data available
	}

	private List<List<Integer>> output = new ArrayList<List<Integer>>();
	
	/**
	 * Solution.
	 * @param root
	 * @return
	 */
    public List<List<Integer>> levelOrder(TreeNode root) {
        traverse(root, 0);
        return output;
    }
    
    public void traverse(TreeNode node, int depth) {
    	if(null == node) {
    		return;
    	}
    	if(output.size() <= depth) {
    		output.add(new ArrayList<Integer>());
    	}
    	output.get(depth).add(node.val);
    	traverse(node.left, depth + 1);
    	traverse(node.right, depth + 1);
    }
}
