// Question = https://workat.tech/problem-solving/practice/subarray-with-xor
// Time = O(n), space = O(n)

/*
  prefixXor[0-5] = 10, if prefixXor[0-3] is 5, and target is 9
  prefixXor[0-3] ^ target = 10
  prefixXor[0-5] = 10
  then we can tell that there is subarray of [3-5] whose Xor is equal to target.
  
  prefixXor[0-3] ^ target =  prefixXor[0-5]
  prefixXor[0-3] = prefixXor[0-5] ^ target
  
  If we find the count of prefixXor[0-3], then that would be equal to subarrays which are equal to target.
*/
class Solution {
	int numSubarrayWithXOR(int[] A, int target) {
		int prefixXor = 0;

    // Map contains prefixXorCount which contains count of prefixXor's
		HashMap<Integer, Integer> prefixXorCount = new HashMap();
		int count = 0;
		for(int i=0; i<A.length; i++) {
			prefixXor ^= A[i];
      
      //if prefixXor is equal to target
			if(prefixXor == target) count++;
      
      //if subarrayXor is equal to (prefixXor ^ target)
			int subarrayXor = prefixXor ^ target;
			if(prefixXorCount.containsKey(subarrayXor)) {
				int scount = prefixXorCount.get(subarrayXor);
				count += scount;
			}
			if(prefixXorCount.containsKey(prefixXor)) {
				prefixXorCount.put(prefixXor, prefixXorCount.get(prefixXor) + 1);
			}
			else {
				prefixXorCount.put(prefixXor, 1);
			}
		}
		return count;
	}
}
