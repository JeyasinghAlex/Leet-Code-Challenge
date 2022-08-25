import java.util.ArrayList;
import java.util.List;

public class MinHeap {

    static class Node {

        int val;
        Node next;

        public Node(int val) {
            this.val = val;
            this.next = null;
        }
    }

    static int[] minHeap(int n, int[][] q) {

        Node head = null;
        List<Integer> list = new ArrayList<>();
        for (int[] arr : q) {

            if (arr[0] == 0) {
                Node node = new Node(arr[1]);

                if (head == null) {
                    head = node;
                }

                else if (node.val <= head.val) {
                    node.next = head;
                    head = node;
                }

                else {

                    Node temp = head;
                    Node prev = head;
                    while (temp != null && node.val > temp.val) {
                        prev = temp;
                        temp = temp.next;
                    }
                    node.next = temp;
                    prev.next = node;
                }

            } else {

                list.add(head.val);
                head = head.next;
            }
        }

        int[] ans = new int[list.size()];

        for (int i = 0; i < list.size(); ++i) {
            ans[i] = list.get(i);
        }
        return ans;
    }
}
