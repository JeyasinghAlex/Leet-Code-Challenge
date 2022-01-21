public class KokoEatingBananas {

    public int minEatingSpeed(int[] piles, int h) {

        int left = 1;
        int right = 1;
        for (int pile : piles) {
            right = Math.max(right, pile);
        }

        while (left < right) {
            int mid = left + right >>> 1;
            if (caneat(piles, h, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }


    private boolean caneat(int[] piles, int h, int k) {
        for (int pile : piles) {
            h -= (1 + (pile - 1) / k);
        }
        return h >= 0;
    }
}
