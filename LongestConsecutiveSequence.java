//Question Link = https://workat.tech/problem-solving/practice/longest-consecutive-sequence

class Solution {
	int longestConsecutiveSequence(int[] A) {
    //We require hashmap to access elements in O(1) time
		HashMap<Integer, Integer> map = new HashMap();
		for(int i=0; i<A.length; i++) {
			if(map.containsKey(A[i])) {
				map.put(A[i], map.get(A[i])+1);
			}
			else {
				map.put(A[i], 1);
			}
		}
		
		int maxCount = 0;
		for(int i=0; i<A.length; i++) {
    
			//This condition is to make sure that we get the count from starting of the sequence
			// If A[i]-1 exists, then the current A[i] is not the start element of the sequence
			//In this way, its O(n) time complexity
      
			if(!map.containsKey(A[i]-1)) {
				int start = A[i];
				int count = 0;
				while(map.containsKey(start)) {
					start++;
					count++;
				}
				maxCount = Math.max(count, maxCount);
			}
		}
		
		return maxCount;
	}
}
