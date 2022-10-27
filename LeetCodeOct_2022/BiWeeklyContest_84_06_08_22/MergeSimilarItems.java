package BiWeeklyContest_84_06_08_22;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeSimilarItems {

    public List<List<Integer>> mergeSimilarItems(int[][] items1, int[][] items2) {

        int[] arr = new int[1001];
        List<List<Integer>> ans = new ArrayList<>();

        for (int[] item : items1) {
            int v = item[0];
            int w = item[1];
            arr[v] += w;
        }
        for (int[] item : items2) {
            int v = item[0];
            int w = item[1];
            arr[v] += w;
        }

        for (int i = 1; i <= 1000; ++i) {
            if (arr[i] != 0) {
                ans.add(Arrays.asList(i, arr[i]));
            }
        }
        return ans;
    }
}
