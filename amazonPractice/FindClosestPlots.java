package amazonPractice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Amazon Interview Practice.
 * @author Mengchao Zhong
 */
public class FindClosestPlots {

	/**
	 * Test case.
	 * @param args
	 */
	public static void main(String[] args) {
		List<Point> points = new ArrayList<Point>();
		points.add(new Point(3, 2));
		points.add(new Point(4, 4));
		points.add(new Point(1, 1));
		points.add(new Point(2, 3));
		System.out.println(findClosestPlot(points, 1));
	}

	/**
	 * Solution.
	 * @param points
	 * @param num
	 * @return
	 */
	public static List<Point> findClosestPlot(List<Point> points, int num) {
		Collections.sort(points);
		List<Point> output = new ArrayList<Point>();
		for(int i = 0; i < num; ++i) {
			output.add(points.get(i));
		}
		return output;
	}
}