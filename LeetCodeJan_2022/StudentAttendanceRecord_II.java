public class StudentAttendanceRecord_II {

    private static final int mod = (int) (1e9+7);
    public int checkRecord(int n){
        long[] P = new long[n+1]; //end with P w/o A
        long[] L = new long[n+1]; //end with L w/o A
        P[0] = P[1] = L[1] = 1;
        for(int i = 2; i <= n; i++){
            P[i] = (P[i-1] + L[i-1]) % mod;
            L[i] = (P[i-1] + P[i-2]) % mod;
        }
        long res = (P[n] + L[n]) % mod;
        //insert A
        for(int i = 0; i < n; i++){
            long s = ((P[i] + L[i])%mod * (P[n-i-1] + L[n-i-1])%mod )% mod;
            res = (res + s) % mod;
        }
        return (int) res;
    }
}
