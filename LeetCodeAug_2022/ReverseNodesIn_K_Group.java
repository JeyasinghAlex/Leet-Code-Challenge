public class ReverseNodesIn_K_Group {

    public ListNode reverseKGroup(ListNode head, int k) {

        int n = getLen(head);

        int[] arr = new int[n];

        ListNode node = head;

        for (int i = 0; node != null; ++i) {
            arr[i] = node.val;
            node = node.next;
        }

        for (int i = 0; i <= n - k; i = i + k) {
            reverse(i, i + k - 1, arr);
        }

        node = head;
        for (int i = 0; i < n; ++i) {
            node.val = arr[i];
            node = node.next;
        }
        return head;
    }

    private void reverse(int l, int r, int[] arr) {

        while (l < r) {
            int temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;
            ++l;
            --r;
        }
    }

    private int getLen(ListNode node) {
        int count = 0;
        while (node != null) {
            ++count;
            node = node.next;
        }
        return count;
    }
}
