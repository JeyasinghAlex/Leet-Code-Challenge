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