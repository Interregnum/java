package amazonPractice;

/**
 * Coin Denomination
 * @author Mengchao Zhong
 */
public class CoinNode {

	public int val;
	public CoinNode one;
	public CoinNode five;
	public CoinNode ten;
	public CoinNode twenty;
	
	/**
	 * Default Constructor.
	 */
	public CoinNode(int x) {
		this.val = x;
	}
	
	/**
	 * Constructor For Algorithm Optimization.
	 * Constructor of {@link CoinNode}.
	 * @param x
	 * @param y
	 */
	public CoinNode(int x, boolean y) {
		this.val = x;
		if((x == 1 || x == 0) && y) {
			one = new CoinNode(1);
			five = new CoinNode(5);
			ten = new CoinNode(10);
			twenty = new CoinNode(20);
		}
		else if(x == 5 && y) {
			five = new CoinNode(5);
			ten = new CoinNode(10);
			twenty = new CoinNode(20);
		}
		else if(x == 10 && y) {
			ten = new CoinNode(10);
			twenty = new CoinNode(20);
		}
		else if(x == 20 && y) {
			twenty = new CoinNode(20);
		}
	}
}
