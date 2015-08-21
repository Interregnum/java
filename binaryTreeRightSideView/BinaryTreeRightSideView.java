package binaryTreeRightSideView;

import java.util.ArrayList;
import java.util.List;

import common.TreeNode;

/**
 * Given a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you can see ordered from top to bottom.
 * @author Mengchao Zhong
 */
public class BinaryTreeRightSideView {

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
	List<Integer> output = new ArrayList<Integer>();
	int maxHeight = -1;
	
    public List<Integer> rightSideView(TreeNode root) {
    	recursion(root, 0);
    	return output;
    }
    
    public void recursion(TreeNode node, int height) {
        if(node != null) {
        	if(height > maxHeight) {
        		output.add(node.val);
        		maxHeight = height;
        	}
        	
        	if(node.right != null) {
        		recursion(node.right, height + 1);
        	}
        	if(node.left != null) {
        		recursion(node.left, height + 1);
        	}
        }
    }
}
