package hIndex;

import java.util.Arrays;

/**
 * Given an array of citations (each citation is a non-negative integer) of a researcher, write a function to compute the researcher's h-index.
 * @author Mengchao Zhong
 */
public class HIndex {

	/**
	 * Test case.
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(hIndex2(new int[] {3, 0, 6, 1, 5}));
		System.out.println(hIndex2(new int[] {3, 0, 6, 1, 5, 4, 2}));
	}

	/**
	 * Solution.
	 * @param citations
	 * @return
	 */
	public static int hIndex(int[] citations) {
		Arrays.sort(citations);
		int hIndex = citations.length;
		for(int i = 0; i < citations.length; ++i) {
			if(citations[i] >= hIndex) {
				return hIndex;
			}
			else {
				--hIndex;
			}
		}
		return hIndex;
	}
	
	/**
	 * Solution: O(n).
	 * @param citations
	 * @return
	 */
	public static int hIndex2(int[] citations) {
		int[] count = new int[citations.length + 1];
		
		for(int i = 0; i < citations.length; ++i) {
			if(citations[i] >= citations.length) {
				count[citations.length]++;
			}
			else {
				count[citations[i]]++;
			}
		}
		for(int i = citations.length; i > 0; --i) {
			count[i - 1] += count[i]; 
		}
		for(int i = count.length - 1; i > 0; --i) {
			if(count[i] >= i) {
				return i;
			}
		}
		
		return 0;
	}
}
