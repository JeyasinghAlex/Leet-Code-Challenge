public class NumberOfSubstringsWithOnly1s {

    public int numSub(String s) {

        int mod = (int) 1e9 + 7;
        int count = 0;
        int ans = 0;
        for (int i = 0; i < s.length(); ++i) {
            int num = s.charAt(i) - '0';
            count = num == 1 ? count + 1 : 0;
            ans = (ans + count) % mod;
        }
        return ans;
    }

    public int numSub_1(String s) {

        int mod = 1000000007;
        long ans = 0;
        long count = 0;
        for (int i = 0; i < s.length(); ++i) {

            int num = s.charAt(i) - '0';
            if (num == 1) {
                ++count;
            } else {
                ans += (count * (count + 1) / 2) % mod;
                count = 0;
            }
        }
        ans += (count * (count + 1) / 2);
        return (int) ans % mod;
    }
}
