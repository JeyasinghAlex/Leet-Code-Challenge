public class MaximizeDistanceToClosestPerson {


    public int maxDistToClosest(int[] seats) {

        int n = seats.length;
        if (seats == null || seats.length == 0) {
            return -1;
        }
        int left = 0;
        int right = 0;
        int i = 0;
        int dist = 0;

        while (i < n) {

            while (i < n && seats[i] == 1) {
                ++i;
            }
            left = i;
            while (i < n && seats[i] == 0) {
                ++i;
            }
            right = i;

            if (left == 0 || right == n) {
                dist = Math.max(dist, right - left);
            } else {
                dist = Math.max((int) Math.ceil((right - left) / 2.0), dist);
            }
        }
        return dist;
    }

    public int maxDistToClosest_1(int[] seats) {

        int n = seats.length;
        int count = 0;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; ++i) {
            if (seats[i] == 0) {
                ++count;
            } else {
                if (count % 2 == 0) {
                    count = count / 2;
                } else {
                    count = count / 2 + 1;
                }
                max = Math.max(max, count);
                count = 0;
            }

        }

        max = Math.max(max, count);
        count = 0;
        for (int i = n - 1; i >= 0; --i) {
            if (seats[i] == 0) {
                ++count;
            } else {
                if (count % 2 == 0) {
                    count = count / 2;
                } else {
                    count = count / 2 + 1;
                }
                max = Math.max(max, count);
                count = 0;
            }
        }
        return Math.max(max, count);
    }
}
