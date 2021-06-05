public class CountBinarySubstrings {


//    Approach #1: Group By Character [Accepted]
    public int countBinarySubstrings(String s) {
        int[] grp = new int[s.length()];
        int index = 0;
        grp[index] = 1;

        for (int i = 1; i < s.length(); ++i) {
            if (s.charAt(i - 1) != s.charAt(i)) {
                grp[++index] = 1;
            } else {
                grp[index]++;
            }
        }

        int ans = 0;
        for (int i = 1; i <= index; ++i) {
            ans += Math.min(grp[i - 1], grp[i]);
        }
        return ans;
    }

    public int countBinarySubString(String s) {

        int pre = 0, curr = 1, ans = 0;
        for (int i = 1; i < s.length(); ++i) {

            if (s.charAt(i - 1) != s.charAt(i)) {
                ans += Math.max(pre, curr);
                pre = curr;
                curr = 1;
            } else {
                curr++;
            }
        }
        return ans + Math.min(pre, curr);
    }
}
