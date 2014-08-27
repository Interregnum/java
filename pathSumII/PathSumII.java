package pathSumII;

import java.util.ArrayList;
import java.util.List;

import common.TreeNode;

/**
 * Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.
 * @author Mengchao Zhong
 */
public class PathSumII {

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
	 * @param sum
	 * @return
	 */
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        traverse(root, sum, new ArrayList<Integer>());
        return output;
    }
    
    private List<List<Integer>> output = new ArrayList<List<Integer>>();
    
    public void traverse(TreeNode node, int sum, List<Integer> list) {
    	if(node == null) {
    		return;
    	}
    	List<Integer> update = new ArrayList<Integer>(list);
    	update.add(node.val);
    	if(node.left == null && node.right == null && node.val == sum) {
    		output.add(update);
    	}
    	traverse(node.left, sum - node.val, update);
    	traverse(node.right, sum - node.val, update);
    }
}
