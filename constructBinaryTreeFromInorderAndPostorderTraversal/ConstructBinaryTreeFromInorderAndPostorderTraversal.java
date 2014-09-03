package constructBinaryTreeFromInorderAndPostorderTraversal;

import common.TreeNode;

/**
 * Given inorder and postorder traversal of a tree, construct the binary tree.
 * @author Mengchao Zhong
 */
public class ConstructBinaryTreeFromInorderAndPostorderTraversal {

	/**
	 * Test case.
	 * @param args
	 */
	public static void main(String[] args) {
		int[] i = {3, 2, 1, 4};
		int[] p = {3, 2, 4, 1};
		buildTree(i, p);
	}

	/**
	 * Solution.
	 * @param inorder
	 * @param postorder
	 * @return
	 */
    public static TreeNode buildTree(int[] inorder, int[] postorder) {
        if(inorder.length != postorder.length || inorder.length == 0) {
        	return null;
        }
        return build(0, inorder.length - 1, 0, postorder.length - 1, inorder, postorder);
    }
    
    public static TreeNode build(int iStart, int iEnd, int pStart, int pEnd, int[] i, int[] p) {
    	TreeNode node = new TreeNode(p[pEnd]);
    	int iRoot;
    	for(iRoot = iStart; iRoot < iEnd; ++iRoot) {
    		if(i[iRoot] == p[pEnd]) {
    			break;
    		}
    	}
    	int pStartNew = pEnd - (iEnd - iRoot);
    	node.right = iRoot == iEnd ? null : build(iRoot + 1, iEnd, pStartNew, pEnd - 1, i, p);
    	node.left = iRoot == iStart ? null : build(iStart, iRoot - 1, pStart, pStartNew - 1, i, p);
    	return node;
    }
}
