package BiweeklyContest_1_10_22;

public class BitwiseXOROfAllPairings {

    public int xorAllNums(int[] nums1, int[] nums2) {

        int n1 = nums1.length;
        int n2 = nums2.length;

        int first = 0;
        int second = 0;
        int res = 0;

        for (int n : nums1) {
            first = first ^ n;
        }

        for (int n : nums2) {
            second = second ^ n;
        }

        for (int i = 0; i < n2; ++i) {
            res = res ^ first;
        }
        for (int i = 0; i < n1; ++i) {
            res = res ^ second;
        }
        return res;
    }

    public int xorAllNums_1(int[] nums1, int[] nums2) {

        int n1 = nums1.length;
        int n2 = nums2.length;

        int first = 0;
        int second = 0;
        int res = 0;

        for (int n : nums1) {
            first = first ^ n;
        }

        for (int n : nums2) {
            second = second ^ n;
        }

        if ((n1 & 1) == 1) {
            res = res ^ second;
        }
        if ((n2 & 1) == 1) {
            res = res ^ first;
        }
        return res;
    }
}
