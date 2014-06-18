package binaryTreeInorderTraversal;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import common.TreeNode;

/**
 * Given a binary tree, return the inorder traversal of its nodes' values.
 * @author Mengchao Zhong
 */
public class BinaryTreeInorderTraversal {

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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> treeNodes = new ArrayList<Integer>();
        if(null == root) {
        	return treeNodes;
        }
        if(null != root.left) {
        	treeNodes.addAll(inorderTraversal(root.left));
        }
        treeNodes.add(root.val);
        if(null != root.right) {
        	treeNodes.addAll(inorderTraversal(root.right));
        }
        return treeNodes;
    }
    
    /**
     * Solution: Iteration.
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal2(TreeNode root) {
    	List<Integer> treeNodes = new ArrayList<Integer>();
    	Stack<TreeNode> stack = new Stack<TreeNode>();
    	if(null != root) {
    		stack.push(root);
	    	TreeNode node = root.left;
	    	while(null != node || !stack.isEmpty()) {
	    		while(null != node) {
	    			stack.push(node);
	    			node = node.left;
	    		}
	    		node = stack.pop();
	    		treeNodes.add(node.val);
	    		node = node.right;
	    	}
    	}
    	return treeNodes;
    }
}
