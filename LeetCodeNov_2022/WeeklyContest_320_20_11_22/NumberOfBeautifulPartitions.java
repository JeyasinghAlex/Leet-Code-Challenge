package WeeklyContest_320_20_11_22;

public class NumberOfBeautifulPartitions {

    public int beautifulPartitions(String S, int k, int minLength) {
        char[] s = S.toCharArray();
        int n = s.length;
        final int mod = 1000000007;
        long[][] dp = new long[n+1][k+1];
        dp[0][0] = 1;
        boolean[] isp = new boolean[10];
        isp[2] = isp[3] = isp[5] = isp[7] = true;
        long[][] st = new long[3001][k+1];
        long[] cum = new long[k+1];
        for(int i = 0;i <= n;i++){
            for(int j = 0;j <= k;j++) {
                cum[j] += st[i][j];
                cum[j] %= mod;
            }
            if(i-1 >= 0 && !isp[s[i-1]-'0']){
                for(int j = 0;j < k;j++){
                    dp[i][j+1] = cum[j];
                    dp[i][j+1] %= mod;
                }
            }
            if(i < n && isp[s[i]-'0']){
                for(int j = 0;j <= k;j++) {
                    st[i + minLength][j] += dp[i][j];
                    st[i + minLength][j] %= mod;
                }
            }
        }

        return (int)dp[n][k];
    }
}
