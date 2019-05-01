package problems.problem_2;

public class ListNodeBuilder {
    public final ListNode node;

    public ListNodeBuilder(int val) {
        node = new ListNode(val);
    }

    public ListNodeBuilder push(int val) {
        ListNode n = node;
        while (n.next != null)
            n = n.next;
        n.next = new ListNode(val);
        return this;
    }

    public static int size(ListNode node) {
        int s = 0;
        if (node == null) return s;
        else s++;
        ListNode n = node.next;
        while (n != null) {
            s++;
            n = n.next;
        }
        return s;
    }

    public static String toString(ListNode node) {
        String s = "" + node.val;
        ListNode n = node.next;
        while (n != null) {
            s = s.concat("->" + n.val);
            n = n.next;
        }
        return s;
    }
}
