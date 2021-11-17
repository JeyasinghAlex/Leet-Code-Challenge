public class SplitLinkedListInParts {

    public ListNode[] splitListToParts(ListNode head, int k) {

        int len = getLength(head);
        ListNode node = head;
        ListNode[] ans = new ListNode[k];

        int size = len / k;
        int rem = len % k;
        for (int i = 0; i < k && node != null; ++i) {
            ans[i] = node;
            for (int j = 0; j < size + (rem > 0 ? 1 : 0) - 1; ++j) {
                node = node.next;
            }
            ListNode temp = node.next;
            node.next = null;
            node = temp;
            rem--;
        }
        return ans;
    }

    private int getLength(ListNode node) {
        int len = 0;
        while (node != null) {
            ++len;
            node = node.next;
        }
        return len;
    }
}
