package hIndexII;

/**
 * What if the citations array is sorted in ascending order? Could you optimize your algorithm?
 * @author Mengchao Zhong
 */
public class HIndexII {

	/**
	 * Test case.
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(hIndex(new int[] {1}));
		System.out.println(hIndex(new int[] {0, 1, 3, 5, 6}));
		System.out.println(hIndex(new int[] {0, 1, 2, 3, 4, 5, 6}));
	}

	/**
	 * Solution.
	 * @param citations
	 * @return
	 */
    public static int hIndex(int[] citations) {
		int start = 0;
		int end = citations.length - 1;
		
		while(start <= end) {
			int mid = start + (end - start) / 2;
			
			if(citations[mid] >= citations.length - mid) {
				if(mid == 0 || citations[mid - 1] <= citations.length - mid) {
					return citations.length - mid;
				}
				else {
					end = mid;
				}
			}
			else {
				start = mid + 1;
			}
		}
		return 0;
    }
}
