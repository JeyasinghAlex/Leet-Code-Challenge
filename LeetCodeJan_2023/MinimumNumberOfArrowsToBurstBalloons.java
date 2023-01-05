import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MinimumNumberOfArrowsToBurstBalloons {

    public int findMinArrowShots(int[][] points) {

        int n = points.length;
        Arrays.sort(points, (a, b) -> Integer.compare(a[0], b[0]));
        int[] prev = points[0];
        int ans = 1;

        for (int i = 1; i < n; ++i) {

            int[] interval = points[i];
            if (prev[1] >= interval[0]) {
                prev[1] = Math. min(prev[1], interval[1]);
            } else {
                ++ans;
                prev = interval;
            }
        }
        return ans;
    }

    public int findMinArrowShots_1(int[][] points) {

        int n = points.length;
        Arrays.sort(points, (a, b) -> Integer.compare(a[0], b[0]));

        List<int[]> ans = new ArrayList<>();
        ans.add(points[0]);


        for (int i = 1; i < n; ++i) {

            int[] interval = points[i];
            int[] temp = ans.get(ans.size() - 1);
            if (temp[1] >= interval[0]) {
                temp[1] = Math. min(temp[1], interval[1]);
            } else {
                ans.add(interval);
            }
        }
        return ans.size();
    }
}
