package bestTimeToBuyAndSellStockII;

/**
 * Say you have an array for which the ith element is the price of a given stock on day i.
 * Design an algorithm to find the maximum profit. You may complete as many transactions as you like (ie, buy one and sell one share of the stock multiple times). However, you may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
 * @author Mengchao Zhong
 */
public class BestTimeToBuyAndSellStockII {

	/**
	 * Test case.
	 * @param args
	 */
	public static void main(String[] args) {
		int[] prices = {1, 11, 2, 4, 5, 6, 11, 4, 8 , 4, 2, 1};
		System.out.println(maxProfit(prices));
	}

	/**
	 * Solution.
	 * @param prices
	 * @return
	 */
    public static int maxProfit(int[] prices) {
    	if(null == prices || prices.length <= 1) {
    		return 0;
    	}
    	
        int profit = 0;
    	for(int i = 1; i < prices.length; ++i) {
        	if(prices[i - 1] < prices[i]) {
        		profit += prices[i] - prices[i - 1];
        	}
        }
    	return profit;
    }
}