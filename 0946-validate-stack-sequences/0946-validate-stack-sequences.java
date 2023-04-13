class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        //we are trying to validate if a series of operations would have worked on a stack
        //best way to validate this is to run the sequence through a stack
        int n = pushed.length;
        Stack<Integer> stack = new Stack<>();
        
        //We must track which value needs to be popped before moving to the next
        int j = 0;
        
        //Loop through the pushed array to push all values into a stack
        //However if at any time the current popped value can be removed from the stack
        //Remove it and check for the next value in the popped array
        for (int x : pushed) {
            stack.push(x);
            while (!stack.isEmpty() && j < n && stack.peek() == popped[j]) {
                stack.pop();
                j++;
            }
        }
        
        //Return whether we were able to pop all the values
        return j == n;
    }
}