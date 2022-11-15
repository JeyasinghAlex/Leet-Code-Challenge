package BiWeeklyContest_79_28_05_22;

import java.util.Arrays;

public class MaximumTotalImportanceOfRoads {

    public long maximumImportance(int n, int[][] roads) {
        int[] inDegree = new int[n];
        for(int[] r : roads){
            inDegree[r[0]]++;
            inDegree[r[1]]++;
        }
        Arrays.sort(inDegree);

        long ans = 0;
        for(int i = 0;i < n;i++){
            ans += (long)inDegree[i] * (i+1);
        }
        return ans;
    }
}
