package binaryTreePostOrderTraversal;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

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
    }
    
    /**
     * Solution: Iteration.
     * @param root
     * @return
     */
    public static List<Integer> postorderTraversal2(TreeNode root) {
    	List<Integer> result = new ArrayList<Integer>();
    	Stack<TreeNode> stack = new Stack<TreeNode>();
    	if(null == root) {
    		return result;
    	}
    	TreeNode node = root;
    	TreeNode cur = root;
    	boolean l = false;
    	boolean r = false;
    	stack.push(node);
outer: 	
		while(!stack.isEmpty()) {
    		node = stack.peek();
	    	while(null != node.left && !l) {
	    		stack.push(node.left);
	    		r = false;
	    		continue outer;
	    	}
	    	while(null != node.right && !r) {
	    		stack.push(node.right);
	    		l = false;
	    		continue outer;
	    	}
	    	result.add(stack.pop().val);
	    	if(stack.isEmpty()) {
	    		continue;
	    	}
	    	cur = stack.peek();
	    	if(node == cur.left) {
	    		l = true;
	    		r = false;
	    	}
	    	else if(node == cur.right) {
	    		l = true;
	    		r = true;
	    	}
	    	else {
	    		l = false;
	    		r = false;
	    	}
    	}
    	return result;
    }
}
