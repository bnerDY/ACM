package problems;

/**
 * Created by Martin on 09/02/2016.
 */

public class reverseLinkedList {
    /**
     * Reverse a singly linked list.
     */
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null)
            return head;

        //get second node
        ListNode second = head.next;
        //set first's next to be null
        head.next = null;

        ListNode rest = reverseList(second);
        second.next = head;

        return rest;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }
}
