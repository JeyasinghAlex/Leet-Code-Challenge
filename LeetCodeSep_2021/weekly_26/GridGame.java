package weekly_26;

public class GridGame {

    public static void main(String[] args) {
        int[][] arr = {{2, 5, 4}, {1, 5, 1}};
        System.out.println(new GridGame().gridGame(arr));
    }

    public long gridGame(int[][] a) {
        int m = a[0].length;
        long[] cum0 = new long[m+1];
        long[] cum1 = new long[m+1];
        for(int i = 0;i < m;i++){
            cum0[i+1] = cum0[i] + a[0][i];
            cum1[i+1] = cum1[i] + a[1][i];
        }
        long ans = Long.MAX_VALUE;
        for(int i = 0;i < m;i++){
            ans = Math.min(ans, Math.max(cum0[m] - cum0[i+1], cum1[i]));
        }
        return ans;
    }
}
