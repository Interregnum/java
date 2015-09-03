package bestTimeToBuyAndSellStockIII;

/**
 * Say you have an array for which the ith element is the price of a given stock on day i.
 * Design an algorithm to find the maximum profit. You may complete at most two transactions.
 * @author Mengchao Zhong
 */
public class BestTimeToBuyAndSellStockIII {

	/**
	 * Test case.
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(maxProfit(new int[] {2, 1, 2, 0, 1}));
	}

	/**
	 * Solution.
	 * @param prices
	 * @return
	 */
    public static int maxProfit(int[] prices) {
    	int[] forward = new int[prices.length];
    	int[] backward = new int[prices.length];
    	
    	int min = Integer.MAX_VALUE;
    	for(int i = 0; i < prices.length; ++i) {
    		if(prices[i] < min) {
    			min = prices[i];
    		}
    		forward[i] = prices[i] - min;
    	}
    	
    	int max = Integer.MIN_VALUE;
    	int backwardProfit = 0;
    	for(int i = prices.length - 1; i >= 0; --i) {
    		if(prices[i] > max) {
    			max = prices[i];
    		}
    		if(max - prices[i] > backwardProfit) {
    			backwardProfit = max - prices[i];
    		}
    		backward[i] = backwardProfit;
    	}
    	
    	int maxProfit = 0;
    	for(int i = 0; i < prices.length; ++i) {
    		if(maxProfit < forward[i] + backward[i]) {
    			maxProfit = forward[i] + backward[i];
    		}
    	}
    	
    	return maxProfit;
    }
}
