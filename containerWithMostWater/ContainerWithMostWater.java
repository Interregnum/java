package containerWithMostWater;

/**
 * Given n non-negative integers a1, a2, ..., an, where each represents a point at coordinate (i, ai). n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). Find two lines, which together with x-axis forms a container, such that the container contains the most water.
 * @author Mengchao Zhong
 *
 */
public class ContainerWithMostWater {

	/**
	 * Test case.
	 * @param args
	 */
	public static void main(String[] args) {
		int[] heights = {2, 3, 5, 1, 2, 4};
		System.out.println(maxArea(heights));
	}

	/**
	 * Solution.
	 * @param height
	 * @return
	 */
    public static int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int max = 0;
        while(right - left > 0) {
        	int lower = Math.min(height[left], height[right]);
        	max = Math.max(max, lower * (right - left));
        	if(lower == height[left]) {
        		++left;
        	}
        	else {
        		--right;
        	}
        }
        return max;
    }
}
