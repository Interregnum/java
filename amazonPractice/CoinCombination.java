package amazonPractice;

/**
 * Amazon Interview Practice.
 * @author Mengchao Zhong
 */
public class CoinCombination {

	/**
	 * Test case.
	 * @param args
	 */
	public static void main(String[] args) {
		CoinNode root = new CoinNode(0);
		//System.out.println(coinPath(root, 26));
		//System.out.println(coinPath(root, 20));
		System.out.println(coinPath(root, 77));
		//System.out.println(coinPath(root, 200));
	}

	/**
	 * Output.
	 */
	private static int minPath = Integer.MAX_VALUE;
	
	/**
	 * Solution: Tree.
	 * @param root
	 * @param total
	 * @return
	 */
	public static int coinPath(CoinNode root, int total) {
		traverse(root, total, 0);
		return minPath == Integer.MAX_VALUE ? -1 : minPath;
	}
	
	/**
	 * DFS.
	 * @param node
	 * @param total
	 * @param level
	 */
	public static void traverse(CoinNode node, int total, int level) {
		if(node == null || node.val > total) {
			System.out.println("NO----------------------");
			return;
		}
		if(node.val == total) {
			minPath = Math.min(level, minPath);
			System.out.println("YES---------------------" + level);
			return;
		}
		else {
			node = new CoinNode(node.val, true);
			traverse(node.one, total - node.val, level + 1);
			traverse(node.five, total - node.val, level + 1);
			traverse(node.ten, total - node.val, level + 1);
			traverse(node.twenty, total - node.val, level + 1);
		}
	}
}