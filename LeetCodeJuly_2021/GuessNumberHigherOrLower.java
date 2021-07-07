public class GuessNumberHigherOrLower {

    public int guessNumber(int n) {

        int lo = 0;
        int hi = n;
        while (lo <= hi) {
            int mid = lo + hi >>> 1;
            int pick = guess(mid);
            if (pick == 0)
                return mid;
            else if (pick > 0) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        return -1;
    }

    private int guess(int mid) {
        return 0;
    }
}
