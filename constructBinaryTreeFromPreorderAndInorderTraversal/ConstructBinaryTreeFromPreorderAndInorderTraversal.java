package constructBinaryTreeFromPreorderAndInorderTraversal;

import common.TreeNode;

/**
 * Given preorder and inorder traversal of a tree, construct the binary tree.
 * @author Mengchao Zhong
 */
public class ConstructBinaryTreeFromPreorderAndInorderTraversal {

	/**
	 * Test case.
	 * @param args
	 */
	public static void main(String[] args) {
		int[] i = {3, 2, 1, 4};
		int[] p = {1, 2, 3, 4};
		buildTree(p, i);
	}

	/**
	 * Solution.
	 * @param preorder
	 * @param inorder
	 * @return
	 */
    public static TreeNode buildTree(int[] preorder, int[] inorder) {
    	if(preorder.length != inorder.length || preorder.length == 0) {
    		return null;
    	}
        return build(0, preorder.length - 1, 0, inorder.length - 1, preorder, inorder);
    }
    
    public static TreeNode build(int pStart, int pEnd, int iStart, int iEnd, int[] p, int[] i) {
    	TreeNode node = new TreeNode(p[pStart]);
    	int iRoot;
    	for(iRoot = iStart; iRoot < iEnd; ++iRoot) {
    		if(p[pStart] == i[iRoot]) {
    			break;
    		}
    	}
    	int pEndNew = pStart + (iRoot - iStart);
    	node.left = iRoot == iStart ? null : build(pStart + 1, pEndNew, iStart, iRoot - 1, p, i);
    	node.right = iRoot == iEnd ? null : build(pEndNew + 1, pEnd, iRoot + 1, iEnd, p, i);
    	return node;
    }
}
