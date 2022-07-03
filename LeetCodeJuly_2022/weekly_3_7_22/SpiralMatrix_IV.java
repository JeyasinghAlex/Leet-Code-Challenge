package weekly_3_7_22;

import java.util.Arrays;

class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

public class SpiralMatrix_IV {

    public int[][] spiralMatrix(int m, int n, ListNode head) {

        int[][] ans = new int[m][n];
        int[][] dir = {{0, 1},{1, 0}, {0, -1}, {-1, 0}};
        int d = 0;
        for (int[] a : ans) {
            Arrays.fill(a, -1);
        }

        int r = 0;
        int c = 0;
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

    public int[][] spiralMatrix_1(int m, int n, ListNode head) {

        int[][] ans = new int[m][n];
        for (int[] a : ans) {
            Arrays.fill(a, -1);
        }

        int startRow = 0;
        int endRow = m - 1;
        int startCol = 0;
        int endCol = n - 1;

        while (head != null) {
            for (int i =  startCol; i <= endCol; ++i) {
                if (head != null) {
                    ans[startRow][i] = head.val;
                    head = head.next;
                }
            }
            ++startRow;
            for (int i = startRow; i <= endRow; ++i) {
                if (head != null) {
                    ans[i][endCol] = head.val;
                    head = head.next;
                }
            }
            --endCol;
            for (int i = endCol; i >= startCol; --i) {
                if (head != null) {
                    ans[endRow][i] = head.val;
                    head = head.next;
                }
            }
            --endRow;
            for (int i = endRow; i >= startRow; --i) {
                if (head != null) {
                    ans[i][startCol] = head.val;
                    head = head.next;
                }
            }
            ++startCol;
        }
        return ans;
    }
}
