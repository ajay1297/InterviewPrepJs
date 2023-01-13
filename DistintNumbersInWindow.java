// Question = https://workat.tech/problem-solving/practice/distinct-numbers-window
// Time - O(n), space - O(n)

class Solution {
	int[] distintNumbersInWindow(int[] A, int k) {
		int[] result = new int[A.length - k + 1];

    // Maintain window using HashMap
		HashMap<Integer, Integer> numbers = new HashMap();
		for(int i=0; i<k; i++) {
			if(numbers.containsKey(A[i])) {
				numbers.put(A[i], numbers.get(A[i]) + 1);
			}
			else {
				numbers.put(A[i], 1);
			}
		}
		result[0] = numbers.size();
		for(int i=k; i<A.length; i++) {
			int elementToBeRemoved = A[i-k];
			int elementToBeAdded = A[i];
      // Remove A[i-k] from the window
			int elementToBeRemovedCount = numbers.get(elementToBeRemoved);
			if(elementToBeRemovedCount - 1 == 0) {
				numbers.remove(elementToBeRemoved);
			}
			else {
				numbers.put(elementToBeRemoved, elementToBeRemovedCount - 1);
			}
      // Add A[i] to the window
			if(numbers.containsKey(elementToBeAdded)) {
				numbers.put(elementToBeAdded, numbers.get(elementToBeAdded) + 1);
			}
			else {
				numbers.put(elementToBeAdded, 1);
			}
			result[i-k+1] = numbers.size();
		}
		return result;
	}
}
