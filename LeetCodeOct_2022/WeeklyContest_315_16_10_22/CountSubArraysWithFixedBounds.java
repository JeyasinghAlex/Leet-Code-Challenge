package WeeklyContest_315_16_10_22;

public class CountSubArraysWithFixedBounds {

    public long countSubarrays(int[] nums, int minK, int maxK) {

        int n = nums.length;

        if (minK > maxK) {
            return 0;
        }

        if (minK == maxK) {
            long ans = 0;
            int cnt = 0;

            for (int i = 0; i < n; ++i) {
                if (nums[i] == minK) {
                    ++cnt;
                } else {
                    cnt = 0;
                }
                ans = ans + cnt;
            }
            return ans;
        }

        boolean[] cut = new boolean[n];
        long ans = 0;
        for (int i = 0; i < n; ++i) {
            if (nums[i] < minK || nums[i] > maxK) {
                cut[i] = true;
            }
        }

        for (int i = 0; i < n; ) {

            int j = i;

            while (i < n && !cut[i]) {
                ++i;
            }

            if (j < i) {
                int p = j;
                int mx = 0;
                int mn = 0;

                for (int k = j; k < i; ++k) {
                    if(nums[k] == minK) {
                        ++mn;
                    }

                    if (nums[k] == maxK) {
                        ++mx;
                    }

                    while (mn > 0 && mx > 0) {
                        if (nums[p] == minK) {
                            --mn;
                        }

                        if (nums[p] == maxK) {
                            --mx;
                        }
                        ++p;
                    }

                    ans += (p - j);
                }
            }
            ++i;
        }
        return ans;
    }
}
