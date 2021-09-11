public class CountNumberOfNiceSubarrays {

    public int numberOfSubarrays(int[] nums, int k) {

        int ans = 0;
        int odd = 0;
        int i = 0;
        int count = 0;

        for (int j = 0; j < nums.length; ++j) {

            if ((nums[j] & 1) == 1) {
                ++odd;
                if (odd >= k) {
                    count = 1;
                    while ((nums[i++] & 1) != 1) {
                        ++count;
                    }
                    ans += count;
                }
            } else if (odd >= k) {
                ans += count;
            }
        }
        return ans;
    }

    public int numberOfSubarrays_1(int[] nums, int k) {

        int i = -1;
        int j = findKthOdd(nums, k);
        int ans = 0;
        while (j < nums.length) {
            int nextI = nextOdd(nums, i);
            int nextJ = nextOdd(nums, j);
            ans += (nextI - i) * (nextJ - j);
            i = nextI;
            j = nextJ;
        }
        return ans;
    }

    private int nextOdd(int[] nums, int idx) {

        for (int i = idx + 1; i < nums.length; ++i) {
            if (nums[i] % 2 == 1) {
                return i;
            }
        }
        return nums.length;
    }

    private int findKthOdd(int[] nums, int k) {

        int count = 0;
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] % 2 == 1) {
                ++count;
                if (count == k) {
                    return i;
                }
            }
        }
        return nums.length;
    }
}
