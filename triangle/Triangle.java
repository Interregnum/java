package triangle;

import java.util.List;

/**
 * Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row below.
 * @author Mengchao Zhong
 */
public class Triangle {

	/**
	 * Test case.
	 * @param args
	 */
	public static void main(String[] args) {
		// No valid testing data available
	}

	/**
	 * Solution.
	 * @param triangle
	 * @return
	 */
    public int minimumTotal(List<List<Integer>> triangle) {
        for(int i = 1; i < triangle.size(); ++i) {
        	List<Integer> prev = triangle.get(i - 1);
        	List<Integer> cur = triangle.get(i);
        	cur.set(0, cur.get(0) + prev.get(0));
        	for(int j = 1; j < cur.size() - 1; ++j) {
        		cur.set(j, cur.get(j) + Math.min(prev.get(j - 1), prev.get(j)));
        	}
        	cur.set(cur.size() - 1, cur.get(cur.size() - 1) + prev.get(prev.size() - 1));
        }
        int min = Integer.MAX_VALUE;
        for(Integer num : triangle.get(triangle.size() - 1)) {
        	if(num < min) {
        		min = num;
        	}
        }
        return min;
    }
}
