public class MergeKSortedLists {

    public ListNode mergeKLists(ListNode[] lists) {
        ListNode ans = null;
        for (ListNode node : lists) {
            ans = merge(ans, node);
        }
        return ans;
    }

    private ListNode merge(ListNode l1, ListNode l2) {

        ListNode node = new ListNode(0);
        ListNode temp = node;
        while (l1 != null && l2 != null) {

            int a = l1.val;
            int b = l2.val;
            if (a > b) {
                l2 = l2.next;
            } else {
                l1 = l1.next;
            }
            node.next = new ListNode(Math.min(a,b));
            node = node.next;
        }

        if (l1 == null) {
            node.next = l2;
        }
        if (l2 == null) {
            node.next = l1;
        }
        return temp.next;
    }
}
