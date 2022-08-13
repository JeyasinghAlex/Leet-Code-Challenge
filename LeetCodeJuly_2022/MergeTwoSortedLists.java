public class MergeTwoSortedLists {

    // Without using extra space:
    public ListNode mergeTwoLists_without_using_extra_space(ListNode l1, ListNode l2) {

        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }

        if (l1.val > l2.val) {
            ListNode temp = l1;
            l1 = l2;
            l2 = temp;
        }

        ListNode ans = l1;

        while (l1 != null && l2 != null) {

            ListNode temp = null;

            while (l1 != null && l1.val <= l2.val) {
                temp = l1;
                l1 = l1.next;
            }
            temp.next = l2;

            ListNode t = l1;
            l1 = l2;
            l2 = t;
        }
        return ans;
    }

    //using extra space:
    public ListNode mergeTwoLists_with_using_extra_space(ListNode list1, ListNode list2) {

        ListNode ans = new ListNode(0);
        ListNode node = ans;

        while (list1 != null && list2 != null) {

            int a = list1.val;
            int b = list2.val;

            if (a <= b) {
                node.next = new ListNode(a);
                list1 = list1.next;
            } else {
                node.next = new ListNode(b);
                list2 = list2.next;
            }
            node = node.next;
        }

        if (list1 != null) {
            node.next = list1;
        }
        if (list2 != null) {
            node.next = list2;
        }
        return ans.next;
    }
}
