package bestTimeToBuyAndSellStock;

/**
 * Say you have an array for which the ith element is the price of a given stock on day i.
 * If you were only permitted to complete at most one transaction (ie, buy one and sell one share of the stock), design an algorithm to find the maximum profit.
 * @author Mengchao Zhong
 */
public class BestTimeToBuyAndSellStock {

	/**
	 * Test case.
	 * @param args
	 */
	public static void main(String[] args) {
		int[] stock1 = {1, 2, 3, 6, -5, -1};
		int[] stock2 = {1, 2, 3, 6, -5, 2, 1, 0};
		int[] stock3 = {1, -1, -2, -3, -6};
		System.out.println(maxProfit(stock1));
		System.out.println(maxProfit(stock2));
		System.out.println(maxProfit(stock3));
	}

	/**
	 * Solution.
	 * @param prices
	 * @return
	 */
    public static int maxProfit(int[] prices) {
        int profit = 0;
        int index = 0;
        int max = 0;
        for(int i = 0; i < prices.length; ++i) {
        	if(prices[i] - prices[index] > max) {
        		profit = prices[i] - prices[index];
        		max = profit;
        	}
        	if(prices[i] - prices[index] < 0) {
        		index = i;
        		profit = 0;
        	}
        }
        if(max < 0) {
        	return 0;
        }
        else {
        	return max;
        }
    }
}
