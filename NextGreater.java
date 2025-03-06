// In this problem, since we have to consider all the elements as right that comes right circularly, that means after the last element
// again go to first element in circular order, if the right greater element is not found yet. So in bruteforce running loop 
// inside loop, for element at i, there is a inner loop that runs from i+1 to back at i circularly, and compare every element, if 
// greater found adding it to result. 

// Time Complexity : O(n^2)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
// Bruteforce
class Solution {
    public int[] nextGreaterElements(int[] nums) {
        // Base case
        if (nums == null || nums.length == 0) {
            return new int[] {};
        }
        int n = nums.length;
        // Declare result array
        int[] result = new int[n];
        // Initially declare all values as -1
        Arrays.fill(result, -1); // Default to -1 if no greater element is found
        // Run a loop for all elements
        for (int i = 0; i < n; i++) {
            // For each, run a inner loop to search for next greater element
            // Search for the next greater element in circular manner
            // Doing till n+i bcoz we want to circularly check back by going to index 0
            // after last index
            for (int j = i + 1; j < n + i; j++) {
                // And for that doing mod. Eg. n=4, i=1, j=2,3,4 but nums[4] will give out of
                // bound, we want 4%4 that is it will go back to 0. So 2,3 and back to 0 again
                int index = j % n; // Circular indexing
                // Check for greater value
                if (nums[index] > nums[i]) {
                    // Add in result if found
                    result[i] = nums[index];
                    // And break
                    break;
                }
            }
        }
        // Return result
        return result;
    }
}

// In this approach, using a stack, if the smaller element is found pushing the
// index in the stack, else if the larger is found,
// adding the value in the result array
// Monotonic increasing stack

// Time Complexity : O(n)
// Space Complexity : O(n) stack space
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
class Solution {
    public int[] nextGreaterElements(int[] nums) {
        // Base case
        if (nums == null || nums.length == 0) {
            return new int[] {};
        }
        int n = nums.length;
        // Declare result array
        int[] result = new int[n];
        // Initially declare all values as -1
        Arrays.fill(result, -1);
        // Stack for storing the elements for process it later
        Stack<Integer> s = new Stack<>();
        // Run a loop for all elements till 2*n, bcoz we will circularly go back i.e 0
        // to 5 and again 0 to 5 for n=6
        for (int i = 0; i < 2 * n; i++) {
            // while stack is not empty and the current element at index i%n is greater than
            // the element at index on the top of the stack, keep popping and add value in
            // the result
            while (!s.isEmpty() && nums[i % n] > nums[s.peek()]) {
                int popped = s.pop();
                result[popped] = nums[i % n];
            }
            // Only add in stack if this is first time visiting this index
            if (i < n) {
                s.push(i);
            }

        }
        // Return result
        return result;
    }
}