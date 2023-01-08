public class MaxPointsOnLine {

    public int maxPoints(int[][] points) {

        int n = points.length;
        if (n <= 2) {
            return n;
        }

        int ans = 2;
        for (int i = 0; i < n; ++i) {
            for (int j = i + 1; j < n; ++j) {
                int cnt = 2;
                for (int k = j + 1; k < n; ++k) {
                    int[] p1 = points[i];
                    int[] p2 = points[j];
                    int[] p3 = points[k];

                    int x = (p2[1] - p1[1]) * (p3[0] - p1[0]);
                    int y = (p3[1] - p1[1]) * (p2[0] - p1[0]);

                    if (x == y) {
                        ++cnt;
                    }
                }
                ans = Math.max(ans, cnt);
            }
        }
        return ans;
    }
}
