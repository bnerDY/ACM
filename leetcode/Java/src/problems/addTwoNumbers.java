package problems;

import problems.ADT.ListNode;

/**
 * Created by Martin on 12/02/2016.
 */
public class addTwoNumbers {
    /**
     * You are given two linked lists representing two non-negative numbers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
     * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
     * Output: 7 -> 0 -> 8
     */


    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode res = new ListNode(0);
        ListNode p1 = l1, p2 = l2, p3 = res; //pointer

        while (p1 != null || p2 != null) {
            if (p1 != null) {
                carry += p1.val;
                p1 = p1.next;
            }

            if (p2 != null) {
                carry += p2.val;
                p2 = p2.next;
            }

            p3.next = new ListNode(carry % 10);
            p3 = p3.next;
            carry /= 10;
        }

        if (carry == 1) {
            p3.next = new ListNode(1);
        }
        return res.next;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);

        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);

        ListNode temp = addTwoNumbers(l1, l2);
        while (temp != null) {
            System.out.println(temp.val);
            temp = temp.next;
        }
    }
}
