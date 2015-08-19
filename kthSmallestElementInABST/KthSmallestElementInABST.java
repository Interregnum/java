package kthSmallestElementInABST;

import java.util.Stack;

import common.TreeNode;

/**
 * Given a binary search tree, write a function kthSmallest to find the kth smallest element in it.
 * @author Mengchao Zhong
 */
public class KthSmallestElementInABST {

	/**
	 * Test case.
	 * @param args
	 */
	public static void main(String[] args) {
		TreeNode node1 = new TreeNode(2);
		node1.left = new TreeNode(1);
		System.out.println(kthSmallest(node1, 2));
	}

	/**
	 * Solution.
	 * @param root
	 * @param k
	 * @return
	 */
    public static int kthSmallest(TreeNode root, int k) {
    	Stack<TreeNode> stack = new Stack<TreeNode>();
    	stack.push(root);
    	TreeNode node = root.left;
    	
        while(node != null || !stack.isEmpty()) {
        	while(node != null) {
        		stack.push(node);
        		node = node.left;
        	}
        	
        	node = stack.pop();
        	k--;
        	
        	if(k == 0) {
        		return node.val;
        	}
        	
       		node = node.right;
        }
        
        return 0;
    }
}
