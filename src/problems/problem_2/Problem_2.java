package problems.problem_2;

/**
 * You are given two non-empty linked lists representing two non-negative integers.
 * The digits are stored in reverse order and each of their nodes contain a single digit.
 * Add the two numbers and return it as a linked list.
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 */
public class Problem_2 {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null)
            return null;
        ListNode p1 = l1;
        ListNode p2 = l2;
        ListNodeBuilder sumBuilder = new ListNodeBuilder(-1);
        int holding = 0;
        while (p1 != null && p2 != null) {
            int sum = p1.val + p2.val + holding;
            if (sum > 9) {
                sumBuilder.push(sum - 10);
                holding = 1;
            } else {
                sumBuilder.push(sum);
                holding = 0;
            }
            p1 = p1.next;
            p2 = p2.next;
        }
        ListNode p3 = p1 == null ? p2 : p1;
        while (p3 != null) {
            int sum2 = p3.val + holding;
            if (sum2 > 9) {
                sumBuilder.push(sum2 - 10);
                holding = 1;
            } else {
                sumBuilder.push(sum2);
                holding = 0;
            }
            p3 = p3.next;
        }
        if (holding == 1) {
            sumBuilder.push(holding);
        }
        return sumBuilder.node.next;
    }
}
