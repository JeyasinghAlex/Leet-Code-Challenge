package BiWeeklyContest_94_24_12_22;

public class CountAnagrams {

    private long mod = (long) 1e9+7;
    public int countAnagrams(String s) {
        int n = s.length();
        long[] fact = new long[n+1];
        fact[0] = 1L;
        for(int i=1;i<=n;i++){
            fact[i] = fact[i-1]*i%mod;
        }
        String[] str = s.split(" ");
        long ans = 1;
        for(String t:str){
            int[] ch = new int[26];
            for(char c:t.toCharArray()){
                ch[c-'a']++;
            }
            long cur = 1;
            for(int a:ch){
                cur = cur *fact[a]%mod;
            }

            cur = fact[t.length()] * binpow(cur,mod-2) % mod;
            ans = ans * cur % mod;
        }
        return (int) ans;
    }

    private long binpow(long a, long b) {
        if (b == 0)
            return 1;
        long res = binpow(a, b / 2);
        res = res * res % mod;
        if (b % 2==1)
            return res * a % mod;
        else
            return  res;
    }
}
