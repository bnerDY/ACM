package problems;

import problems.ADT.ListNode;

/**
 * Created by Martin on 13/03/2016.
 */
public class deleteNodeInALinkedList {

    /**
     Write a function to delete a node (except the tail) in a singly linked list, given only access to that node.
     Supposed the linked list is 1 -> 2 -> 3 -> 4 and you are given the third node with value 3, the linked list should
     become 1 -> 2 -> 4 after calling your function.
     * @param node
     */

    public static void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        ListNode test = new ListNode(1);
        test.next = new ListNode(2);
        test.next.next = new ListNode(3);
        test.next.next.next = new ListNode(4);

        deleteNode(test.next);
        while (test != null) {
            System.out.println(test.val);
            test = test.next;
        }
    }
}
