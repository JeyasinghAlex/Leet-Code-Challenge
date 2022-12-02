package WeeklyContest_321_27_11_22;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class RemoveNodesFromLinkedList {

    public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
   }

    public ListNode removeNodes(ListNode head) {
        List<ListNode> list = new ArrayList<>();

        while (head != null) {

            while (!list.isEmpty() && list.get(list.size() - 1).val < head.val) {
                list.remove(list.size() - 1);
            }
            list.add(head);
            head = head.next;
        }

        System.out.println(list.size());

        ListNode res = new ListNode(0);
        head = res;
        for (ListNode node : list) {
            res.next = node;
            res = res.next;
        }
        return head.next;
    }

    public ListNode removeNodes_1(ListNode head) {
        Stack<ListNode> st = new Stack<>();
        ListNode node = head;
        while (node != null) {

            while (!st.isEmpty() && st.peek().val < node.val) {
                st.pop();
            }
            st.push(node);
            node = node.next;
        }

        Stack<ListNode> temp = new Stack<>();
        while (!st.isEmpty()) {
            temp.push(st.pop());
        }

        ListNode ans = new ListNode(0);
        head = ans;
        while (!temp.isEmpty()) {
            ans.next = temp.pop();
            ans = ans.next;
        }
        return head.next;
    }
}
