public class LinkedListCycle_II {

    public ListNode detectCycle(ListNode head) {

        ListNode slow = head;
        ListNode fast = head;
        ListNode start = head;

        while(fast != null && fast.next != null) {

            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {

                while (slow != start) {
                    slow = slow.next;
                    start = start.next;
                }
                return start;
            }
        }
        return null;
    }
}
