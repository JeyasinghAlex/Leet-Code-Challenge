public class ValidPerfectSquare {


    public boolean isPerfectSquare(int num) {

        long lo = 0;
        long hi = num;
        while (lo <= hi) {

            long mid = lo + hi >>> 1;
            if (mid * mid == num) {
                return true;
            } else if (mid * mid < num) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        return false;
    }

    public boolean isPerfectSquare_1(int num) {

        double floor = Math.floor(Math.sqrt(num));
        double ceil = Math.ceil(Math.sqrt(num));
        return floor == ceil;
    }
}
