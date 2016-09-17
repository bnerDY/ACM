package problems;

import java.util.Stack;

/**
 * Created by Martin on 17/09/2016.
 */

/**
 MinStack minStack = new MinStack();
 minStack.push(-2);
 minStack.push(0);
 minStack.push(-3);
 minStack.getMin();   --> Returns -3.
 minStack.pop();
 minStack.top();      --> Returns 0.
 minStack.getMin();   --> Returns -2.
 */
public class MinStack {

    private Stack<Integer>stack = null;
    private Stack<Integer>minStack= null;

    MinStack(){
        stack = new Stack<Integer>();
        minStack = new Stack<Integer>();
    }

    //这里注意向minStack里面放的时候这个== ******
    public void push(int x){
        stack.push(x);
        if( minStack.isEmpty() ||  x <= minStack.peek() )
            minStack.push(x);
    }

    public void pop(){
        int x = stack.pop();
        if( x == minStack.peek() )
            minStack.pop();
    }

    public int top(){
        return stack.peek();
    }

    public int getMin(){
        return minStack.peek();
    }
}
