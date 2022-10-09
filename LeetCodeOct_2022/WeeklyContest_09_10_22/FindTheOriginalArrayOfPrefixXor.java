package WeeklyContest_09_10_22;

public class FindTheOriginalArrayOfPrefixXor {

    public int[] findArray(int[] pref) {

        int n = pref.length;
        int xor = 0;
        int temp = 0;


        for (int i = 0; i < n; ++i) {
            temp ^= pref[i];
            xor ^= temp;
            pref[i] = temp;
            temp = xor;
        }
        return pref;
    }

    public int[] findArrayUsingExtraSpace(int[] pref) {

        int n = pref.length;

        int[] ans = new int[n];

        for (int i = 0; i < n; ++i) {
            if (i == 0) {
                ans[i] = pref[i];
            }
            else {
                ans[i] = pref[i - 1] ^ pref[i];
            }
        }
        return ans;
    }

    public int[] findArrayUsingExtraSpace_1(int[] pref) {

        int n = pref.length;
        int xor = 0;
        int temp = 0;

        int[] ans = new int[n];

        for (int i = 0; i < n; ++i) {
            temp ^= pref[i];
            xor ^= temp;
            ans[i] = temp;
            temp = xor;
        }
        return ans;
    }
}
