import java.util.HashMap;

/**
 * Created by Martin on 01/02/2016.
 */
public class Main {


    //    Find the missing integer in an array of integers.
    public static int findMissInt(int[] A) {
        int sum = 0;
        int total = 0;
        for (int i = 0; i < A.length; i++) {
            sum += A[i];
        }
        total = (A[0] + A[A.length - 1]) * (A.length + 1) / 2;
        return total - sum;
    }

    //    given an array of numbers, find the 2 two largest numbers in the array
    public int[] findTwoLargest(int[] A) {
        int[] res = new int[2];

        return res;
    }

//    How it's implemented a HashMap?


    //    the two-sum problem
    //    Given an array of integers and a number, print all the pairs which would add up to that number.
    public int[] twoSum(int[] numbers, int target) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        int[] result = new int[2];
        for (int i = 0; i < numbers.length; i++) {
            if (map.containsKey(target - numbers[i])) {
                result[0] = map.get(target - numbers[i]) + 1;
                result[1] = i + 1;
                break;
            } else  //update index of numbers[i] to i, if there is duplicate, update to last index
                map.put(numbers[i], i);
            //if we are required to find first index of numbers[i] when there are duplicate, use below code
            //don't use above code
            //else if(!map.containsKey(numbers[i]))
            //map.put(numbers[i],i);
        }
        return result;
    }
//    Remove duplicates from an unsorted singly linked list.


//    Languages: Different between Java and C++, garbage collector in java (how it work),
//    static vs dynamic memory allocation - Data structures: Linked lists, queues, stacks, heap, trees -
//    OOP: polymorphism, design patterns that I used before - Algorithms: Sorting algorithms I know and there complexity,
//    how to search for a number in an array (sorted and not sorted cases) - Coding question: reverse a singly linked list
//    What is the role of the JVM ?

//    What are the primitive data types in Java? What is the JVM and the Garbage Collector? Implement a method to decide whether a string is palindrome or not.

//    What is Java Garbage Collection; Difference between an interface and an abstract class


    public static void main(String[] args) {
        // write your code here
        int[] test = {-1, 0, 1, 2, 3, 4, 5, 6, 8, 9};
        System.out.println(findMissInt(test));
    }
}
