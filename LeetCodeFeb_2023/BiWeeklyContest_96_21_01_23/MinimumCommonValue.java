package BiWeeklyContest_96_21_01_23;

public class MinimumCommonValue {

    public int getCommon(int[] nums1, int[] nums2) {

        int n = nums1.length;
        int m = nums2.length;

        int i = 0;
        int j = 0;
        while (i < n && j < m) {

            if (nums1[i] == nums2[j]) {
                return nums1[i];
            }

            if (nums1[i] < nums2[j]) {
                ++i;
            } else {
                ++j;
            }
        }
        return -1;
    }
}
