package flattenBinaryTreeToLinkedList;

import java.util.Stack;

import common.TreeNode;

/**
 * Given a binary tree, flatten it to a linked list in-place.
 * @author Mengchao Zhong
 */
public class FlattenBinaryTreeToLinkedList {

	/**
	 * Test case.
	 * @param args
	 */
	public static void main(String[] args) {
		// No valid testing data available
	}

	/**
	 * Solution: TLE.
	 * @param root
	 */
    public void flatten(TreeNode root) {
        if(root == null) {
        	return;
        }
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode prev = null;
        stack.push(root);
        while(!stack.isEmpty()) {
        	TreeNode node = stack.pop();
        	if(node.right != null) {
        		stack.push(node.right);
        	}
        	if(node.left != null) {
        		stack.push(node.left);
        	}
        	if(prev != null) {
        		prev.right = node;
        	}
        	prev = node;
        }
    }
    
	/**
	 * Solution: Faster.
	 * @param root
	 */
    public void flatten2(TreeNode root) {
    	convert(root);
    }
    
    public TreeNode convert(TreeNode node) {
    	if(node == null) {
    		return null;
    	}
    	if(node.left == null && node.right == null) {
    		return node;
    	}
    	else if(node.left == null) {
    		return convert(node.right);
    	}
    	else if(node.right == null) {
    		node.right = node.left;
    		node.left = null;
    		return convert(node.right);
    	}
    	else {
    		TreeNode leftLeaf = convert(node.left);
    		TreeNode rightLeaf = convert(node.right);
    		leftLeaf.right = node.right;
    		node.right = node.left;
    		node.left = null;
    		return rightLeaf;
    	}
    }
}
