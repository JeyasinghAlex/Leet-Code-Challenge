import java.util.HashSet;
import java.util.Set;

public class IntersectionOfTwoLinkedLists {


    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        ListNode a = headA;
        ListNode b = headB;

        while (a != b) {
            a = a == null ? headB : a.next;
            b = b == null ? headA : b.next;
        }
        return a;
    }


    private Set<ListNode> set = new HashSet<>();
    public ListNode getIntersectionNode_1(ListNode headA, ListNode headB) {

        addNode(headA);
        ListNode node = addNode(headB);
        if (node != null) {
            return node;
        }
        return null;
    }

    private ListNode addNode(ListNode node) {

        while (node != null) {
            if (set.contains(node)) {
                return node;
            }
            set.add(node);
            node = node.next;
        }
        return null;
    }
}
