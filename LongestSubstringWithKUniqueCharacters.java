// Question = https://workat.tech/problem-solving/practice/longest-substring-with-k-unique-characters
// Time = O(n), space = O(n)

class Solution {
	int longestSubstringWithKUniqueCharacters(String s, int k) {
		int left = 0, right = 0;
		int longest = -1;

    //Map contains kUnique Characters at a given point of time
		HashMap<Character, Integer> kUniqueChars = new HashMap();
		while(left <= right && right < s.length()) {

      //First we add right index char
			char cright = s.charAt(right);
			if(kUniqueChars.containsKey(cright)) {
				kUniqueChars.put(cright, kUniqueChars.get(cright) + 1);	
			}
			else {
				kUniqueChars.put(cright, 1);
			}
			right++;

      // After adding right index char, then we check for whether hashMap size got extended beyond k
      // If (size > k) then we remove elements from left index till (size <= k)
			while(kUniqueChars.size() > k) {
				char cleft = s.charAt(left);
				int count = kUniqueChars.get(cleft);
				if(count - 1 == 0) {
					kUniqueChars.remove(cleft);
				}
				else {
					kUniqueChars.put(cleft, count - 1);
				}
				left++;
			}
      
      // need to get longest when only size == k, if it less than/greater than we shouldn't calculate longest
			if(kUniqueChars.size() == k)
				longest = Math.max(longest, (right - left));
		}
		return longest;
	}
}
