package rectangleArea;

/**
 * Find the total area covered by two rectilinear rectangles in a 2D plane.
 * Each rectangle is defined by its bottom left corner and top right corner as shown in the figure.
 * @author Mengchao Zhong
 */
public class RectangleArea {

	/**
	 * Test case.
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(computeArea(-3, 0, 3, 4, 0, -1, 9, 2));
		System.out.println(computeArea2(-2, -2, 2, 2, 3, 3, 4, 4));
	}

	/**
	 * Solution.
	 * @param A
	 * @param B
	 * @param C
	 * @param D
	 * @param E
	 * @param F
	 * @param G
	 * @param H
	 * @return
	 */
	public static int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int minXRecA = A < C ? A : C;
        int minXRecB = E < G ? E : G;
        int maxXRecA = A > C ? A : C;
        int maxXRecB = E > G ? E : G;
        int minYRecA = B < D ? B : D;
        int minYRecB = F < H ? F : H;
        int maxYRecA = B > D ? B : D;
        int maxYRecB = F > H ? F : H;
        
        int areaRecA = (maxXRecA - minXRecA) * (maxYRecA - minYRecA);
        int areaRecB = (maxXRecB - minXRecB) * (maxYRecB - minYRecB);
        
        int overlapX = 0;
        if(maxXRecA > minXRecB && maxXRecB >= maxXRecA) {
        	overlapX = minXRecA < minXRecB ? maxXRecA - minXRecB : maxXRecA - minXRecA;
        }
        else if(maxXRecB > minXRecA && maxXRecA >= maxXRecB) {
        	overlapX = minXRecA > minXRecB ? maxXRecB - minXRecA : maxXRecB - minXRecB;
        }
        
        int overlapY = 0;
        if(maxYRecA > minYRecB && maxYRecB >= maxYRecA) {
        	overlapY = minYRecA < minYRecB ? maxYRecA - minYRecB : maxYRecA - minYRecA;
        }
        else if(maxYRecB > minYRecA && maxYRecA >= maxYRecB) {
        	overlapY = minYRecA > minYRecB ? maxYRecB - minYRecA : maxYRecB - minYRecB;
        }
        
        return areaRecA + areaRecB - overlapX * overlapY;
    }
	
	/**
	 * Solution: Provide that Left Bottoms are always (A,B) and (E,F) and Right Top are always (C,D) and (G,H).
	 * @param A
	 * @param B
	 * @param C
	 * @param D
	 * @param E
	 * @param F
	 * @param G
	 * @param H
	 * @return
	 */
	public static int computeArea2(int A, int B, int C, int D, int E, int F, int G, int H) {
		int areaA = (C - A) * (D - B);
		int areaB = (G - E) * (H - F);
		int areaOverlap = 0;
		
		if(!(A >= G || B >= H || C <= E || D <= F)) {
			areaOverlap = overlap(Math.min(C, G), Math.min(D, H), Math.max(A, E), Math.max(B, F));
		}
		return areaA + areaB - areaOverlap;
	}

	public static int overlap(int xTopRight, int yTopRight, int xBottomLeft, int yBottomLeft) {
		if(xTopRight > xBottomLeft && yTopRight > yBottomLeft) {
			return (xTopRight - xBottomLeft) * (yTopRight - yBottomLeft);
		}
		return 0;
	}
}
