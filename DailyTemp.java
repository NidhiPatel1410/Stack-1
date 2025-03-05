// In this approach, if the current index temperature is smaller than the temperature at the top of the stack, then adding the 
// current index to the stack, this way the order of the stack will always be increasing if we look from top to bottom. This is also,
// called monotonic increasing stack. When the index is greater we pop and in the result array at the stack index we update the 
// value with curr index - stack index.

// Time Complexity : O(n)
// Space Complexity : O(n) stack space 
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        // Base case
        if (temperatures == null || temperatures.length == 0) {
            return new int[] {};
        }
        // Stack
        Stack<Integer> s = new Stack<>();
        // Add the first element
        s.add(0);
        // Declare result array
        int[] result = new int[temperatures.length];
        // iterate
        for (int i = 1; i < temperatures.length; i++) {
            // While the s is not empty and current element is greater than the temp at top
            // of stack, keep on popping and adding the result to the result array
            while (!s.isEmpty() && temperatures[i] > temperatures[s.peek()]) {
                int popped = s.pop();
                result[popped] = i - popped;
            }
            // Else push the value and move
            s.push(i);
        }
        // Return result
        return result;
    }
}