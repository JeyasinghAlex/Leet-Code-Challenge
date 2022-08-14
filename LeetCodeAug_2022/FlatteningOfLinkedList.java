public class FlatteningOfLinkedList {

    class Node {
        int data;
        Node next;
        Node child;

        public Node(int data) {
            this.data = data;
            this.next = null;
            this.child = null;
        }
    }

    public Node flattenLinkedList(Node root) {

        if (root == null || root.next == null) {
            return root;
        }

        root.next = flattenLinkedList(root.next);

        Node mergeList = merge(root, root.next);

        return mergeList;
    }

    private Node merge(Node l1, Node l2) {

        Node node = new Node(0);
        Node temp = node;

        while (l1 != null && l2 != null) {

            if (l1.data <= l2.data) {
                temp.child = l1;
                temp = temp.child;
                l1 = l1.child;
            } else {
                temp.child = l2;
                temp = temp.child;
                l2 = l2.child;
            }
        }
        if (l1 == null) {
            temp.child = l2;
        }
        if (l2 == null) {
            temp.child = l1;
        }
        return node.child;
    }
}