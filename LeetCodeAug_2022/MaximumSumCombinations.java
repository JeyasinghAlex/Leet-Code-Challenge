import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class MaximumSumCombinations {

    public int[] solve(int[] A, int[] B, int C) {

        Queue<Integer> qu = new PriorityQueue<>();
        Arrays.sort(A);
        Arrays.sort(B);
        for (int i = A.length - 1; i >= 0; --i) {
            for (int j = B.length - 1; j >= 0; --j) {

                if (qu.size() < C) {
                    qu.offer(A[i] + B[j]);
                } else {
                    if (A[i] + B[j] > qu.peek()) {
                        qu.poll();
                        qu.offer(A[i] + B[j]);
                    }  else {
                        break;
                    }
                }
            }
        }

        int[] ans = new int[C];
        int idx = C - 1;
        while (!qu.isEmpty()) {
            ans[idx--] = qu.poll();
        }
        return ans;
    }
}
