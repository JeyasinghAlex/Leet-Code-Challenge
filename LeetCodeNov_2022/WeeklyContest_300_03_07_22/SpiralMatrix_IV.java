package WeeklyContest_300_03_07_22;

import java.util.Arrays;

public class SpiralMatrix_IV {

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public int[][] spiralMatrix(int m, int n, ListNode head) {

        int[][] ans = new int[m][n];
        int[][] dir = {{0, 1},{1, 0}, {0, -1}, {-1, 0}};
        int d = 0;
        for (int[] a : ans) {
            Arrays.fill(a, -1);
        }

        int r = 0;
        int c = 0;
        int row = 0;
        int col = 0;
        while (head != null) {
            ans[r][c] = head.val;
            head = head.next;
            if (head == null) {
                break;
            }

            while (true) {
                int nr = r + dir[d][0];
                int nc = c + dir[d][1];
                if (nr >= 0 && nr < m && nc >= 0 && nc < n && ans[nr][nc] == -1) {
                    r = nr;
                    c = nc;
                    break;
                }
                d = (d + 1) % 4;
            }
        }
        return ans;
    }
}
