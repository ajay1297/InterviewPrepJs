// Question Link = https://workat.tech/problem-solving/practice/longest-subarray-zero-sum
// Time - O(n), space - O(n)

// if prefixSum[0 - 3] = 5, prefixSum[0 - 7] = 5
// This indicates that sum from 4th index to 7th index is 0, so that prefixSum is same for prefixSum[0 - 3], prefixSum[0 - 7]

class Solution {
	int longestSubarrayWithZeroSum(int[] A) {
		HashMap<Integer, Integer> prefixSumMap = new HashMap();
		int longest = 0;
		int prefixSum = 0;
		for(int i=0; i<A.length; i++) {
			prefixSum += A[i];
			if(prefixSum == 0) {
				// prefixSum will be the sum from the 0th index of the array
				// If prefixSum = 0, then from 0th index to current index sum is 0
				longest = i+1;
			}
			else if(prefixSumMap.containsKey(prefixSum)) {
				// prefixSum[0 - 3] = 5, prefixSum[0 - 7] = 5
				// This indicates that sum from 4th index to 7th index is 0, so that prefixSum is same for above both
				longest = Math.max(longest, (i - prefixSumMap.get(prefixSum)));
			}
			else {
				// Track the prefixSum and index
				prefixSumMap.put(prefixSum, i);
			}
		}
		return longest;
	}
}
