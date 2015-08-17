package implementQueueUsingStacks;

import java.util.Stack;

/**
 * Implement the following operations of a queue using stacks.
 * push(x) -- Push element x to the back of queue.
 * pop() -- Removes the element from in front of queue.
 * peek() -- Get the front element.
 * empty() -- Return whether the queue is empty.
 * @author Mengchao Zhong
 */
public class ImplementQueueUsingStacks {

	/**
	 * Test case.
	 * @param args
	 */
	public static void main(String[] args) {
		// No valid testing data available 
	}

	/**
	 * Solution.
	 * @param x
	 */
	Stack<Integer> stack = new Stack<Integer>();
	
    // Push element x to the back of queue.
    public void push(int x) {
    	Stack<Integer> temp = new Stack<Integer>();
    	while(!stack.isEmpty()) {
    		temp.push(stack.pop());
    	}
    	stack.push(x);
    	while(!temp.isEmpty()) {
    		stack.push(temp.pop());
    	}
    }

    // Removes the element from in front of queue.
    public void pop() {
        stack.pop();
    }

    // Get the front element.
    public int peek() {
        return stack.peek();
    }

    // Return whether the queue is empty.
    public boolean empty() {
        return stack.isEmpty();
    }
}
