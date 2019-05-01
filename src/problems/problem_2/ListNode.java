package problems.problem_2;

public class ListNode {
    public int val;
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

    public ListNode push(int val) {
        ListNode n = this;
        while (n.next != null)
            n = n.next;
        n.next = new ListNode(val);
        return this;
    }

    @Override
    public String toString() {
        String s = "" + val;
        ListNode n = next;
        while (n != null) {
            s = s.concat("->" + n.val);
            n = n.next;
        }
        return s;
    }
}
