package problems;

import java.util.Stack;

/**
 * Created by Martin on 17/09/2016.
 */

/**
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.getMin();   --> Returns -3.
 * minStack.pop();
 * minStack.top();      --> Returns 0.
 * minStack.getMin();   --> Returns -2.
 */
public class MinStack {

    private Stack<Integer> stack = null;
    private Stack<Integer> minStack = null;

    MinStack() {
        stack = new Stack<Integer>();
        minStack = new Stack<Integer>();
    }

    //这里注意向minStack里面放的时候这个== ******
    public void push(int x) {
        stack.push(x);
        if (minStack.isEmpty() || x <= minStack.peek())
            minStack.push(x);
    }

    public void pop() {
        int x = stack.pop();
        if (x == minStack.peek())
            minStack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }

    public static void main(String[] args) {
//		int[] input = {3,5,1,4,2};
//		MinStack minStack  = new MinStack();
//		for(int x: input)
//			minStack.push(x);
//
//		for(int i=0; i<input.length; i++){
//			System.out.println( "Top: "+minStack.top()+" Min:" + minStack.getMin());
//			minStack.pop();
//		}
        //top,pop,getMin,pop,getMin,pop,push(2147483647),top,getMin,push(-2147483648),top,getMin,pop,getMin
        MinStack minStack = new MinStack();
        minStack.push(2147483646);
        System.out.println(minStack.stack + "  " + minStack.minStack);

        minStack.push(2147483646);
        System.out.println(minStack.stack + "  " + minStack.minStack);

        minStack.push(2147483647);
        System.out.println(minStack.stack + "  " + minStack.minStack);

        minStack.top();
        System.out.println(minStack.stack + "  " + minStack.minStack);

        minStack.pop();
        System.out.println(minStack.stack + "  " + minStack.minStack);

        minStack.getMin();
        System.out.println(minStack.stack + "  " + minStack.minStack);

        minStack.pop();
        System.out.println(minStack.stack + "  " + minStack.minStack);

        minStack.getMin();
        System.out.println(minStack.stack + "  " + minStack.minStack);

        minStack.pop();
        System.out.println(minStack.stack + "  " + minStack.minStack);

        minStack.push(2147483647);
        System.out.println(minStack.stack + "  " + minStack.minStack);

        minStack.top();
        System.out.println(minStack.stack + "  " + minStack.minStack);

        minStack.getMin();
        System.out.println(minStack.stack + "  " + minStack.minStack);

        minStack.push(-2147483648);
        System.out.println(minStack.stack + "  " + minStack.minStack);

        minStack.top();
        System.out.println(minStack.stack + "  " + minStack.minStack);

        minStack.getMin();
        System.out.println(minStack.stack + "  " + minStack.minStack);

        minStack.pop();
        System.out.println(minStack.stack + "  " + minStack.minStack);

        minStack.getMin();
        System.out.println(minStack.stack + "  " + minStack.minStack);
    }//main
}
