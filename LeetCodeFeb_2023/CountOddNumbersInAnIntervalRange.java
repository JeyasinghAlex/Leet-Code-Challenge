public class CountOddNumbersInAnIntervalRange {

    public int countOdds(int low, int high) {

        int ans = 0;
        low = low % 2 == 0 ? low + 1 : low;
        high = high % 2 == 0 ? high - 1 : high;

        ans = (high - low) / 2 + 1;
        return ans;
    }
}
