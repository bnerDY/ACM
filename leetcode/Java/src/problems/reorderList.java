package problems;

import problems.ADT.ListNode;

/**
 * Created by Martin on 06/03/2016.
 */
public class reorderList {

    public static void reorderList(ListNode head) {
        //TODO
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        ListNode test = new ListNode(1);
        test.next = new ListNode(2);
        test.next.next = new ListNode(3);
        test.next.next.next = new ListNode(4);

        reorderList(test);
        while (test != null) {
            System.out.println(test.val);
            test = test.next;
        }
    }
}
