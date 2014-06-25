package symmetricTree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import common.TreeNode;

/**
 * Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).
 * @author Mengchao Zhong
 */
public class SymmetricTree {

	/**
	 * Test case.
	 * @param args
	 */
	public static void main(String[] args) {
		// No valid testing data available
	}

	/**
	 * Solution: Iteration.
	 * @param root
	 * @return
	 */
    public boolean isSymmetric(TreeNode root) {
        if(null == root) {
        	return true;
        }
        List<TreeNode> leftTree = new ArrayList<TreeNode>();
        List<TreeNode> rightTree = new ArrayList<TreeNode>();
        Stack<TreeNode> stack = new Stack<TreeNode>();

        if(null == root.left && null == root.right) {
        	return true;
        }
        else if(null != root.right && null != root.left) {
	        stack.push(root.left);
	        while(!stack.isEmpty()) {
	        	TreeNode node = stack.pop();
	        	leftTree.add(node);
        		if(null != node) {
		        	stack.push(node.right);
	        		stack.push(node.left);
        		}
	        }

	        stack.push(root.right);
	        while(!stack.isEmpty()) {
	        	TreeNode node = stack.pop();
	        	rightTree.add(node);
	        	if(null != node) {
	        		stack.push(node.left);
        			stack.push(node.right);
	        	}
	        }
	        
	        if(leftTree.size() != rightTree.size()) {
	        	return false;
	        }
	        for(int i = 0; i < leftTree.size(); ++i) {
	        	if(null == leftTree.get(i) && null == rightTree.get(i)) {
	        		continue;
	        	}
	        	else if(null != leftTree.get(i) && null != rightTree.get(i)) {
	        	    if(leftTree.get(i).val == rightTree.get(i).val) {
	        	        continue;
	        	    }
	        	    else {
	        	        return false;
	        	    }
	        	}
	        	else {
	        		return false;
	        	}
	        }
	        return true;
        }
        else {
        	return false;
        }
    }
    
    /**
     * Solution: Recursion.
     * @param root
     * @return
     */
    public boolean isSymmetric2(TreeNode root) {
    	if(null == root) {
    		return true;
    	}
    	return symmetricBranch(root.left, root.right);
    }
    
    public boolean symmetricBranch(TreeNode left, TreeNode right) {
    	if(null == left && null == right) {
    		return true;
    	}
    	else if(null != left && null != right) {
    		return left.val == right.val && symmetricBranch(left.left, right.right) && symmetricBranch(left.right, right.left);
    	}
    	else {
    		return false;
    	}
    }
}