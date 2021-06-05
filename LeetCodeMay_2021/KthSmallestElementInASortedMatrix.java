package LeetCodeMay_2021;

import java.util.PriorityQueue;
import java.util.Queue;

public class KthSmallestElementInASortedMatrix {

    public int kthSmallest(int[][] matrix, int k) {

        int row = matrix.length;
        int col = matrix[0].length;
        Queue<Integer> qu = new PriorityQueue<>();

        for (int i = 0; i < row; ++i) {
            for (int j = 0; j < col; ++j) {
                qu.offer(matrix[i][j]);
            }
        }
        int len = qu.size();
        int temp = 0;
        for (int i = 0; i < len; ++i) {
            if (!qu.isEmpty())
                 temp = qu.poll();
            if (i + 1 == k) {
                return temp;
            }
        }
        return temp;
    }
}
