package amazonPractice;

/**
 * Point.
 * @author Mengchao Zhong
 */
public class Point implements Comparable<Point> {
	int x;
	int y;

	/**
	 * Constructor.
	 * @param x
	 * @param y
	 */
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}

	/**
	 * Override compareTo Method to compare distance.
	 */
	@Override
	public int compareTo(Point o) {
		return this.x * this.x + this.y * this.y - (o.x * o.x + o.y * o.y);
	}
	
	/**
	 * Override toString Method for better testing.
	 */
	@Override
	public String toString() {
		return "(" + this.x + ", " + this.y + ")";
	}
}