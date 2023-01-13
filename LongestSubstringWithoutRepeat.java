//https://workat.tech/problem-solving/practice/longest-substring-without-repeat
// Time - O(n), space = O(n)

/*
  abawxyz 
    substrings without repaet = ab, awxyz, bawxyz .... etc
*/
class Solution {
	int longestSubstringWithoutRepeat(String s) {
		Set<Character> set = new HashSet();
		int l=0, r=0;
    // We can maintain a window [l-r] which doesn't contains duplicates
		int maxLength = 0;
		while(l <= r && r < s.length()) {
      // Check whether r'th char is in window
      // Since we are checking from the start index, so if r'th char is present, then it'll be same as s'th char
      // So we remove s'th char and increment only l
			if(set.contains(s.charAt(r))) {
				set.remove(s.charAt(l));
				l++;
			}
			else {
				set.add(s.charAt(r));
				r++;
			}
			maxLength = Math.max(maxLength, r-l);
		}
		return maxLength;
	}
}
