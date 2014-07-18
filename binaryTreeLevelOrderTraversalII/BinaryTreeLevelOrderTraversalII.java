package binaryTreeLevelOrderTraversalII;

import java.util.ArrayList;
import java.util.List;

import common.TreeNode;

/**
 * Given a binary tree, return the bottom-up level order traversal of its nodes' values. (ie, from left to right, level by level from leaf to root).
 * @author Mengchao Zhong
 */
public class BinaryTreeLevelOrderTraversalII {

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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        traversal(root, 0);
        for(int i = 0; i < output.size() / 2; ++i) {
        	List<Integer> tmp = output.get(i);
        	output.set(i, output.get(output.size() - i - 1));
        	output.set(output.size() - i - 1, tmp);
        }
        return output;
    }
    
    public void traversal(TreeNode node, int depth) {
    	if(null == node) {
    		return;
    	}
    	if(output.size() <= depth) {
    		output.add(new ArrayList<Integer>());
    	}
		output.get(depth).add(node.val);
		traversal(node.left, depth + 1);
		traversal(node.right, depth + 1);
    }
}
