package problems;

/**
 * Created by Martin on 26/02/2016.
 */
public class removeNthElementFromEndOfList {
    /**
     * LinkedList.
     */
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {

        if (head == null)
            return null;

        //get length of list
        ListNode p = head;
        int len = 0;
        while (p != null) {
            len++;
            p = p.next;
        }

        //if remove first node
        int fromStart = len - n + 1;
        if (fromStart == 1)
            return head.next;

        //remove non-first node
        p = head;
        int i = 0;
        while (p != null) {
            i++;
            if (i == fromStart - 1) {
                p.next = p.next.next;
            }
            p = p.next;
        }
        return head;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }
}
