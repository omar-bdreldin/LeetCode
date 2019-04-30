package problems;

/**
 * You are given two non-empty linked lists representing two non-negative integers.
 * The digits are stored in reverse order and each of their nodes contain a single digit.
 * Add the two numbers and return it as a linked list.
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 */
public class Problem_2 {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        return null;
    }

    public class ListNode {
        public final int val;
        public ListNode next;

        public ListNode(int val) {
            this.val = val;
        }

        public int size() {
            int s = 1;
            ListNode n = next;
            while (n != null) {
                s++;
                n = next.next;
            }
            return s;
        }
    }
}
