package uniqueBinarySearchTreesII;

import java.util.ArrayList;
import java.util.List;

import common.TreeNode;

/**
 * Given n, generate all structurally unique BST's (binary search trees) that store values 1...n.
 * @author Mengchao Zhong
 */
public class UniqueBinarySearchTreesII {

	/**
	 * Test case.
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(generateTrees(3));
	}

	/**
	 * Solution.
	 * @param n
	 * @return
	 */
    public static List<TreeNode> generateTrees(int n) {
        return bst(1, n);
    }
    
    public static List<TreeNode> bst(int start, int end) {
    	List<TreeNode> cur = new ArrayList<TreeNode>();
    	if(start > end) {
    		cur.add(null);
    	}
    	for(int i = start; i <= end; ++i) {
    		List<TreeNode> left = bst(start, i - 1);
    		List<TreeNode> right = bst(i + 1, end);
    		for(TreeNode l : left) {
    			for(TreeNode r : right) {
    				TreeNode node = new TreeNode(i);
    				node.left = l;
    				node.right = r;
    				cur.add(node);
    			}
    		}
    	}
    	return cur;
    }
}
