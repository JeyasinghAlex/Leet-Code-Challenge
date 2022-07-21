public class ReverseLinkedList_II {


    public ListNode reverseBetween(ListNode head, int left, int right) {

        int n = getLength(head);
        if (n <= 1 || left == right) {
            return head;
        }

        int[] val = new int[n];

        ListNode temp = head;
        int idx = 0;

        while (temp != null) {
            val[idx++] = temp.val;
            temp = temp.next;
        }

        reverse(val, left - 1, right - 1);
        temp = head;
        for (int i = 0; i < n; ++i) {
            temp.val = val[i];
            temp = temp.next;
        }
        return head;
    }


    private void reverse(int[] arr, int left, int right) {

        while (left < right) {
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
    }

    private ListNode node;
    public ListNode reverseBetween_1(ListNode head, int left, int right) {

        int n = getLength(head);
        if (n <= 1 || left == right) {
            return head;
        }

        ListNode temp = head;
        node = new ListNode(0);
        ListNode tempNode = node;

        for (int i = 1; i <= n; ++i) {

            if (i >= left && i <= right) {
                ListNode newNode = new ListNode(temp.val);
                tempNode.next = newNode;
                tempNode = newNode;
            }
            temp = temp.next;
        }
        node = node.next;
        reverse(node);

        temp = head;
        ListNode l = null;
        ListNode r = null;

        for (int i = 1; i <= n; ++i) {

            if (i == left - 1) {
                l = temp;
            }
            if (i == right + 1) {
                r = temp;
            }
            temp = temp.next;
        }

        if (l != null)
            l.next = node;
        else {
            head = node;
        }

        temp = node;

        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = r;

        return head;
    }

    private void reverse(ListNode currNode) {

        if (currNode.next == null) {
            node = currNode;
            return;
        }
        reverse(currNode.next);
        ListNode nextNode = currNode.next;
        nextNode.next = currNode;
        currNode.next = null;
    }

    private int getLength(ListNode node) {
        int count = 0;
        while (node != null) {
            ++count;
            node = node.next;
        }
        return count;
    }
}
