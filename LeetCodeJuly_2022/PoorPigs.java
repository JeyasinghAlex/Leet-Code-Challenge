public class PoorPigs {

    public int poorPigs(int buckets, int minutesToDie, int minutesToTest) {

        int cnt = minutesToTest / minutesToDie;
        cnt++;
        int ans = 0;
        int x = 1;
        while (x < buckets) {
            x *= cnt;
            ++ans;
        }
        return ans;
    }
}
