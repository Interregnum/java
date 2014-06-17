package binaryTreePreorderTraversal;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import common.TreeNode;

/**
 * Given a binary tree, return the preorder traversal of its nodes' values.
 * @author Mengchao Zhong
 */
public class BinaryTreePreorderTraversal {

	/**
	 * Test case.
	 * @param args
	 */
	public static void main(String[] args) {
		// No valid testing data available
	}
	
	/**
	 * Solution: Recursion.
	 * @param root
	 * @return
	 */
    public List<Integer> preorderTraversal(TreeNode root) {
    	List<Integer> treeNodes = new ArrayList<Integer>();
    	if(null != root) {
	    	treeNodes.add(root.val);
	    	if(null != root.left) {
	    		treeNodes.addAll(preorderTraversal(root.left));
	    	}
	    	if(null != root.right); {
	    		treeNodes.addAll(preorderTraversal(root.right));
	    	}
    	}
    	return treeNodes;
    }
    
    /**
     * Solution: Iteration.
     * @param root
     * @return
     */
    public List<Integer> preorderTraversal2(TreeNode root) {
    	List<Integer> treeNodes = new ArrayList<Integer>();
    	Stack<TreeNode> stack = new Stack<TreeNode>();
    	if(null != root) {
    		stack.push(root);
    	}
    	while(!stack.isEmpty()) {
    		TreeNode node = stack.pop();
    		treeNodes.add(node.val);
    		if(null != node.right) {
    			stack.push(node.right);
    		}
    		if(null != node.left) {
    			stack.push(node.left);
    		}
    	}
    	return treeNodes;
    }
}