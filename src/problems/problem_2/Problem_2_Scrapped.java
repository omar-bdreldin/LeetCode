package problems.problem_2;

/**
 * You are given two non-empty linked lists representing two non-negative integers.
 * The digits are stored in reverse order and each of their nodes contain a single digit.
 * Add the two numbers and return it as a linked list.
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 */
public class Problem_2_Scrapped {

    /**
     * This solution will not work for number larger than max integer (overflow)
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null)
            return null;
        int n1 = listNodeToInteger(l1);
        int n2 = listNodeToInteger(l2);
        int sum = n1 + n2;
        ListNode sumNode = integerToListNode(sum);
        return sumNode;
    }

    private ListNode integerToListNode(int sum) {
        ListNodeBuilder builder = new ListNodeBuilder(sum % 10);
        while ((sum / 10) != 0) {
            sum /= 10;
            builder.push(sum % 10);
        }
        return builder.node;
    }

    private int listNodeToInteger(ListNode node) {
        int num = 0;
        int size = ListNodeBuilder.size(node);
        ListNode n = node;
        for (int i = 0; i < size && n != null; i++) {
            num += (n.val * Math.pow(10, i));
            n = n.next;
        }
        return num;
    }

}
