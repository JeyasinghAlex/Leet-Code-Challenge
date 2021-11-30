public class SwappingNodesInLinkedList {

    public ListNode swapNodes(ListNode head, int k) {

        if (head == null) {
            return null;
        }

        int len = length(head);
        ListNode node = head;
        ListNode first = null;
        ListNode second = null;
        int count = 0;
        while (node != null) {
            ++count;
            if (count == k) {
                first = node;
            }
            if (count == len - k + 1) {
                second = node;
            }
            node = node.next;
        }
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
        return head;
    }

    private int length(ListNode node) {
        int count = 0;
        while (node != null) {
            node = node.next;
            ++count;
        }
        return count;
    }
}
