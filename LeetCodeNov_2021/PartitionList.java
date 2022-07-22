public class PartitionList {

    public ListNode partition(ListNode head, int x) {

        ListNode first = new ListNode(0);
        ListNode second = new ListNode(0);
        ListNode firstHead = first;
        ListNode secondHead = second;

        while (head != null) {

            ListNode node = new ListNode(head.val);
            if (head.val < x) {
                firstHead.next = node;
                firstHead = node;
            } else {
                secondHead.next = node;
                secondHead = node;
            }
            head = head.next;
        }
        firstHead.next = second.next;
        return first.next;
    }

    public ListNode partition_1(ListNode head, int x) {

        int n = getLength(head);
        if (n <= 1) {
            return head;
        }

        int[] nums = new int[n];
        ListNode node = head;

        int idx = 0;
        while (node != null) {
            nums[idx++] = node.val;
            node = node.next;
        }

        for (int i = 0; i < n; ++i) {

            if (nums[i] < x) {

                int prev = i - 1;
                int val = nums[i];
                while (prev >= 0 && val < nums[prev] && nums[prev] >= x) {
                    nums[prev + 1] = nums[prev];
                    prev--;
                }

                nums[prev + 1] = val;
            }
        }

        node = head;
        for (int i = 0; i < n; ++i) {
            node.val = nums[i];
            node = node.next;
        }
        return head;
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
