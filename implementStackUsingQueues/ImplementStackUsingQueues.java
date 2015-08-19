package implementStackUsingQueues;

import java.util.ArrayList;
import java.util.List;

/**
 * Implement the following operations of a stack using queues.
 * push(x) -- Push element x onto stack.
 * pop() -- Removes the element on top of the stack.
 * top() -- Get the top element.
 * empty() -- Return whether the stack is empty.
 * @author Mengchao Zhong
 */
public class ImplementStackUsingQueues {

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
	List<Integer> queue = new ArrayList<Integer>();
	
    // Push element x onto stack.
    public void push(int x) {
        List<Integer> temp = new ArrayList<Integer>();
    	
        while(!queue.isEmpty()) {
    		temp.add(queue.remove(0));
    	}
        
        queue.add(x);
        
    	while(!temp.isEmpty()) {
    		queue.add(temp.remove(0));
    	}
    }

    // Removes the element on top of the stack.
    public void pop() {
    	queue.remove(0);
    }

    // Get the top element.
    public int top() {
        return queue.get(0);
    }

    // Return whether the stack is empty.
    public boolean empty() {
        return queue.isEmpty();
    }
}
