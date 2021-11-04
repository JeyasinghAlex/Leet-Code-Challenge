public class LinkedListInBinaryTree {

    public boolean isSubPath(ListNode head, TreeNode root) {

        if (root == null) {
            return false;
        }

        if (head.val == root.val) {
            if (dfs(head, root)) {
                return true;
            }
        }
        return isSubPath(head, root.left) || isSubPath(head, root.right);
    }

    private boolean dfs(ListNode listNode, TreeNode node) {

        if (listNode == null) {
            return true;
        }

        if (node == null || (listNode.val != node.val)) {
            return false;
        }

        if (listNode.val == node.val) {
            listNode = listNode.next;
        }
        return dfs(listNode, node.left) || dfs(listNode, node.right);
    }
}