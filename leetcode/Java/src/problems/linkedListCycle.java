package problems;

import problems.ADT.ListNode;

/**
 * Created by Martin on 09/04/2016.
 */
public class linkedListCycle {

    public static boolean hasCycle(ListNode head) {
        return true;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        n1.next = n2;
        n2.next = n3;
        n3.next = n1;
        while (n1.next != null){
            System.out.println(n1.val);
            n1 = n1.next;
        }

        System.out.println(hasCycle(n1));
    }
}
