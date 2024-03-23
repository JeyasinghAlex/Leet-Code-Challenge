public class MaxPointsOnLine {

    /**
     * https://stackoverflow.com/questions/3813681/checking-to-see-if-3-points-are-on-the-same-line
     */
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

                    if (isCollinear(p1[0], p1[1], p2[0], p2[1], p3[0], p3[1])) {
                        ++cnt;
                    }
                }
                ans = Math.max(ans, cnt);
            }
        }
        return ans;
    }

    private boolean isCollinear(int x1, int y1, int x2, int y2, int x3, int y3) {

        // (y1 - y2 / x1 - x2) == (y1 - y3 / x1 - x3)
        return (y1 - y2) * (x1 - x3) == (y1 - y3) * (x1 - x2);
    }

    public int maxPoints_1(int[][] points) {

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
