import java.util.Stack;

public class PalindromeLinkedList {


//      Definition for singly-linked list.
      public static class ListNode {
          int val;
          ListNode next;
          ListNode() {}
          ListNode(int val) { this.val = val; }
          ListNode(int val, ListNode next) { this.val = val; this.next = next; }
      }

    public boolean isPalindrome(ListNode head) {

        if (head == null || head.next == null) {
            return true;
        }

        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = null;

        while (fast != null && fast.next != null)  {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        reverse(slow);
        prev.next = null;

        while (head != null) {
            if (head.val != ans.val) {
                return false;
            }
            head = head.next;
            ans = ans.next;
        }
        return true;
    }

    private ListNode ans = null;
    private void reverse(ListNode currNode) {

        if (currNode.next == null) {
            ans = currNode;
            return ;
        }

        reverse(currNode.next);
        ListNode nextNode = currNode.next;
        nextNode.next = currNode;
        currNode.next = null;
    }

    public boolean isPalindrome_1(ListNode head) {

        Stack<Integer> stack = new Stack<>();
        ListNode node = head;
        while (node != null) {
            stack.push(node.val);
            node = node.next;
        }

        while (head != null) {

            int data = stack.pop();
            if (head.val != data) {
                return false;
            }
            head = head.next;
        }
        return true;
    }

}