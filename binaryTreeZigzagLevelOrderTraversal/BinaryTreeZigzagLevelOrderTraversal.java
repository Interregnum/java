package binaryTreeZigzagLevelOrderTraversal;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import common.TreeNode;

/**
 * Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right, then right to left for the next level and alternate between).
 * @author Mengchao Zhong
 */
public class BinaryTreeZigzagLevelOrderTraversal {

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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> output = new ArrayList<List<Integer>>();
    	if(root != null) {
    		Stack<TreeNode> stack1 = new Stack<TreeNode>();
	        Stack<TreeNode> stack2 = new Stack<TreeNode>();
	        stack1.add(root);
	        boolean reverse = false;
	        while(!stack1.isEmpty() || !stack2.isEmpty()) {
	        	List<Integer> cur = new ArrayList<Integer>();
	        	while(!stack2.isEmpty() && reverse) {
	        		TreeNode node = stack2.pop();
	        		cur.add(node.val);
	        		if(node.right != null) {
	        			stack1.push(node.right);
	        		}
	        		if(node.left != null) {
	        			stack1.push(node.left);
	        		}
	        	}
	        	while(!stack1.isEmpty() && !reverse) {
	        		TreeNode node = stack1.pop();
	        		cur.add(node.val);
	        		if(node.left != null) {
	        			stack2.push(node.left);
	        		}
	        		if(node.right != null) {
	        			stack2.push(node.right);
	        		}
	        	}
	        	output.add(cur);
	        	reverse = !reverse;
	        }
    	}
        return output;
    }
}
